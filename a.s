    .globl _garble
_garble:
    enter $(8 * 68), $0
    movq %rdi, -8(%rbp)
    movq %rsi, -16(%rbp)
    movq -24(%rbp), %r10
    movq %r10, -16(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* $t3 = 0 */
    movq $0, %r10
    movq %r10, -24(%rbp)
    /* $t2 = $t3 */
    movq -24(%rbp), %r10
    movq %r10, -32(%rbp)
    /* nop */
    /* nop */
    /* $t5 = 0 */
    movq $0, %r10
    movq %r10, -40(%rbp)
    /* $t4 = $t5 */
    movq -40(%rbp), %r10
    movq %r10, -48(%rbp)
    /* nop */
    /* $t6 = 0 */
    movq $0, %r10
    movq %r10, -56(%rbp)
    /* $t4 = $t6 */
    movq -56(%rbp), %r10
    movq %r10, -48(%rbp)
    /* nop */
    /* $t7 = 0 */
    movq $0, %r10
    movq %r10, -64(%rbp)
    /* $t8 = $t0 == $t7 */
    /* jump $t8 */
    /* nop */
    /* $t9 = 0 */
    movq $0, %r10
    movq %r10, -72(%rbp)
    /* $t10 = $t1 == $t9 */
    /* $t11 = $t10 */
    movq -null(%rbp), %r10
    movq %r10, -80(%rbp)
    /* nop */
    /* $t12 = not $t11 */
    movq $1, %r11
    subq %r11, -88(%rdp)
    /* jump $t12 */
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* $t15 = 2 */
    movq $2, %r10
    movq %r10, -96(%rbp)
    /* $t16 = $t0 / $t15 */
    /* $t17 = 2 */
    movq $2, %r10
    movq %r10, -104(%rbp)
    /* $t18 = $t16 * $t17 */
    /* $t19 = $t0 - $t18 */
    /* $t13 = $t19 */
    movq -null(%rbp), %r10
    movq %r10, -112(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* $t20 = 2 */
    movq $2, %r10
    movq %r10, -120(%rbp)
    /* $t21 = $t1 / $t20 */
    /* $t22 = 2 */
    movq $2, %r10
    movq %r10, -128(%rbp)
    /* $t23 = $t21 * $t22 */
    /* $t24 = $t1 - $t23 */
    /* $t14 = $t24 */
    movq -null(%rbp), %r10
    movq %r10, -136(%rbp)
    /* nop */
    /* $t25 = 1 */
    movq $1, %r10
    movq %r10, -144(%rbp)
    /* $t26 = $t13 == $t25 */
    /* jump $t26 */
    /* nop */
    /* $t27 = 0 */
    movq $0, %r10
    movq %r10, -152(%rbp)
    /* $t28 = $t14 == $t27 */
    /* $t29 = $t28 */
    movq -null(%rbp), %r10
    movq %r10, -160(%rbp)
    /* nop */
    /* jump $t29 */
    /* nop */
    /* nop */
    /* nop */
    /* $t41 = 2 */
    movq $2, %r10
    movq %r10, -168(%rbp)
    /* $t42 = $t2 * $t41 */
    /* $t43 = 1 */
    movq $1, %r10
    movq %r10, -176(%rbp)
    /* $t44 = $t42 + $t43 */
    /* $t2 = $t44 */
    movq -null(%rbp), %r10
    movq %r10, -32(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* $t45 = 2 */
    movq $2, %r10
    movq %r10, -184(%rbp)
    /* $t46 = $t0 / $t45 */
    /* $t0 = $t46 */
    movq -null(%rbp), %r10
    movq %r10, -8(%rbp)
    /* nop */
    /* nop */
    /* $t47 = 2 */
    movq $2, %r10
    movq %r10, -192(%rbp)
    /* $t48 = $t1 / $t47 */
    /* $t1 = $t48 */
    movq -null(%rbp), %r10
    movq %r10, -16(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* $t49 = 1 */
    movq $1, %r10
    movq %r10, -200(%rbp)
    /* $t50 = $t4 + $t49 */
    /* $t4 = $t50 */
    movq -null(%rbp), %r10
    movq %r10, -48(%rbp)
    /* nop */
    /* nop */
    /* $t30 = 0 */
    movq $0, %r10
    movq %r10, -208(%rbp)
    /* $t31 = $t13 == $t30 */
    /* jump $t31 */
    /* nop */
    /* $t32 = 1 */
    movq $1, %r10
    movq %r10, -216(%rbp)
    /* $t33 = $t14 == $t32 */
    /* $t34 = $t33 */
    movq -null(%rbp), %r10
    movq %r10, -224(%rbp)
    /* nop */
    /* jump $t34 */
    /* nop */
    /* nop */
    /* nop */
    /* $t37 = 2 */
    movq $2, %r10
    movq %r10, -232(%rbp)
    /* $t38 = $t2 * $t37 */
    /* $t39 = 1 */
    movq $1, %r10
    movq %r10, -240(%rbp)
    /* $t40 = $t38 + $t39 */
    /* $t2 = $t40 */
    movq -null(%rbp), %r10
    movq %r10, -32(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* $t35 = 2 */
    movq $2, %r10
    movq %r10, -248(%rbp)
    /* $t36 = $t2 * $t35 */
    /* $t2 = $t36 */
    movq -null(%rbp), %r10
    movq %r10, -32(%rbp)
    /* nop */
    /* $t34 = false */
    movq $0, %r10
    movq %r10, -224(%rbp)
    /* $t29 = false */
    movq $0, %r10
    movq %r10, -160(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* $t52 = 0 */
    movq $0, %r10
    movq %r10, -256(%rbp)
    /* $t51 = $t52 */
    movq -256(%rbp), %r10
    movq %r10, -264(%rbp)
    /* nop */
    /* $t53 = 0 */
    movq $0, %r10
    movq %r10, -272(%rbp)
    /* $t54 = $t4 != $t53 */
    /* jump $t54 */
    /* nop */
    /* nop */
    /* nop */
    /* $t55 = 2 */
    movq $2, %r10
    movq %r10, -280(%rbp)
    /* $t56 = $t51 * $t55 */
    /* nop */
    /* nop */
    /* $t57 = 2 */
    movq $2, %r10
    movq %r10, -288(%rbp)
    /* $t58 = $t2 / $t57 */
    /* $t59 = 2 */
    movq $2, %r10
    movq %r10, -296(%rbp)
    /* $t60 = $t58 * $t59 */
    /* $t61 = $t2 - $t60 */
    /* $t62 = $t56 + $t61 */
    /* $t51 = $t62 */
    movq -null(%rbp), %r10
    movq %r10, -264(%rbp)
    /* nop */
    /* nop */
    /* $t63 = 2 */
    movq $2, %r10
    movq %r10, -304(%rbp)
    /* $t64 = $t2 / $t63 */
    /* $t2 = $t64 */
    movq -null(%rbp), %r10
    movq %r10, -32(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* $t65 = 1 */
    movq $1, %r10
    movq %r10, -312(%rbp)
    /* $t66 = $t4 - $t65 */
    /* $t4 = $t66 */
    movq -null(%rbp), %r10
    movq %r10, -48(%rbp)
    /* nop */
    /* nop */
    /* return $t51 */
    movq -264(%rdp), %rax
    leave
    ret
    /* nop */
    /* $t11 = false */
    movq $0, %r10
    movq %r10, -80(%rbp)
    leave
    ret
    .globl _main
_main:
    enter $(8 * 14), $0
    movq -40(%rbp), %r10
    movq %r10, 0(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* $t1 = 0 */
    movq $0, %r10
    movq %r10, -8(%rbp)
    /* $t0 = $t1 */
    movq -8(%rbp), %r10
    movq %r10, -16(%rbp)
    /* nop */
    /* $t2 = 40 */
    movq $40, %r10
    movq %r10, -24(%rbp)
    /* $t3 = $t0 < $t2 */
    /* jump $t3 */
    /* nop */
    /* nop */
    /* nop */
    /* nop */
    /* $t5 = call Symbol(readChar:func(TypeList()):int) () */
    /* $t4 = $t5 */
    movq -null(%rbp), %r10
    movq %r10, -32(%rbp)
    /* nop */
    /* nop */
    /* nop */
    /* $t6 = $t4 */
    movq -32(%rbp), %r10
    movq %r10, -40(%rbp)
    /* $t7 = 7 */
    movq $7, %r10
    movq %r10, -48(%rbp)
    /* nop */
    /* $t8 = $t7 + $t0 */
    /* $t9 = $t8 */
    movq -null(%rbp), %r10
    movq %r10, -56(%rbp)
    /* $t10 = call Symbol(garble:func(TypeList(int, int)):int) ($t6$t9) */
    /* $t11 = $t10 */
    movq -null(%rbp), %r10
    movq %r10, -64(%rbp)
    /* call Symbol(printChar:func(TypeList(int)):void) ($t11) */
    /* nop */
    /* nop */
    /* nop */
    /* $t12 = 1 */
    movq $1, %r10
    movq %r10, -72(%rbp)
    /* $t13 = $t0 + $t12 */
    /* $t0 = $t13 */
    movq -null(%rbp), %r10
    movq %r10, -16(%rbp)
    /* nop */
    /* nop */
    leave
    ret
