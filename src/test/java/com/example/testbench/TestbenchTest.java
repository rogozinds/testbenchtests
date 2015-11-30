package com.example.testbench;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.annotations.RunLocally;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.parallel.ParallelTest;

//Firefox driver is by default
@RunLocally
public class TestbenchTest extends ParallelTest {
    public static final String baseUrl = "http://localhost:8080/example";

    @Test
    public void testClick() {
        getDriver().get(baseUrl + "?restartApplication");
        ButtonElement button = $(ButtonElement.class).caption("Click").first();
        LabelElement label = $(LabelElement.class).first();
        button.click();
        Assert.assertEquals(label.getText(), "Clicked");
    }
}
