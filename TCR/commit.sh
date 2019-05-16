#!/usr/bin/env bash
echo 'Commit Format: [TECH|FIX][Author]Working
        TECH: Represents new code.
        FIX: Represents fix the bug.

Example:
        [TECH][lyning]完成登录模块和单元测试
        [FIX][lyning]修复登录模块验证码匹配空指针异常'

# input tag
tags=[TECH,FIX]
until [[ "${tags[@]}" =~ "${tag}" ]]; do
    read -p "TECH | FIX: " tag
done

# input author
until [[ ! -z "${author}" ]]; do
    read -p "Author: " author
done

# commit message
until [[ ! -z "${msg}" ]]; do
    read -p "Working: " msg
done

# add && commit
git add . && git commit -m "[$tag][$author]$msg"