import { _ as i, bo as a, m } from "../../../../../shared/runtime.js";
import p from "./module/header.vue.js";
import _ from "./module/tab-table.vue.js";
import d from "./module/panel-table.vue.js";
import { u as l } from "../../../../../modules/use-monomer-area-change-do-01946f79.js";
import { reactive as u } from "vue";
import { watchEffect as f } from "vue";
import { watch as h } from "vue";
import { provide as I } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/project-production-statistics-850038ba.js";
const v = { class: "app-container" }, x = { class: "header-report-container" }, y = { class: "main-report-container" }, P = { __name: "index", setup(w) {
  const e = u({ monomerId: null, areaIdList: [], projectId: null, weightType: a.NET.V }), { globalProjectId: c } = m(["globalProjectId"]), { getProjectProductionHttp: s, getProjectProductionDetailHttp: n } = l();
  return f(() => {
    e.projectId = c.value, e.monomerId = null, e.areaIdList = [], e.weightType = a.NET.V;
  }), h(() => e.projectId, () => {
    s(e), n(e);
  }, { immediate: true }), I("commonQuery", e), (T, b) => (g(), j("div", v, [r("header", x, [t(o(p)), t(o(d))]), r("main", y, [t(o(_))])]));
} }, q = i(P, [["__scopeId", "data-v-59c1a859"]]);
export {
  q as default
};
