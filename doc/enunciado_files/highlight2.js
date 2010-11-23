/*

Syntax highlighting with language autodetection.
Compact version: only CPP and Java

URL:   http://softwaremaniacs.org/soft/highlight/
Author: Ivan Sagalaev <Maniac@SoftwareManiacs.Org>

Contributors:

- Peter Leonov <gojpeg@gmail.com> 
- Victor Karamzin <Victor.Karamzin@enterra-inc.com>
- Vsevolod Solovyov <vsevolod.solovyov@gmail.com>
- Anton Kovalyov <anton@kovalyov.net>
- Nikita Ledyaev <lenikita@yandex.ru>
- Marcelo Cohen <mflashbr@gmail.com>

License (BSD):

* Copyright (c) 2006, Ivan Sagalaev
* All rights reserved.
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*
*     * Redistributions of source code must retain the above copyright
*       notice, this list of conditions and the following disclaimer.
*     * Redistributions in binary form must reproduce the above copyright
*       notice, this list of conditions and the following disclaimer in the
*       documentation and/or other materials provided with the distribution.
*     * Neither the name of the University of California, Berkeley nor the
*       names of its contributors may be used to endorse or promote products
*       derived from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND ANY
* EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
* WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
* DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*/

var IDENT_RE = '[a-zA-Z][a-zA-Z0-9_]*';
var UNDERSCORE_IDENT_RE = '[a-zA-Z_][a-zA-Z0-9_]*';
var NUMBER_RE = '\\b\\d+(\\.\\d+)?';
var C_NUMBER_RE = '\\b(0x[A-Za-z0-9]+|\\d+(\\.\\d+)?)';

// Common modes
var APOS_STRING_MODE = {
  className: 'string',
  begin: '\'', end: '(^|[^\\\\])\'',
  relevance: 0
}
var QUOTE_STRING_MODE = {
  className: 'string',
  begin: '"', end: '(^|[^\\\\])"',
  relevance: 0
}
var C_LINE_COMMENT_MODE = {
  className: 'comment',
  begin: '//', end: '$',
  relevance: 0
}
var C_BLOCK_COMMENT_MODE = {
  className: 'comment',
  begin: '/\\*', end: '\\*/'
}
var HASH_COMMENT_MODE = {
  className: 'comment',
  begin: '#', end: '$'
}
var C_NUMBER_MODE = {
  className: 'number',
  begin: C_NUMBER_RE, end: '^',
  relevance: 0
}

var LANGUAGES = {}

/*

Java definition (с) Vsevolod Solovyov <vsevolod.solovyov@gmail.com>

*/
LANGUAGES.java  = {
  defaultMode: {
    lexems: [UNDERSCORE_IDENT_RE],
    contains: ['comment', 'string', 'class', 'number', 'javadoc', 'annotation'],
    keywords: {'false': 1, 'synchronized': 1, 'int': 1, 'abstract': 1, 'float': 1, 'private': 1, 'char': 1, 'interface': 1, 'boolean': 1, 'static': 1, 'null': 1, 'if': 1, 'const': 1, 'for': 1, 'true': 1, 'while': 1, 'long': 1, 'throw': 1, 'strictfp': 1, 'finally': 1, 'protected': 1, 'extends': 1, 'import': 1, 'native': 1, 'final': 1, 'implements': 1, 'return': 1, 'void': 1, 'enum': 1, 'else': 1, 'break': 1, 'transient': 1, 'new': 1, 'catch': 1, 'instanceof': 1, 'byte': 1, 'super': 1, 'class': 1, 'volatile': 1, 'case': 1, 'assert': 1, 'short': 1, 'package': 1, 'default': 1, 'double': 1, 'public': 1, 'try': 1, 'this': 1, 'switch': 1, 'continue': 1, 'throws': 1}
  },
  modes: [
    {
      className: 'class',
      lexems: [UNDERSCORE_IDENT_RE],
      begin: '(class |interface )', end: '{', 
      illegal: ':',
      keywords: {'class': 1, 'interface': 1},
      contains: ['inheritance', 'title']
    },
    {
      className: 'inheritance',
      begin: '(implements|extends)', end: '^',
      lexems: [IDENT_RE],
      keywords: {'extends': 1, 'implements': 1},
      relevance: 10
    },
    {
      className: 'title',
      begin: UNDERSCORE_IDENT_RE, end: '^'
    },
    {
      className: 'params',
      begin: '\\(', end: '\\)',
      contains: ['string', 'annotation']
    },
    C_NUMBER_MODE,
    APOS_STRING_MODE,
    QUOTE_STRING_MODE,
    C_LINE_COMMENT_MODE,
    {
      className: 'javadoc',
      begin: '/\\*\\*', end: '\\*/',
      relevance: 10
    },
    C_BLOCK_COMMENT_MODE,
    {
      className: 'annotation',
      begin: '@[A-Za-z]+', end: '^'
    }
  ]
};//java

