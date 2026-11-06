import { o as x } from "../../../../modules/attendance-report-ce8c4447.js";
import { n4 as p, G as b, n2 as n } from "../../../../shared/runtime.js";
import D from "./table-mode/index.vue.js";
import N from "./card-mode/index.vue.js";
import $ from "./component/overtime-config.vue.js";
import U from "./component/normal-config.vue.js";
import w from "./component/attendance-report.vue.js";
import { ref as s } from "vue";
import { provide as B } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { createBlock as l } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as r } from "vue";
import "./table-mode/module/header.vue.js";
import "./card-mode/module/day-detail.vue.js";
import "./component/overtime-form.vue.js";
import "../../../../modules/index-df3c71c0.js";
import "./component/day.vue.js";
import "./component/month.vue.js";
const R = { class: "app-container" }, j = { style: { display: "flex", "justify-content": "space-between", "align-items": "center" } }, h = { __name: "index", setup(z) {
  const a = s(p.FORM.V), d = s(false), v = s(false), _ = s([]), f = s(false);
  B("deptList", _);
  async function C() {
    try {
      const m = await x();
      _.value = m;
    } catch (m) {
      console.log(m);
    }
  }
  return C(), (m, e) => {
    const M = V("common-radio-button"), c = V("common-button");
    return i(), L("div", R, [k("div", j, [u(M, { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value = o), options: t(p).ENUM, type: "enum", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["modelValue", "options"]), k("div", null, [t(b)([...t(n).settingOvertime]) ? (i(), l(c, { key: 0, class: "filter-item", size: "mini", type: "warning", icon: "el-icon-setting", onClick: e[1] || (e[1] = (o) => d.value = true) }, { default: y(() => e[7] || (e[7] = [g(" 加班考勤 ")])), _: 1, __: [7] })) : r("", true), t(b)([...t(n).settingStand]) ? (i(), l(c, { key: 1, class: "filter-item", size: "mini", type: "success", icon: "el-icon-setting", onClick: e[2] || (e[2] = (o) => v.value = true) }, { default: y(() => e[8] || (e[8] = [g(" 常规考勤 ")])), _: 1, __: [8] })) : r("", true), t(b)([...t(n).get]) ? (i(), l(c, { key: 2, type: "primary", size: "default", class: "filter-item", onClick: e[3] || (e[3] = (o) => f.value = true), permission: t(n) }, { default: y(() => e[9] || (e[9] = [g(" 考勤表 ")])), _: 1, __: [9] }, 8, ["permission"])) : r("", true)])]), a.value === t(p).FORM.V ? (i(), l(D, { key: 0 })) : r("", true), a.value === t(p).CARD.V ? (i(), l(N, { key: 1 })) : r("", true), u(t($), { visible: d.value, "onUpdate:visible": e[4] || (e[4] = (o) => d.value = o) }, null, 8, ["visible"]), u(t(U), { visible: v.value, "onUpdate:visible": e[5] || (e[5] = (o) => v.value = o) }, null, 8, ["visible"]), u(w, { visible: f.value, "onUpdate:visible": e[6] || (e[6] = (o) => f.value = o), permission: t(n) }, null, 8, ["visible", "permission"])]);
  };
} };
export {
  h as default
};
