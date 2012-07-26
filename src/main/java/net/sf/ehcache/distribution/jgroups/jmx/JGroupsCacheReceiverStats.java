/**
 *  Copyright 2003-2010 Terracotta, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package net.sf.ehcache.distribution.jgroups.jmx;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Tracks JGroupsCacheReceiver Statistics
 * 
 * @author Eric Dalquist
 */
public class JGroupsCacheReceiverStats implements
        JGroupsCacheReceiverStatsMBean, JGroupsCacheReceiverStatsCounter {
    
    private final AtomicLong removeAllCount = new AtomicLong();
    private final AtomicRate removeAllRate = new AtomicRate(1, TimeUnit.SECONDS);
    
    private final AtomicLong removeExistingCount = new AtomicLong();
    private final AtomicRate removeExistingRate = new AtomicRate(1, TimeUnit.SECONDS);
    
    private final AtomicLong removeNotExistingCount = new AtomicLong();
    private final AtomicRate removeNotExistingRate = new AtomicRate(1, TimeUnit.SECONDS);
    
    private final AtomicLong putCount = new AtomicLong();
    private final AtomicRate putRate = new AtomicRate(1, TimeUnit.SECONDS);
    
    private final AtomicLong bootstrapRequestCount = new AtomicLong();
    private final AtomicLong bootstrapResponseCount = new AtomicLong();
    private final AtomicLong bootstrapCompleteCount = new AtomicLong();
    private final AtomicLong bootstrapIncompleteCount = new AtomicLong();
    
    
    /**
     * @inheritDoc
     */
    @Override
    public void countRemoveAll() {
        this.removeAllCount.incrementAndGet();
        this.removeAllRate.count();
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getRemoveAllCount() {
        return this.removeAllCount.get();
    }

    /**
     * @inheritDoc
     */
    @Override
    public double getRemoveAllRate() {
        return removeAllRate.getRate();
    }
    
    /**
     * @inheritDoc
     */
    @Override
    public void countRemoveExisting() {
        this.removeExistingCount.incrementAndGet();
        this.removeExistingRate.count();
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getRemoveExistingCount() {
        return this.removeExistingCount.get();
    }

    /**
     * @inheritDoc
     */
    @Override
    public double getRemoveExistingRate() {
        return this.removeExistingRate.getRate();
    }
    
    /**
     * @inheritDoc
     */
    @Override
    public void countRemoveNotExisting() {
        this.removeNotExistingCount.incrementAndGet();
        this.removeNotExistingRate.count();
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getRemoveNotExistingCount() {
        return this.removeNotExistingCount.get();
    }

    /**
     * @inheritDoc
     */
    @Override
    public double getRemoveNotExistingRate() {
        return this.removeNotExistingRate.getRate();
    }
    
    /**
     * @inheritDoc
     */
    @Override
    public void countPut() {
        this.putCount.incrementAndGet();
        this.putRate.count();
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getPutCount() {
        return this.putCount.get();
    }

    /**
     * @inheritDoc
     */
    @Override
    public double getPutRate() {
        return this.putRate.getRate();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void countBootstrapRequest() {
        this.bootstrapRequestCount.incrementAndGet();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void countBootstrapComplete() {
        this.bootstrapCompleteCount.incrementAndGet();        
    }

    /**
     * @inheritDoc
     */
    @Override
    public void countBootstrapIncomplete() {
        this.bootstrapIncompleteCount.incrementAndGet();        
    }

    /**
     * @inheritDoc
     */
    @Override
    public void countBootstrapResponse() {
        this.bootstrapResponseCount.incrementAndGet();        
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getBootstrapRequestCount() {
        return this.bootstrapRequestCount.get();
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getBootstrapCompleteCount() {
        return this.bootstrapCompleteCount.get();
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getBootstrapIncompleteCount() {
        return this.bootstrapIncompleteCount.get();
    }

    /**
     * @inheritDoc
     */
    @Override
    public long getBootstrapResponseCount() {
        return this.bootstrapResponseCount.get();
    }
}