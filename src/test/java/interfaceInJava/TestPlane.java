package interfaceInJava;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static interfaceInJava.BasePlane.getPlanesList;

public class TestPlane {

    @Test
    public void checkFilterModel() {
        List<Plane> actualPlanes;
        getPlanesList().add(new Plane("Xgood", 1000, 10000, 100000));

        Predicate<Plane> predicate = plane -> plane.getModel().contains("X");
        actualPlanes = getPlanesList().stream().filter(predicate).collect(Collectors.toList());

        Assert.assertTrue(actualPlanes.size() > 0);
        actualPlanes.forEach(plane -> Assert.assertTrue(plane.getModel().contains("X")));
    }

    @Test
    public void checkFilterModelAndSpeed() {
        List<Plane> actualPlanes;
        getPlanesList().add(new Plane("Xgood", 100, 10000, 100000));

        Predicate<Plane> predicate = plane -> plane.getModel().contains("X");
        Predicate<Plane> planePredicate = plane -> plane.getSpeed() < 1000;
        actualPlanes = getPlanesList().stream().filter(predicate.and(planePredicate)).collect(Collectors.toList());

        Assert.assertTrue(actualPlanes.size() > 0);
        actualPlanes.forEach(plane -> {
            Assert.assertTrue(plane.getModel().contains("X"));
            Assert.assertTrue(plane.getSpeed() < 1000);
        });
    }

    @Test
    public void checkSupplier() {
        Supplier<List<Plane>> predicate = BasePlane::getPlanesList;

        Assert.assertEquals(predicate.get().size(), 15);
    }

    @Test
    public void checkSupplierPlane() {
        Supplier<Plane> planeSupplier = () -> getPlanesList().get(0);

        Assert.assertTrue(planeSupplier.get().getSpeed() < 1000000000);
    }

    @Test
    public void checkSetSpeed() {
        Consumer<List<Plane>> sleep = list -> {
            list.forEach(plane -> plane.setSpeed(1000));
        };

        sleep.accept(getPlanesList());

        getPlanesList().forEach(plane -> Assert.assertEquals(plane.getSpeed(), 1000));
    }

    @Test
    public void checkSetModel() {
        Consumer<List<Plane>> sleep = list -> {
            list.forEach(plane -> plane.setModel("My"));
        };

        sleep.accept(getPlanesList());

        getPlanesList().forEach(plane -> Assert.assertEquals(plane.getModel(), "My"));
    }

    @Test
    public void checkFunctionSpeed() {
        Function<List<Plane>, List<Integer>> function = list -> list.stream().map(Plane::getSpeed).collect(Collectors.toList());

        function.apply(getPlanesList()).forEach(speed -> Assert.assertTrue(speed < 1000000000));
    }


    @Test
    public void checkFunctionMax() {
        Function<List<Plane>, Long> function = list -> list.stream().map(Plane::getModel).filter(model -> model.contains("0i2195")).count();

        Assert.assertEquals(function.apply(getPlanesList()), 0);
    }
}
