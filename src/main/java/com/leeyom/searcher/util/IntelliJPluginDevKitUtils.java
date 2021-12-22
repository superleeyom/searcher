package com.leeyom.searcher.util;

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

import java.util.Optional;

/**
 * idea plugin dev kit
 *
 * @author leeyom.wang
 * @date 2021/12/22 2:39 PM
 */
public class IntelliJPluginDevKitUtils {

    public static String getCodeLanguage(AnActionEvent e) {
        Optional<PsiFile> psiFile = Optional.ofNullable(e.getData(LangDataKeys.PSI_FILE));
        return psiFile
                .map(PsiFile::getLanguage)
                .map(Language::getDisplayName)
                .map(String::toLowerCase)
                .map(lang -> "[" + lang + "]")
                .orElse("");
    }

    public static String getSelectedText(AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        return caretModel.getCurrentCaret().getSelectedText();
    }
}
