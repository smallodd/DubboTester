package com.smallodd.dubbo.test.action;


import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.smallodd.dubbo.test.utils.PluginUtils;

import static com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR;

/**
 * Copyright ©2014-2019 Youzan.com All rights reserved
 * me.wbean.plugin.dubbo.invoker com.intellij.openapi.actionSystem.AnAction
 *
 * @author smallodd
 * @version 1.0.0
 * @date 2021.02.20 15:57
 * @since 1.0.0
 */
public class DubboTesterToolWindowOpenAnAction extends AnAction {

    /**
     * Action performed
     *
     * @param event e
     * @since 1.0.0
     */
    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();
        Editor editor = event.getData(EDITOR);
        PsiElement element = event.getData(CommonDataKeys.PSI_ELEMENT);

        if (PluginUtils.isAvailable(project, editor, element)) {
            PluginUtils.openToolWindow(project,
                                       element);
        }
    }

}
