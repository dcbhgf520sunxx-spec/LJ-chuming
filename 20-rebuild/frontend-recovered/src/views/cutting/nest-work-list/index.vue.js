import { ref as b } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as n } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as o } from "vue";
import { createTextVNode as S } from "vue";
import { ElNotification as R } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { vLoading as z } from "element-plus";
import { c as A } from "../../../modules/nestList-abbaa81d.js";
import { x as E, o as H, G as v, P as T } from "../../../shared/runtime.js";
import q from "./module/header.vue.js";
import L from "../template/steel-plate-list.vue.js";
import M from "./module/task-scheduling/index.vue.js";
import { f } from "../../../modules/cutting-457c256f.js";
import "../template/detail.vue.js";
import "../../../modules/project-data-5e9d497a.js";
import "../../../modules/machine-10301ee2.js";
import "./module/machie/index.vue.js";
import "./module/preview/index.vue.js";
const G = { class: "app-container" }, O = { class: "head-container" }, ne = { __name: "index", setup(F) {
  const x = b(), g = b(false), c = b(), N = { add: false, edit: false, del: false, download: false }, { crud: h, columns: s } = E({ title: "套料工单", sort: [], permission: { ...f }, optShow: { ...N }, crudApi: { ...A }, hasPagination: true }, x), { maxHeight: W } = H({ wrapperBox: ".contractRecord", paginate: true, extraHeight: 40 }), _ = b(false);
  async function P(p) {
    c.value = p, g.value = true;
  }
  function C(p) {
    p.reportUrl !== null ? window.location.href = p.reportUrl : R({ title: "下载失败", message: "暂无套料成果 ", type: "error" });
  }
  function j(p) {
    c.value = p, _.value = true;
  }
  return (p, m) => {
    const l = $, w = k("common-button"), U = k("common-table"), V = z;
    return i(), B("div", G, [r("div", O, [d(t(q))]), D((i(), n(U, { ref_key: "tableRef", ref: x, data: t(h).data, "empty-text": t(h).emptyText, "max-height": t(W) - 50, style: { width: "100%" } }, { default: a(() => [d(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(s).visible("projectName") ? (i(), n(l, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目名称", "min-width": "130px" }, { default: a((e) => [r("span", null, u(e.row.projectName), 1)]), _: 1 })) : o("", true), t(s).visible("plateNum") ? (i(), n(l, { align: "center", key: "plateNum", prop: "plateNum", label: "钢板总数", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.plateNum), 1)]), _: 1 })) : o("", true), t(s).visible("distributionNum") ? (i(), n(l, { align: "center", key: "distributionNum", prop: "distributionNum", label: "排产数", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.distributionNum), 1)]), _: 1 })) : o("", true), t(s).visible("plateWeight") ? (i(), n(l, { align: "center", key: "plateWeight", prop: "plateWeight", label: "钢板总重", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.plateWeight), 1)]), _: 1 })) : o("", true), t(s).visible("distributionWeight") ? (i(), n(l, { align: "center", key: "distributionWeight", prop: "distributionWeight", label: "排产量", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.distributionWeight), 1)]), _: 1 })) : o("", true), t(s).visible("partNum") ? (i(), n(l, { align: "center", key: "partNum", prop: "partNum", label: "零件数", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.partNum), 1)]), _: 1 })) : o("", true), t(s).visible("distributionPartNum") ? (i(), n(l, { align: "center", key: "distributionPartNum", prop: "distributionPartNum", label: "已排零件数", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.distributionPartNum), 1)]), _: 1 })) : o("", true), t(s).visible("partWeight") ? (i(), n(l, { align: "center", key: "partWeight", prop: "partWeight", label: "零件重", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.partWeight), 1)]), _: 1 })) : o("", true), t(s).visible("distributionPartWeight") ? (i(), n(l, { align: "center", key: "distributionPartWeight", prop: "distributionPartWeight", label: "已排零件重", "min-width": "100px" }, { default: a((e) => [r("span", null, u(e.row.distributionPartWeight), 1)]), _: 1 })) : o("", true), t(v)(t(f).detail) ? (i(), n(l, { key: 9, fixed: "right", align: "center", label: "钢板清单", "min-width": "80px" }, { default: a((e) => [d(w, { icon: "el-icon-view", type: "primary", size: "default", onClick: (y) => P(e.row) }, null, 8, ["onClick"])]), _: 1 })) : o("", true), t(v)(t(f).Production) ? (i(), n(l, { key: 10, fixed: "right", align: "center", label: "操作", "min-width": "90px" }, { default: a((e) => [d(w, { onClick: (y) => j(e.row), type: "success", size: "default" }, { default: a(() => m[2] || (m[2] = [S("任务排产")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 1 })) : o("", true), t(v)(t(f).download) ? (i(), n(l, { key: 11, fixed: "right", align: "center", label: "套料成果", "min-width": "80px" }, { default: a((e) => [d(w, { disabled: e.row.reportUrl === null, icon: "el-icon-download", onClick: (y) => C(e.row), type: "warning", size: "default" }, null, 8, ["disabled", "onClick"])]), _: 1 })) : o("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[V, t(h).loading]]), d(t(T)), d(L, { "detail-data": c.value, visible: g.value, "onUpdate:visible": m[0] || (m[0] = (e) => g.value = e) }, null, 8, ["detail-data", "visible"]), d(t(M), { "detail-data": c.value, visible: _.value, "onUpdate:visible": m[1] || (m[1] = (e) => _.value = e) }, null, 8, ["detail-data", "visible"])]);
  };
} };
export {
  ne as default
};