LANGUAGES.cpp = {
  defaultMode: {
    lexems: [UNDERSCORE_IDENT_RE],
    illegal: '</',
    contains: ['comment', 'string', 'number', 'preprocessor'],
    keywords: {'false': 1, 'int': 1, 'float': 1, 'while': 1, 'private': 1, 'char': 1, 'catch': 1, 'export': 1, 'virtual': 1, 'operator': 1, 'sizeof': 1, 'dynamic_cast': 1, 'typedef': 1, 'const_cast': 1, 'const': 1, 'struct': 1, 'for': 1, 'static_cast': 1, 'union': 1, 'namespace': 1, 'unsigned': 1, 'long': 1, 'throw': 1, 'volatile': 1, 'static': 1, 'protected': 1, 'bool': 1, 'template': 1, 'mutable': 1, 'if': 1, 'public': 1, 'friend': 1, 'do': 1, 'return': 1, 'goto': 1, 'auto': 1, 'void': 1, 'enum': 1, 'else': 1, 'break': 1, 'new': 1, 'extern': 1, 'using': 1, 'true': 1, 'class': 1, 'asm': 1, 'case': 1, 'typeid': 1, 'short': 1, 'reinterpret_cast': 1, 'default': 1, 'double': 1, 'register': 1, 'explicit': 1, 'signed': 1, 'typename': 1, 'try': 1, 'this': 1, 'switch': 1, 'continue': 1, 'wchar_t': 1, 'inline': 1, 'delete': 1}
  },
  modes: [
    C_LINE_COMMENT_MODE,
    C_BLOCK_COMMENT_MODE,
    C_NUMBER_MODE,
    QUOTE_STRING_MODE,
    {
      className: 'string',
      begin: '\'', end: '[^\\\\]\'',
      illegal: '[^\\\\][^\']'
    },
    {
      className: 'preprocessor',
      begin: '#', end: '$'
    }
  ]
};//cpp

LANGUAGES.anima = {
  defaultMode: {
    lexems: [UNDERSCORE_IDENT_RE],
    illegal: '</',
    contains: ['comment', 'string', 'number', 'preprocessor'],
    keywords: {'begin': 1, 'end': 1, 'actors': 1, 'time': 1, 'actor': 1, 'pos': 1, 'rot': 1, 'scale': 1, 'interpolation': 1, 'interp': 1, 'linear': 1, 'quad': 1, 'circle': 1, 'rect': 1, 'tri': 1 }
  },
  modes: [
    C_LINE_COMMENT_MODE,
    C_BLOCK_COMMENT_MODE,
    C_NUMBER_MODE,
    QUOTE_STRING_MODE,
    {
      className: 'string',
      begin: '\'', end: '[^\\\\]\'',
      illegal: '[^\\\\][^\']'
    },
    {
      className: 'preprocessor',
      begin: '#', end: '$'
    }
  ]
};//anima

LANGUAGES.makefile = {
  defaultMode: {
    lexems: [UNDERSCORE_IDENT_RE],
    illegal: '</',
    contains: ['comment', 'string', 'number', 'preprocessor'],
    keywords: {'all': 1, 'clean': 1, 'depend': 1, '...': 1, 'testa': 1, 'pos': 1, 'rot': 1, 'scale': 1, 'interpolation': 1, 'interp': 1, 'linear': 1, 'quad': 1, 'circle': 1, 'rect': 1, 'tri': 1 }
  },
  modes: [
    HASH_COMMENT_MODE,
    C_NUMBER_MODE,
    QUOTE_STRING_MODE,
    {
      className: 'string',
      begin: '\'', end: '[^\\\\]\'',
      illegal: '[^\\\\][^\']'
    },
    {
      className: 'preprocessor',
      begin: '#', end: '$'
    }
  ]
};//makefile

function langRe(language, value, global) {
  var mode =  'm' + (language.case_insensitive ? 'i' : '') + (global ? 'g' : '');
  return new RegExp(value, mode);
}//re

for (var i in LANGUAGES) {
  var language = LANGUAGES[i];
  for (var key in language.modes) {
    if (language.modes[key].begin)
      language.modes[key].beginRe = langRe(language, language.modes[key].begin);
    if (language.modes[key].end)
      language.modes[key].endRe = langRe(language, language.modes[key].end);
    if (language.modes[key].illegal)
      language.modes[key].illegalRe = langRe(language, '^(?:' + language.modes[key].illegal + ')');
    language.defaultMode.illegalRe = langRe(language, '^(?:' + language.defaultMode.illegal + ')');
  }//for
}//for

