import { _ as N, dp as O, l as P, j0 as f } from "../../../../../../../shared/runtime.js";
import { computed as x } from "vue";
import { inject as S } from "vue";
import { ref as s } from "vue";
import { watch as I } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as o } from "vue";
import { Fragment as b } from "vue";
import { renderList as w } from "vue";
import { toDisplayString as h } from "vue";
import { createVNode as r } from "vue";
import { normalizeStyle as T } from "vue";
import { unref as i } from "vue";
import { normalizeClass as E } from "vue";
import { createBlock as H } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as j } from "vue";
import { resolveDynamicComponent as $ } from "vue";
import { createCommentVNode as q } from "vue";
import { defineAsyncComponent as k } from "vue";
import { ElDivider as G } from "element-plus";
import { ElButton as J } from "element-plus";
import { ElTag as M } from "element-plus";
import { C as A } from "../../../../../../../modules/vue3-count-to.esm-8987f38d.js";
import { c as Q } from "../../../../../../../modules/cost-report-60aee68e.js";
import { d as U } from "../../../../../../../modules/upload-file-download-812f558c.js";
const W = [{ label: "累计收入", key: "totalIncome" }, { label: "累计支出", key: "totalExpenditure" }, { label: "毛利", key: "profit", color: "#15d24b" }], X = [{ label: "材料", key: "materialCost", color: "#a80505", subKey: "materialCostRatio", value: 1, title: "材料支出明细" }, { label: "分包", key: "subcontractCost", color: "#a80505", value: 1, title: "分包支出明细" }, { label: "租赁", key: "leaseCost", color: "#a80505", value: 1, title: "租赁支出明细" }, { label: "其他", key: "otherCost", color: "#a80505", value: 3, title: "其他支出明细" }, { label: "资金利息", key: "capitalInterest", color: "#a80505", notAllowed: true }, { label: "管理费", key: "managementFee", color: "#a80505", value: 2, title: "管理费支出明细" }];
const Y = { class: "report-container" }, Z = { class: "header-container box-container" }, ee = { class: "label" }, te = { class: "divider" }, oe = { class: "type-two" }, ae = ["onClick"], le = { class: "title-container" }, se = { class: "label" }, ne = { class: "percentage-text" }, re = { class: "box-container table-list-container" }, ce = { key: 0, class: "tag-container" }, ie = { __name: "index", setup(de) {
  const D = { 1: k(() => f(() => import("./Material-scienceTable.vue.js"), ["static/js/Material-scienceTable-87075a32.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/cost-report-60aee68e.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/css/Material-scienceTable-03e6a0a2.css"])), 2: k(() => f(() => import("./ManagementFeeTable.vue.js"), ["static/js/ManagementFeeTable-d3b7a9ee.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/cost-report-60aee68e.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/css/ManagementFeeTable-f4690807.css"])), 3: k(() => f(() => import("./OtherTable.vue.js"), ["static/js/OtherTable-d0e7cbd4.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/cost-report-60aee68e.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/css/OtherTable-a6e3f70a.css"])) }, R = x(() => D[u.value]), { projectInfo: _ } = S("parent_data"), u = s(), c = s({}), p = s(), v = s(false), g = s(""), F = (e, a) => {
    e != null && e.value && (g.value = a, u.value = e.value, p.value = e);
  }, V = x(() => p.value.title), C = async () => {
    try {
      c.value = await Q({ projectId: _.project.id });
    } catch (e) {
      console.log("获取报表信息失败" + e);
    }
  };
  C();
  const B = async () => {
    try {
      v.value = true, await U(_.project.id, (e) => P({ url: "/api/project/v2/costReport/costStatement", method: "get", responseType: "blob", headers: { Accept: "application/vnd.ms-excel", "Content-Type": "application/x-www-form-urlencoded" }, params: { projectId: e.id } }));
    } catch (e) {
      console.error("下载失败:downloadFileFn", e);
    } finally {
      v.value = false;
    }
  };
  I(() => _, (e) => {
    e.project.id && C();
  }, { deep: true });
  const m = s("");
  return I(() => g.value, (e, a) => {
    console.log(e), e !== a && (m.value = "animate__animated animate__fadeIn animate__faster", setTimeout(() => {
      m.value = "";
    }, 1e3));
  }), (e, a) => {
    const L = G, z = J, K = M;
    return l(), n(b, null, [o("div", Y, [o("div", Z, [(l(true), n(b, null, w(i(W), (t, y) => (l(), n("div", { key: y, class: "item-box" }, [o("span", ee, h(t.label), 1), r(i(A), { decimals: 2, duration: 2e3, "end-val": c.value[t.key], "start-val": 0, style: T({ color: t.color }), class: "card-panel-num" }, null, 8, ["end-val", "style"])]))), 128)), o("div", te, [r(L, { direction: "vertical", style: { height: "100%" } })]), o("div", oe, [(l(true), n(b, null, w(i(X), (t, y) => (l(), n("div", { key: y, class: E([t.notAllowed ? "notAllowed" : "", "item-box"]), onClick: (_e) => F(t, t.key) }, [o("div", le, [o("span", se, h(t.label), 1), o("span", ne, h(c.value[t == null ? void 0 : t.subKey] ? c.value[t == null ? void 0 : t.subKey] + "%" : ""), 1)]), r(i(A), { decimals: 2, duration: 2e3, "end-val": c.value[t.key] || 0, "start-val": 0, style: T({ color: t.color }), class: "card-panel-num" }, null, 8, ["end-val", "style"])], 10, ae))), 128))])])]), o("div", re, [(l(), H($(R.value), { class: E(m.value), "report-item": p.value }, { default: d(() => [r(O, { "header-title": V.value }, { headerRight: d(() => [r(z, { loading: v.value, icon: "el-icon-download", size: "default", type: "primary", onClick: B }, { default: d(() => a[0] || (a[0] = [j("下载 ")])), _: 1, __: [0] }, 8, ["loading"])]), _: 1 }, 8, ["header-title"])]), _: 1 }, 8, ["class", "report-item"]))]), u.value ? q("", true) : (l(), n("div", ce, [r(K, { size: "large", type: "primary" }, { default: d(() => a[1] || (a[1] = [j("* 点击分割线右侧标题查看费用详情")])), _: 1, __: [1] })]))], 64);
  };
} }, fe = N(ie, [["__scopeId", "data-v-211423a0"]]);
export {
  fe as default
};
