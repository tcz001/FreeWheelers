package com.trailblazers.freewheelers.service;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ServiceResultTest {
    @Test
    public void shouldHaveErrorsWhenMapIsNotEmpty() {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("name", "Invalid name");
        assertTrue(new ServiceResult(errors, null).hasErrors());
    }

    @Test
    public void shouldNotHaveErrorsWhenMapIsEmpty() {
        Map<String, String> errors = new HashMap<String, String>();
        assertFalse(new ServiceResult(errors, null).hasErrors());
    }
}