var selected_languages = {};

function Highlighter(language_name, value) {
  currentMode = function(){
    return modes[modes.length - 1];
  }//currentMode
  
  function subMode(lexem) {
    if (!currentMode().contains)
      return null;
    for (var key in language.modes)
      if (contains(currentMode().contains, language.modes[key].className) && language.modes[key].beginRe.test(lexem))
        return language.modes[key];
    return null;
  }//subMode

  function endOfMode(mode_index, lexem) {
    if (modes[mode_index].end && modes[mode_index].endRe.test(lexem))
      return 1;
    if (modes[mode_index].endsWithParent) {
      var level = endOfMode(mode_index - 1, lexem);
      return level ? level + 1 : 0;
    }//if
    return 0;
  }//endOfMode
  
  function isIllegal(lexem) {
    if (!currentMode().illegalRe)
      return false;
    return currentMode().illegalRe.test(lexem);
  }//isIllegal

  function eatModeChunk(value, index) {
    if (!currentMode().terminators) {
      var terminators = [];
      
      if (currentMode().contains)
        for (var key in language.modes) {
          if (contains(currentMode().contains, language.modes[key].className) &&
              !contains(terminators, language.modes[key].begin))
            terminators[terminators.length] = language.modes[key].begin;
        }//for
      
      var mode_index = modes.length - 1;
      do {
        if (modes[mode_index].end && !contains(terminators, modes[mode_index].end))
          terminators[terminators.length] = modes[mode_index].end;
        mode_index--;
      } while (modes[mode_index + 1].endsWithParent);
      
      if (currentMode().illegal)
        if (!contains(terminators, currentMode().illegal))
          terminators[terminators.length] = currentMode().illegal;
      
      var terminator_re = '(' + terminators[0];
      for (var i = 0; i < terminators.length; i++)
        terminator_re += '|' + terminators[i];
      terminator_re += ')';
      currentMode().terminators = langRe(language, terminator_re);
    }//if
    value = value.substr(index);
    var match = currentMode().terminators.exec(value);
    if (!match) 
      return [value, '', true];
    if (match.index == 0)
      return ['', match[0], false];
    else
      return [value.substr(0, match.index), match[0], false];
  }//eatModeChunk
  
  function escape(value) {
    return value.replace(/&/gm, '&amp;').replace(/</gm, '&lt;').replace(/>/gm, '&gt;');
  }//escape
  
  function processKeywords(buffer) {
    var mode = currentMode();
    if (!mode.keywords || !mode.lexems)
      return escape(buffer);
    if (!mode.lexemsRe) {
      var lexems = [];
      for (var key in mode.lexems)
        if (!contains(lexems, mode.lexems[key]))
          lexems[lexems.length] = mode.lexems[key];
      var lexems_re = '(' + lexems[0];
      for (var i = 1; i < lexems.length; i++)
        lexems_re += '|' + lexems[i];
      lexems_re += ')';
      mode.lexemsRe = langRe(language, lexems_re, true);
    }//if
    var result = '';
    var last_index = 0;
    mode.lexemsRe.lastIndex = 0;
    var match = mode.lexemsRe.exec(buffer);
    while (match) {
      result += escape(buffer.substr(last_index, match.index - last_index));
      if (mode.keywords[language.case_insensitive ? match[0].toLowerCase() : match[0]]) {
        keyword_count++;
        result += '<span class="keyword">' + escape(match[0]) + '</span>';
      } else {
        result += escape(match[0]);
      }//if
      last_index = mode.lexemsRe.lastIndex;
      match = mode.lexemsRe.exec(buffer);
    }//while
    result += escape(buffer.substr(last_index, buffer.length - last_index));
    return result;
  }//processKeywords
  
  function processModeInfo(buffer, lexem, end) {
    if (end) {
      result += processKeywords(currentMode().buffer + buffer);
      return;
    }//if
    if (isIllegal(lexem))
      throw 'Illegal';
    var new_mode = subMode(lexem);
    if (new_mode) {
      currentMode().buffer += buffer;
      result += processKeywords(currentMode().buffer);
      if (new_mode.excludeBegin) {
        result += lexem + '<span class="' + new_mode.className + '">';
        new_mode.buffer = '';
      } else {
        result += '<span class="' + new_mode.className + '">';
        new_mode.buffer = lexem;
      }//if
      modes[modes.length] = new_mode;
      relevance += currentMode().relevance != undefined ? currentMode().relevance : 1;
      return;
    }//if
    var end_level = endOfMode(modes.length - 1, lexem);
    if (end_level) {
      currentMode().buffer += buffer;
      if (currentMode().excludeEnd) {
        result += processKeywords(currentMode().buffer) + '</span>' + lexem;
      } else {
        result += processKeywords(currentMode().buffer + lexem) + '</span>';
      }
      while (end_level > 1) {
        result += '</span>';
        end_level--;
        modes.length--;
      }//while
      modes.length--;
      currentMode().buffer = '';
      return;
    }//if
  }//processModeInfo

  function highlight(value) {
    var index = 0;
    language.defaultMode.buffer = '';
    for (var mode_info = eatModeChunk(value, index); index < value.length; mode_info = eatModeChunk(value, index)) {
      processModeInfo(mode_info[0], mode_info[1], mode_info[2]);
      index += mode_info[0].length + mode_info[1].length;
    }//for
    if(modes.length > 1)
      throw 'Illegal';
  }//highlight
  
  this.language_name = language_name;
  var language = LANGUAGES[language_name];
  var modes = [language.defaultMode];
  var relevance = 0;
  var keyword_count = 0;
  var result = '';
  try {
    highlight(value);
    this.relevance = relevance;
    this.keyword_count = keyword_count;
    this.result = result;
  } catch (e) {
    if (e == 'Illegal') {
      this.relevance = 0;
      this.keyword_count = 0;
      this.result = escape(value);
    } else {
      throw e;
    }//if
  }//try
}//Highlighter

