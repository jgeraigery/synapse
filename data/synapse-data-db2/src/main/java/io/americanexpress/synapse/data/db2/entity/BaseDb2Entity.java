/*
 * Copyright 2020 American Express Travel Related Services Company, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.americanexpress.synapse.data.db2.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * {@code BaseDb2Entity} is the parent entity for all DB2 tables. All common fields are located here.
 * @author tisla4
 */
@MappedSuperclass
public abstract class BaseDb2Entity {

    /**
     * The id of the entity.
     */
    @Id
    private Long id;

    /**
     * Gets the entity's id.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the entity's id.
     * @param id the id of this entity
     */
    public void setId(Long id) {
        this.id = id;
    }
}
