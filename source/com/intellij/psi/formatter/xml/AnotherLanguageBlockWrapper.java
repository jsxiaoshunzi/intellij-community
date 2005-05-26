package com.intellij.psi.formatter.xml;

import com.intellij.newCodeFormatting.*;
import com.intellij.lang.ASTNode;

import java.util.List;

import org.jetbrains.annotations.Nullable;

public class AnotherLanguageBlockWrapper extends AbstractXmlBlock{
  private final Block myOriginal;

  public AnotherLanguageBlockWrapper(final ASTNode node,
                                     final XmlFormattingPolicy policy,
                                     final Block original) {
    super(node, original.getWrap(), original.getAlignment(), policy);
    myOriginal = original;
  }

  public Indent getIndent() {
    return myOriginal.getIndent();
  }

  public boolean insertLineBreakBeforeTag() {
    return false;
  }

  public boolean removeLineBreakBeforeTag() {
    return false;
  }

  public boolean isTextElement() {
    return true;
  }

  protected List<Block> buildChildren() {
    return myOriginal.getSubBlocks();
  }

  @Nullable public SpaceProperty getSpaceProperty(Block child1, Block child2) {
    return myOriginal.getSpaceProperty(child1,  child2);
  }
}
