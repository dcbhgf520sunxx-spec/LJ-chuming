import { ref as R } from "vue";
import { inject as T } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as W } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as r } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as G } from "vue";
import { unref as i } from "vue";
import { withModifiers as J } from "vue";
import { isRef as K } from "vue";
import { ElTag as O } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { ElPagination as A } from "element-plus";
import { a as F } from "../../../../../modules/kanban-603b7875.js";
import { _ as X, u as Y, J as Z, o as $ } from "../../../../../shared/runtime.js";
const ee = { style: { display: "flex" } }, te = { __name: "kanban-detail", props: { visible: { type: Boolean, default: false }, detailList: { type: Object, default: () => {
} }, workshopId: { type: Number } }, emits: ["update:visible", "success"], setup(p, { emit: j }) {
  const y = R([]), N = j, n = p, D = T("permission"), { visible: u, handleClose: x } = Y({ emit: N, props: n, field: "visible", showHook: k }), { handleSizeChange: V, handleCurrentChange: B, total: H, setTotalPage: P, queryPage: _ } = Z({ fetchHook: k }), { maxHeight: S } = $({ mainBox: ".production-detail-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, u);
  async function k() {
    var b, s, c, g, f, t;
    try {
      const { content: d = [], totalElements: w } = await F({ projectId: (s = (b = n.detailList) == null ? void 0 : b.project) == null ? void 0 : s.id, monomerId: (g = (c = n.detailList) == null ? void 0 : c.monomer) == null ? void 0 : g.id, areaId: (t = (f = n.detailList) == null ? void 0 : f.area) == null ? void 0 : t.id, workshopId: n.workshopId, ..._ });
      P(w), y.value = d || [];
    } catch (d) {
      console.log("获取零件清单明细失败", d);
    }
  }
  return (b, s) => {
    const c = O, g = h("print-table"), f = h("common-button"), t = U, d = h("common-table"), w = A, E = h("common-dialog"), M = q("permission");
    return W(), Q(E, { title: "车间任务状态详情", customClass: "production-detail-dialog", modelValue: i(u), "onUpdate:modelValue": s[0] || (s[0] = (o) => K(u) ? u.value = o : null), "close-on-click-modal": false, width: "1500px", top: "5vh", showClose: false, "before-close": i(x) }, { titleLeft: l(() => [e(c, { size: "default", style: { "margin-left": "8px" } }, { default: l(() => {
      var o, a;
      return [v("项目：" + r((o = p.detailList.project) == null ? void 0 : o.contractNo) + "-" + r((a = p.detailList.project) == null ? void 0 : a.name), 1)];
    }), _: 1 }), e(c, { size: "default", style: { "margin-left": "8px" } }, { default: l(() => [v("排产总量（件/kg）：" + r(p.detailList.taskQuantity) + "/" + r(p.detailList.taskNetWeight), 1)]), _: 1 })]), titleRight: l(() => {
      var o, a, C, L, I, z;
      return [m("div", ee, [m("div", null, [G(e(g, { "api-key": "mesProductionKanbanList", params: { projectId: (a = (o = n.detailList) == null ? void 0 : o.project) == null ? void 0 : a.id, monomerId: (L = (C = n.detailList) == null ? void 0 : C.monomer) == null ? void 0 : L.id, areaId: (z = (I = n.detailList) == null ? void 0 : I.area) == null ? void 0 : z.id, workshopId: n.workshopId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[M, i(D).print]])]), e(f, { size: "default", type: "plain", class: "filter-item", style: { "margin-left": "8px" }, onClick: J(i(x), ["stop"]) }, { default: l(() => s[1] || (s[1] = [v(" 关闭 ")])), _: 1, __: [1] }, 8, ["onClick"])])];
    }), default: l(() => [e(d, { data: y.value, "max-height": i(S) - 150, "show-empty-symbol": false, style: { width: "100%" } }, { default: l(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "center", "min-width": "120px" }, { default: l(({ row: o }) => {
      var a;
      return [m("span", null, r(o.monomer ? (a = o.monomer) == null ? void 0 : a.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", align: "center", "min-width": "120px" }, { default: l(({ row: o }) => {
      var a;
      return [m("span", null, r(o.area ? (a = o.area) == null ? void 0 : a.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center" }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" }), e(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", align: "center" }), e(t, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", align: "center" }), e(t, { prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center" }, { default: l(({ row: o }) => [m("span", null, r(o.material), 1)]), _: 1 }), e(t, { prop: "quantity", "show-overflow-tooltip": true, label: "排产量", align: "center" }), e(t, { prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总净重（kg）", align: "center" }), e(t, { prop: "totalGrossWeight", "show-overflow-tooltip": true, label: "总毛重（kg）", align: "center" }), e(t, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际完成数", align: "center" })]), _: 1 }, 8, ["data", "max-height"]), e(w, { total: i(H), "current-page": i(_).pageNumber, "page-size": i(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(V), onCurrentChange: i(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ie = X(te, [["__scopeId", "data-v-226bf8dc"]]);
export {
  ie as default
};