function contains(array, item) {
  if (!array)
    return false;
  for (var key in array)
    if (array[key] == item)
      return true;
  return false;
}//contains

function blockText(block) {
  var result = '';
  for (var i = 0; i < block.childNodes.length; i++)
    if (block.childNodes[i].nodeType == 3)
      result += block.childNodes[i].nodeValue;
    else if (block.childNodes[i].nodeName == 'BR')
      result += '\n';
    else
      throw 'Complex markup';
  return result;
}//blockText

function initHighlight(block) {
  if (block.className.search(/\bno\-highlight\b/) != -1)
    return;
  try {
    blockText(block);
  } catch (e) {
    if (e == 'Complex markup')
      return;
  }//try
  var classes = block.className.split(/\s+/);
  for (var i = 0; i < classes.length; i++) {
    if (LANGUAGES[classes[i]]) {
      highlightLanguage(block, classes[i]);
      return;
    }//if
  }//for
  highlightAuto(block);
}//initHighlight

function highlightLanguage(block, language) {
  var highlight = new Highlighter(language, blockText(block));
  // See these 4 lines? This is IE's notion of "block.innerHTML = result". Love this browser :-/
  var container = document.createElement('div');
  container.innerHTML = '<pre><code class="' + block.className + '">' + highlight.result + '</code></pre>';
  var environment = block.parentNode.parentNode;
  environment.replaceChild(container.firstChild, block.parentNode);
}//highlightLanguage
    
function highlightAuto(block) {
  var result = null;
  var language = '';
  var max_relevance = 2;
  var relevance = 0;
  var block_text = blockText(block);
  for (var key in selected_languages) {
    var highlight = new Highlighter(key, block_text);
    relevance = highlight.keyword_count + highlight.relevance;
    if (highlight.keyword_count && relevance > max_relevance) {
      max_relevance = relevance;
      result = highlight;
    }//if
  }//for
  
  if(result) {
    // See these 4 lines? This is IE's notion of "block.innerHTML = result". Love this browser :-/
    var container = document.createElement('div');
    container.innerHTML = '<pre><code class="' + result.language_name + '">' + result.result + '</code></pre>';
    var environment = block.parentNode.parentNode;
    environment.replaceChild(container.firstChild, block.parentNode);
  }//if
}//highlightAuto

function initHighlighting() {
  if (initHighlighting.called)
    return;
  initHighlighting.called = true;
  if (arguments.length) {
    for (var i = 0; i < arguments.length; i++) {
      if (LANGUAGES[arguments[i]]) {
        selected_languages[arguments[i]] = LANGUAGES[arguments[i]];
      }//if
    }//for
  } else
    selected_languages = LANGUAGES;
  var pres = document.getElementsByTagName('pre');
  for (var i = 0; i < pres.length; i++) {
    if (pres[i].firstChild && pres[i].firstChild.nodeName == 'CODE')
      initHighlight(pres[i].firstChild);
  }//for
}//initHighlighting

function initHighlightingOnLoad() {
  var original_arguments = arguments;
  var handler = function(){initHighlighting.apply(null, original_arguments)};
  if (window.addEventListener) {
    window.addEventListener('DOMContentLoaded', handler, false);
    window.addEventListener('load', handler, false);
  } else if (window.attachEvent)
    window.attachEvent('onload', handler);
  else
    window.onload = handler;
}//initHighlightingOnLoad
