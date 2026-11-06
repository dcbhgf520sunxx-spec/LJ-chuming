import { c as C, d as L, _ as Y } from "./module/detail.vue.js";
import { _ as D, m as w, G as r, bN as v, L as A, i as _ } from "../../../../shared/runtime.js";
import { reactive as V } from "vue";
import P from "element-plus/es/locale/lang/zh-cn";
import { computed as y } from "vue";
import s from "moment";
import { watch as S } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as i } from "vue";
import { unref as o } from "vue";
import { createBlock as O } from "vue";
import { withCtx as h } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as g } from "vue";
import { createVNode as j } from "vue";
import { ElCalendar as B } from "element-plus";
import { normalizeClass as z } from "vue";
import { toDisplayString as c } from "vue";
import { ElConfigProvider as $ } from "element-plus";
import { a as u } from "../../../../modules/project-19a12d6b.js";
const G = { class: "app-container" }, U = { style: { height: "32px" } }, W = ["onClick"], q = { key: 0, style: { "margin-top": "6px" } }, J = { class: "journal-info" }, F = { class: "journal-info" }, H = { __name: "index", setup(K) {
  const N = V(P), { globalProjectId: p, globalProject: m } = w(["globalProjectId", "globalProject"]), e = V({ day: "", map: {}, list: [], info: {}, visible: false, date: /* @__PURE__ */ new Date() }), l = y(() => s(e.date).format("YYYY-MM"));
  S(() => l.value, (n, t) => {
    n !== t && (s(l.value).valueOf() > s().valueOf() || T());
  }, { deep: true, immediate: true });
  const k = y(() => s(l.value).startOf("month").valueOf()), x = y(() => {
    const n = s().valueOf(), t = s(l.value).endOf("month").valueOf();
    return t > n ? n : t;
  });
  function I() {
    e.list = [], e.map = {};
  }
  async function T() {
    var n;
    if (I(), !!r(u.get) && ((n = m.value) == null ? void 0 : n.businessType) === v.INSTALLATION.V) try {
      const t = { yearMonth: l.value, projectId: p.value }, { content: d = [] } = await C.get(t);
      e.list = d.map((a) => (a.day = s(a.constructionDate).format("YYYY-MM-DD"), e.map[a.day] = a, a));
    } catch (t) {
      console.log("施工日志: ", t);
    }
  }
  function M(n) {
    var t;
    ((t = m.value) == null ? void 0 : t.businessType) === v.INSTALLATION.V && (!r(u.detail) || !r(u.add) || s(n).valueOf() > s().valueOf() || (e.day = n, e.info = _(e.map[n]) && e.map[n] || {}, e.visible = true));
  }
  return (n, t) => {
    var d;
    return f(), b("div", G, [i("div", U, [o(r)(o(u).download) && ((d = o(m)) == null ? void 0 : d.businessType) === o(v).INSTALLATION.V ? (f(), O(A, { key: 0, params: { yearMonth: l.value, projectId: o(p) }, fn: o(L), style: { float: "right" } }, { default: h(() => t[2] || (t[2] = [E("批量下载施工日志")])), _: 1, __: [2] }, 8, ["params", "fn"])) : g("", true)]), j(o($), { locale: N }, { default: h(() => [j(o(B), { modelValue: e.date, "onUpdate:modelValue": t[0] || (t[0] = (a) => e.date = a) }, { "date-cell": h(({ data: a }) => [i("div", { class: z(["calendar-item", [o(s)(a.date).valueOf() < x.value && o(s)(a.date).valueOf() >= k.value ? o(_)(e.map[a.day]) ? "has-content" : "need" : "", a.isSelected ? "is-selected" : ""]]), onClick: (Q) => M(a.day) }, [i("span", null, c(a.day.split("-").slice(1).join("-")), 1), o(_)(e.map[a.day]) ? (f(), b("div", q, [i("div", J, c(e.map[a.day].morningWeather) + " | " + c(e.map[a.day].afternoonWeather), 1), i("div", F, c(e.map[a.day].morningTemperature) + " ℃ ~ " + c(e.map[a.day].afternoonTemperature) + " ℃", 1)])) : g("", true)], 10, W)]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["locale"]), o(r)(o(u).detail) ? (f(), O(o(Y), { key: 0, modelValue: e.visible, "onUpdate:modelValue": t[1] || (t[1] = (a) => e.visible = a), info: e.info, day: e.day, "project-id": o(p), onSuccess: T, activeMonth: l.value }, null, 8, ["modelValue", "info", "day", "project-id", "activeMonth"])) : g("", true)]);
  };
} }, ae = D(H, [["__scopeId", "data-v-9f3f7f32"]]);
export {
  ae as default
};
