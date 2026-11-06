import { ref as D } from "vue";
import { reactive as c } from "vue";
import { computed as k } from "vue";
import { watch as N } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as b } from "vue";
import { createBlock as V } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as g } from "vue";
import { unref as v } from "vue";
import { createTextVNode as d } from "vue";
import { createCommentVNode as U } from "vue";
import { createVNode as t } from "vue";
import { ElMessageBox as L } from "element-plus";
import { ElNotification as j } from "element-plus";
import { ElRadio as z } from "element-plus";
import { ElRadioGroup as A } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { ElForm as G } from "element-plus";
import { ElCard as H } from "element-plus";
import { e as I } from "../../../../../modules/nesting-cutting-config-6d0e9e39.js";
import { G as M, oX as P } from "../../../../../shared/runtime.js";
const J = { __name: "index", props: { originData: { type: Object, default: () => {
} } }, emits: ["ruleChange", "success"], setup(C, { emit: x }) {
  const R = D(false), w = D(), o = C, y = x, s = c({ codeRule: false, displayRule: false, teamDisplayRule: false }), l = c({ codeRule: false, displayRule: false, teamDisplayRule: false }), B = k(() => l.codeRule === s.codeRule && l.displayRule === s.displayRule && l.teamDisplayRule === s.teamDisplayRule);
  N(() => o.originData, () => {
    var _, e, r, u, m, i, p, f;
    s.codeRule = (_ = o.originData) != null && _.length ? o.originData[0].codeRule : false, s.displayRule = (e = o.originData) != null && e.length ? o.originData[0].displayRule : false, s.teamDisplayRule = (r = o.originData) != null && r.length ? (u = o.originData[0]) == null ? void 0 : u.teamDisplayRule : false, l.codeRule = (m = o.originData) != null && m.length ? o.originData[0].codeRule : false, l.displayRule = (i = o.originData) != null && i.length ? o.originData[0].displayRule : false, l.teamDisplayRule = (p = o.originData) != null && p.length ? (f = o.originData[0]) == null ? void 0 : f.teamDisplayRule : false;
  });
  const E = async () => {
    R.value = true, L.confirm("此修改将覆盖之前的展示规则，确定保存？", "温馨提示", { confirmButtonText: "确定", cancelButtonText: "取消", showClose: false }).then(async () => {
      await I({ ...l }), s.codeRule = l.codeRule, s.displayRule = l.displayRule, s.teamDisplayRule = l.teamDisplayRule, y("ruleChange", l), y("success"), j({ type: "success", message: "保存成功" }), R.value = false;
    }).catch(() => {
    });
  };
  return (_, e) => {
    const r = T("common-tip-button"), u = z, m = A, i = F, p = G, f = H;
    return b(), V(f, null, { header: a(() => [e[5] || (e[5] = g("span", null, "班组代号展示规则", -1)), v(M)([...v(P).editRule]) ? (b(), V(r, { key: 0, loading: R.value, disabled: B.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: E }, { default: a(() => e[4] || (e[4] = [d(" 保存 ")])), _: 1, __: [4] }, 8, ["loading", "disabled"])) : U("", true)]), default: a(() => [t(p, { modelValue: l, "onUpdate:modelValue": e[3] || (e[3] = (n) => l = n), "label-width": "100px" }, { default: a(() => [t(i, { label: "规则一" }, { default: a(() => [t(m, { modelValue: l.teamDisplayRule, "onUpdate:modelValue": e[0] || (e[0] = (n) => l.teamDisplayRule = n) }, { default: a(() => [t(u, { value: false }, { default: a(() => e[6] || (e[6] = [d("展示班组")])), _: 1, __: [6] }), t(u, { value: true }, { default: a(() => e[7] || (e[7] = [d("展示班组代号")])), _: 1, __: [7] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(i, { label: "规则二" }, { default: a(() => [t(m, { modelValue: l.codeRule, "onUpdate:modelValue": e[1] || (e[1] = (n) => l.codeRule = n), ref_key: "oneRuleRadio", ref: w }, { default: a(() => [t(u, { value: false }, { default: a(() => e[8] || (e[8] = [d("代号（班组）在前,零件编号在后")])), _: 1, __: [8] }), t(u, { value: true }, { default: a(() => e[9] || (e[9] = [d("代号（班组）在后，零件编号在前")])), _: 1, __: [9] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(i, { label: "规则三" }, { default: a(() => [t(m, { modelValue: l.displayRule, "onUpdate:modelValue": e[2] || (e[2] = (n) => l.displayRule = n) }, { default: a(() => [t(u, { value: false }, { default: a(() => e[10] || (e[10] = [d("括号展示")])), _: 1, __: [10] }), t(u, { value: true }, { default: a(() => e[11] || (e[11] = [d("横杠展示")])), _: 1, __: [11] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(i, { "label-width": "0" }, { default: a(() => e[12] || (e[12] = [g("span", { class: "form-item-tip" }, " 如果选择代号（班组）在前和横杠：A1-HL-1；如果选择代号（班组）在前和括号：（AI）HL-1。 ", -1), g("span", { class: "form-item-tip" }, " 一旦配置，适用于各种切割方式，喷码时和生产的零件排产零件编号展示。 ", -1)])), _: 1, __: [12] })]), _: 1 }, 8, ["modelValue"])]), _: 1 });
  };
} };
export {
  J as default
};
