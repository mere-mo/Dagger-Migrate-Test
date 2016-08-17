package com.example.zhewang.daggermigratetest.feature_a;

import com.example.zhewang.daggermigratetest.BuildConfig;
import com.example.zhewang.daggermigratetest.Services;
import com.example.zhewang.daggermigratetest.modules.TestAppModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import dagger.Module;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Test for {@link TextServiceMock}
 */
@Config(sdk = 21, constants = BuildConfig.class)
@RunWith(RobolectricGradleTestRunner.class)
public class TextServiceMockTest {
    @Module(
            injects = TextServiceMockTest.class,
            includes = TestAppModule.class
    )
    static class TestModule {}

    @Inject
    TextServiceMock mSubject;

    @Before
    public void setup() {
        Services.initialize(new TestModule()).inject(this);
    }

    @Test
    public void getText_expectCorrect() {
        assertThat(mSubject.getText(), is("Mock"));
    }
}