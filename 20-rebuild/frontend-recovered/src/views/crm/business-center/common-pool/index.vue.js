import { _ as x, lv as S, x as k, o as b, G as j } from "../../../../shared/runtime.js";
import { c as D, _ as T } from "./module/distribution-dialog.vue.js";
import V from "./module/header.vue.js";
import { computed as C } from "vue";
import w from "moment";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as a } from "vue";
import { createVNode as o } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as f } from "vue";
import { unref as l } from "vue";
import { ElTooltip as F } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ref as h } from "vue";
import { Fragment as G } from "vue";
import { renderList as I } from "vue";
import { createBlock as L } from "vue";
import { normalizeStyle as P } from "vue";
import { i as g } from "../../../../modules/crm-c6ba92ff.js";
import "../../../../modules/use-crm-user-tree-f2f683a5.js";
import "../../../../modules/use-crm-project-information-18afe991.js";
const U = { class: "main-box" }, B = { class: "information-box" }, E = { key: 0, class: "text-ellipsis" }, M = { key: 1 }, Y = { class: "tag-box" }, q = { key: 0 }, A = { key: 1 }, H = { __name: "project-information-card", props: { recordNum: { type: [String, Number], default: "-" }, registerDate: { type: [String, Number, Date], default: /* @__PURE__ */ new Date() }, projectName: { type: String, default: "-" }, checkStatu: { type: String, default: "-" }, projectGrade: { type: String, default: "-" }, validityDays: { type: [Number, String], default: "-" }, trackingFrequency: { type: [String, Number], default: "-" }, currentState: { type: String, default: "-" }, status: { type: [Number, String], default: void 0 } }, setup(d) {
  const e = d, _ = C(() => w(e.registerDate).format("YYYY-MM-DD"));
  return (m, u) => {
    var p;
    const y = F, r = $;
    return s(), c("div", U, [n("div", B, [n("span", null, "备案号：" + a(e.recordNum), 1), n("span", null, "登记日期：" + a(_.value), 1), ((p = e.projectName) == null ? void 0 : p.length) > 24 ? (s(), c("span", E, [o(y, { class: "box-item", effect: "dark", content: e.projectName, placement: "top-start" }, { default: i(() => [n("span", null, "项目名称：" + a(e.projectName), 1)]), _: 1 }, 8, ["content"])])) : (s(), c("span", M, "项目名称：" + a(e.projectName), 1)), o(r, { type: "info", effect: "plain", class: "upper-right-tag" }, { default: i(() => [f("当前状态：" + a(e.currentState), 1)]), _: 1 }), n("div", Y, [o(r, { type: "success", effect: "plain" }, { default: i(() => [f("审核状态：" + a(e.checkStatu), 1)]), _: 1 }), o(r, { type: "danger", effect: "plain" }, { default: i(() => [f(" 项目等级：" + a(e.projectGrade), 1)]), _: 1 }), o(r, { type: "warning", effect: "plain" }, { default: i(() => [u[0] || (u[0] = n("span", null, "有效期剩余：", -1)), d.status === l(S).FOLLOW_UP_STATUS.V || d.status === l(S).FILING_STATUS.V ? (s(), c("span", q, a(e.validityDays) + " 天 ", 1)) : (s(), c("span", A, "-"))]), _: 1, __: [0] }), o(r, { type: "primary", effect: "plain" }, { default: i(() => [f("跟踪次数：" + a(e.trackingFrequency), 1)]), _: 1 })])])]);
  };
} }, O = x(H, [["__scopeId", "data-v-fdb501bc"]]), z = { class: "app-container" }, R = { style: { display: "flex", "flex-wrap": "wrap" } }, ae = { __name: "index", setup(d) {
  const { crud: e } = k({ title: "公共池", crudApi: { ...D }, permission: { ...g }, dataPath: "" }), { maxHeight: _ } = b({ extraBox: [".head-container"], paginate: false }), m = h(false), u = h({});
  function y(r) {
    j(g.detail) && (m.value = true, u.value = r);
  }
  return (r, p) => (s(), c("div", z, [o(V), n("div", { style: P(`overflow-y: auto; height: ${l(_)}px`) }, [n("div", R, [(s(true), c(G, null, I(l(e).data, (t, v) => {
    var N;
    return s(), L(O, { key: v, recordNum: t.serialNumber, registerDate: t.informantDateTime, projectName: t.projectName, currentState: (N = l(S).V[t.crmProjectScheduleTypeEnum]) == null ? void 0 : N.L, projectGrade: t.projectLevelConfigName, trackingFrequency: t.followUpTimes, onClick: (W) => y(t) }, null, 8, ["recordNum", "registerDate", "projectName", "currentState", "projectGrade", "trackingFrequency", "onClick"]);
  }), 128))])], 4), o(T, { modelValue: m.value, "onUpdate:modelValue": p[0] || (p[0] = (t) => m.value = t), "current-data": u.value, permission: l(g) }, null, 8, ["modelValue", "current-data", "permission"])]));
} };
export {
  ae as default
};
