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
package io.americanexpress.synapse.service.reactive.rest.controller;

import io.americanexpress.synapse.service.reactive.rest.service.BaseDeleteReactiveService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;

/**
 * {@code BaseDeleteReactiveController} is base class for delete mono controller. This controller handles DELETE
 *  method requests, but specifically for delete purposes.
 *  This controller returns a single object.
 * @param <S> an object extending the {@link BaseDeleteReactiveService}
 */
public abstract class BaseDeleteReactiveController<S extends BaseDeleteReactiveService> extends BaseController<S> {

    /**
     * Delete a single resource.
     *
     * @param headers the headers
     * @param identifier of the resource to be deleted
     */
    @DeleteMapping("/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(tags = "Delete Operation", summary = "Deletes a resource reactively")
    public Mono<ResponseEntity<Void>> delete(@RequestHeader HttpHeaders headers, @PathVariable String identifier) {
        logger.entry(identifier);

        var serviceResults = service.delete(headers, identifier);
        var responseEntity = serviceResults
                .map(res -> new ResponseEntity<Void>(HttpStatus.NO_CONTENT));

        logger.exit(responseEntity);

        return responseEntity;
    }
}
