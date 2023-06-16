package com.smallodd.dubbo.test;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.smallodd.dubbo.test.ui.ToolBarPanel;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Description: </p>
 *
 * @author smallodd
 * @version 1.0.0
 * @date 2021.02.20 15:57
 * @since 1.0.0
 */
public class DubboPanelToolWindow implements ToolWindowFactory {

    /**
     * Create tool window content
     *
     * @param project    project
     * @param toolWindow tool window
     * @since 1.0.0
     */
    @Override
    public void createToolWindowContent(@NotNull Project project,
                                        @NotNull ToolWindow toolWindow) {
        if (project.isDisposed() || toolWindow.isDisposed()) {
            return;
        }

        ToolBarPanel dubboPanel = new ToolBarPanel(project, toolWindow);
        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(dubboPanel, null, false);
        toolWindow.getContentManager().addContent(content);
    }

}
