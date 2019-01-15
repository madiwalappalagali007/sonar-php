/*
 * SonarQube PHP Plugin
 * Copyright (C) 2010-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.php.checks;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;
import org.sonar.php.tree.visitors.LegacyIssue;
import org.sonar.plugins.php.CheckVerifier;
import org.sonar.plugins.php.TestUtils;
import org.sonar.plugins.php.api.tests.PHPCheckTest;
import org.sonar.plugins.php.api.visitors.PHPCheck;
import org.sonar.plugins.php.api.visitors.PhpIssue;

public class TabCharacterCheckTest {

  @Test
  public void test() throws Exception {
    PHPCheck check = new TabCharacterCheck();

    List<PhpIssue> issue = ImmutableList.<PhpIssue>of(new LegacyIssue(check, "Replace all tab characters in this file by sequences of white-spaces."));
    PHPCheckTest.check(check, TestUtils.getCheckFile("TabCharacterCheck/TabCharacterCheck.php"), issue);
  }

  @Test
  public void test_ok() throws Exception {
    PHPCheck check = new TabCharacterCheck();
    CheckVerifier.verifyNoIssueIgnoringExpected(check, "TabCharacterCheck/TabCharacterCheck_ok.php");
  }
}
