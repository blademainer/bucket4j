/*
 * Copyright 2015 Vladimir Bukhtoyarov
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.github.bucket4j.mock;

import com.github.bucket4j.Bucket;
import com.github.bucket4j.BucketBuilder;

import java.util.ArrayList;
import java.util.List;

public enum BucketType {

    LOCAL {
        @Override
        public Bucket createBucket(BucketBuilder builder) {
            return builder.build();
        }
    },
    GRID {
        @Override
        public Bucket createBucket(BucketBuilder builder) {
            return builder.buildCustomGrid(new GridProxyMock());
        }
    };

    abstract public Bucket createBucket(BucketBuilder builder);

    public static List<Bucket> createBuckets(BucketBuilder builder) {
        List<Bucket> buckets = new ArrayList<>();
        for (BucketType type : values()) {
            Bucket bucket = type.createBucket(builder);
            buckets.add(bucket);
        }
        return buckets;
    }

}
