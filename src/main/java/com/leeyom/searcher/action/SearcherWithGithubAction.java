package com.leeyom.searcher.action;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.leeyom.searcher.util.IntelliJPluginDevKitUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author leeyom.wang
 * @date 2021/12/22 11:58 AM
 */
public class SearcherWithGithubAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        String codeLanguage = IntelliJPluginDevKitUtils.getCodeLanguage(e);
        String selectedText = IntelliJPluginDevKitUtils.getSelectedText(e);
        if (StringUtils.isBlank(selectedText)) {
            Messages.showInfoMessage("请选择你要搜索的内容", "温馨提示");
            return;
        }
        BrowserUtil.browse("https://github.com/search?l=" + codeLanguage + "&type=repositories&q=" + selectedText);
    }
}
