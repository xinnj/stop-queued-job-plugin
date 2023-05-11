package io.jenkins.plugins.stopqueuedjob;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.util.logging.Logger;

public class StopJobProperty extends JobProperty<Job<?, ?>> {
    private static final Logger LOG = Logger.getLogger(StopJobProperty.class.getName());

    private boolean stopSameJob;

    private boolean stopDownstreamJob;

    @DataBoundConstructor
    public StopJobProperty(boolean stopSameJob, boolean stopDownstreamJob) {
        this.stopSameJob = stopSameJob;
        this.stopDownstreamJob = stopDownstreamJob;
    }

    public boolean getStopSameJob() {
        return stopSameJob;
    }

    public boolean getStopDownstreamJob() {
        return stopDownstreamJob;
    }

    @Extension
    public static class DescriptorImpl extends JobPropertyDescriptor {
        @Override
        public String getDisplayName() {
            return Messages.DisplayName();
        }

        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            return true;
        }
    }
}
