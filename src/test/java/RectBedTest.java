
import garden_planner.model.RectBed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectBedTest {

    @Test
    void testGetArea() {
        RectBed rBed = new RectBed();

        Assertions.assertEquals(1, rBed.getArea());

        rBed.setWidth(2);
        rBed.setHeight(3);
        assertEquals(6, rBed.getArea());
    }

    @Test
    void testGetPerimeter() {
        RectBed rBed = new RectBed();

        Assertions.assertEquals(4, rBed.getPerimeter());

        rBed.setWidth(4);
        rBed.setHeight(2);
        assertEquals(12, rBed.getPerimeter());
    }

    @Test
    void testToString() {
        RectBed rBed = new RectBed();

        Assertions.assertEquals("Rectangle 0.00 0.00 1.00 1.00", rBed.toString());

        rBed.setLeft(1);
        rBed.setTop(2);
        rBed.setWidth(3);
        rBed.setHeight(4);
        assertEquals("Rectangle 1.00 2.00 3.00 4.00", rBed.toString());
    }

}
