package com.lh.commons.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonView;
import com.lh.commons.annotation.Views;
import lombok.Data;

import java.time.Instant;

@Data
public abstract class Audited {

    @JsonView({Views.Value.class})
    protected Long createdBy;

    protected Instant createdDate;

    protected Long lastModifiedBy;

    protected Instant lastModifiedDate;
}
