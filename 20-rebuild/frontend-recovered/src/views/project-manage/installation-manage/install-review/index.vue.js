import { ref as x } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as d } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { withCtx as s } from "vue";
import { createBlock as y } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as O } from "vue";
import { Fragment as P } from "vue";
import { createElementVNode as U } from "vue";
import { toDisplayString as L } from "vue";
import { ElMessageBox as C } from "element-plus";
import { ElNotification as T } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElTag as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { l as R, _ as K, m as W, x as J, o as Y, tY as E, G as I, tQ as $, D as X, P as Z, c3 as M } from "../../../../shared/runtime.js";
import { s as h } from "../../../../modules/project-19a12d6b.js";
import ee from "./module/header.vue.js";
import "../../../../modules/subcontract-supplier-select-bab9e7f8.js";
function te(u) {
  return R({ module: "project", url: "install-report/pcCanExamine/page", method: "get", params: u });
}
function N(u, m) {
  return R({ module: "project", url: "install-report/check/appV2", method: "post", params: u, data: m });
}
const oe = { get: te };
const ae = { class: "app-container" }, re = { key: 0 }, ne = { key: 1 }, le = { __name: "index", setup(u) {
  const { globalProjectId: m, globalProject: g } = W(["globalProjectId", "globalProject"]), S = { add: false, edit: false, del: false, download: false }, B = x([["createTime", "parse-time"]]), w = x(), { crud: a, CRUD: b } = J({ title: "安装审核", sort: [], permission: { ...h }, optShow: { ...S }, crudApi: { ...oe }, requiredQuery: ["projectId", "productType"], hasPagination: true }, w), { maxHeight: V } = Y({ paginate: true, extraHeight: 40 });
  async function Q() {
    var l;
    try {
      await C.confirm("您选择了批量驳回，一旦确认将视为无效安装，请确认？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const o = (l = a.selections) == null ? void 0 : l.map((i) => ({ id: i.id, auditStatus: M.REJECT.V }));
      await N({ projectId: a.query.projectId }, o), T({ title: "批量驳回操作成功", type: "success", duration: 3e3 }), a.toQuery();
    } catch (o) {
      console.log(o, "批量驳回操作失败");
    }
  }
  async function q() {
    var l;
    try {
      await C.confirm("您选择了批量通过，一旦保存将视为安装，请确认？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const o = (l = a.selections) == null ? void 0 : l.map((i) => ({ id: i.id, auditStatus: M.PASS.V }));
      await N({ projectId: a.query.projectId }, o), T({ title: "批量通过操作成功", type: "success", duration: 3e3 }), a.toQuery();
    } catch (o) {
      console.log(o, "批量通过操作失败");
    }
  }
  return b.HOOK.beforeRefresh = () => (a.query.projectId = m.value || void 0, !!a.query.projectId), b.HOOK.handleRefresh = (l, { data: o }) => {
    o.content.forEach((i) => {
    });
  }, (l, o) => {
    var k, v;
    const i = j("common-button"), r = z, A = j("common-table"), D = F, H = G;
    return n(), d("div", ae, [((k = e(g)) == null ? void 0 : k.installReportMethod) === e(E).APP.V ? (n(), d("div", re, [t(e(ee), { projectId: e(m), globalProject: e(g) }, { opeBtn: s(() => {
      var c, p;
      return [e(I)(e(h).batchReject) ? (n(), y(i, { key: 0, type: "danger", size: "default", disabled: !((c = e(a).selections) != null && c.length), onClick: Q }, { default: s(() => o[0] || (o[0] = [_(" 批量驳回 ")])), _: 1, __: [0] }, 8, ["disabled"])) : f("", true), e(I)(e(h).batchPass) ? (n(), y(i, { key: 1, type: "success", size: "default", disabled: !((p = e(a).selections) != null && p.length), onClick: q }, { default: s(() => o[1] || (o[1] = [_(" 批量通过 ")])), _: 1, __: [1] }, 8, ["disabled"])) : f("", true)];
    }), _: 1 }, 8, ["projectId", "globalProject"]), O((n(), y(A, { ref_key: "tableRef", ref: w, data: e(a).data, "data-format": B.value, "empty-text": e(a).emptyText, "max-height": e(V), style: { width: "100%", "margin-top": "10px" }, stripe: false, onSelectionChange: e(a).selectionChangeHandler }, { default: s(() => [t(r, { type: "selection", align: "center", width: "60" }), t(r, { label: "序号", type: "index", align: "center", width: "60" }), t(r, { key: "supplierName", prop: "supplierName", label: "劳务单位", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "reportUserName", prop: "reportUserName", label: "上报人", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "createTime", prop: "createTime", label: "日期", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "serialNumber", prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号" }), t(r, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "120" }), e(a).query.productType === e($).ENCLOSURE.V ? (n(), d(P, { key: 0 }, [t(r, { key: "length", prop: "length", label: "单长（mm）", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "reportQuantity", prop: "reportQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "totalLength", prop: "reportMete", label: "总长（m）", align: "center", "show-overflow-tooltip": "" }, { default: s(({ row: c }) => {
      var p;
      return [U("span", null, L(c.reportMete ? (p = c.reportMete) == null ? void 0 : p.toFixed(e(X).COM_L__M) : 0), 1)];
    }), _: 1 })], 64)) : (n(), d(P, { key: 1 }, [t(r, { key: "length", prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "reportQuantity", prop: "reportQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": "" }), t(r, { key: "reportMete", prop: "reportMete", label: "总净重（kg）", align: "center", "show-overflow-tooltip": "" })], 64))]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[H, e(a).loading]]), t(e(Z))])) : ((v = e(g)) == null ? void 0 : v.installReportMethod) !== e(E).APP.V ? (n(), d("div", ne, [t(D, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: s(() => o[2] || (o[2] = [_(" * 您好，当前页面需要选择劳务单位填报模式可查看 ")])), _: 1, __: [2] })])) : f("", true)]);
  };
} }, ue = K(le, [["__scopeId", "data-v-713871d6"]]);
export {
  ue as default
};
