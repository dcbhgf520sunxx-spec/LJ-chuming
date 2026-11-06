import { provide as Y } from "vue";
import { inject as M } from "vue";
import { ref as d } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as ae } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { Fragment as te } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as m } from "vue";
import { withModifiers as A } from "vue";
import { createBlock as x } from "vue";
import { withKeys as ne } from "vue";
import { toDisplayString as S } from "vue";
import { ElInput as oe } from "element-plus";
import { ElTag as le } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElInputNumber as se } from "element-plus";
import { ElPagination as ie } from "element-plus";
import { vLoading as ue } from "element-plus";
import { a as ce, b as de } from "../../../../../../modules/painting-22de8667.js";
import { J as me, o as pe, c as T, D as k, ng as fe, bZ as ge } from "../../../../../../shared/runtime.js";
import { u as ve } from "../../../../../../modules/use-table-change-32e98420.js";
import _e from "./batch-edit-area-preview.vue.js";
import "../../../../../../modules/index-61ce89a1.js";
const be = { class: "artifact-list" }, ye = { class: "head-container artifact-list-head" }, he = { style: { float: "right" } }, Ie = { key: 0 }, ze = { __name: "artifact-list", props: { projectId: { type: [Number, String], default: void 0 }, configId: { type: Number, default: void 0 } }, setup(f) {
  const g = f, { handleSizeChange: U, handleCurrentChange: j, total: q, setTotalPage: R, queryPage: v } = me({ fetchHook: u }), { maxHeight: B } = pe({ extraBox: ".artifact-list-head", paginate: true }), z = /* @__PURE__ */ new Map([["surfaceArea", "sourceSurfaceArea"]]);
  Y("sourceMap", z);
  const I = M("crud"), P = M("permission"), p = d(false), C = d(false), i = d({}), l = d({}), w = d(false), _ = d([]), { changedCellMask: H } = ve({ fieldMap: z });
  function E() {
    l.value = { ...I.query }, v.pageNumber = 1, u();
  }
  ee(() => g.configId, () => {
    E();
  }, { immediate: true });
  async function u() {
    if (_.value = [], i.value = {}, !!g.configId) try {
      w.value = true, i.value = await ce({ configId: g.configId, ...l.value }) || {}, i.value.surfaceArea = T(i.value.surfaceArea, "mm²", "㎡", k.COM_AREA__M2);
      const { content: b, totalElements: e } = await de({ configId: g.configId, ...l.value, ...v });
      _.value = b.map((o) => {
        const y = T(o.surfaceArea, "mm²", "㎡", k.COM_AREA__M2);
        return o.sourceSurfaceArea = y, o.surfaceArea = y, o;
      }), R(e);
    } catch (b) {
      console.log("获取构件清单", b);
    } finally {
      w.value = false;
    }
  }
  function L() {
    p.value = false, u();
  }
  function O() {
    p.value = true;
  }
  function K() {
    p.value = false;
  }
  function $() {
    C.value = true;
  }
  return (b, e) => {
    const o = V("common-button"), y = oe, F = le, c = re, J = se, Q = V("common-table"), Z = ie, G = ae("permission"), W = ue;
    return s(), h("div", be, [N("div", ye, [a(t(ge), { monomerId: l.value.monomerId, "onUpdate:monomerId": e[0] || (e[0] = (n) => l.value.monomerId = n), areaId: l.value.areaId, "onUpdate:areaId": e[1] || (e[1] = (n) => l.value.areaId = n), clearable: "", areaClearable: "", productType: t(fe).STRUCTURE.V, "project-id": f.projectId, monomerDisabled: !f.projectId || !!t(I).query.monomerId, areaDisabled: !f.projectId || !!t(I).query.areaId, onChange: u }, null, 8, ["monomerId", "areaId", "productType", "project-id", "monomerDisabled", "areaDisabled"]), D((s(), h("div", he, [p.value ? (s(), h(te, { key: 0 }, [a(o, { size: "default", onClick: A(K, ["stop"]) }, { default: r(() => e[5] || (e[5] = [m("取消")])), _: 1, __: [5] }), a(o, { size: "default", type: "success", onClick: $ }, { default: r(() => e[6] || (e[6] = [m("预览并保存")])), _: 1, __: [6] })], 64)) : (s(), x(o, { key: 1, type: "primary", size: "default", onClick: O }, { default: r(() => e[7] || (e[7] = [m("编辑【面积】")])), _: 1, __: [7] }))])), [[G, t(P).editArea]]), e[10] || (e[10] = N("br", null, null, -1)), a(y, { modelValue: l.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (n) => l.value.serialNumber = n), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: ne(u, ["enter"]) }, null, 8, ["modelValue"]), a(o, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: A(u, ["stop"]) }, { default: r(() => e[8] || (e[8] = [m("搜索")])), _: 1, __: [8] }), a(o, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: e[3] || (e[3] = A((n) => E(), ["stop"])) }, { default: r(() => e[9] || (e[9] = [m(" 重置 ")])), _: 1, __: [9] }), a(F, { size: "large", class: "filter-item", style: { float: "right" }, type: "success", effect: "plain" }, { default: r(() => [m(" 总数：" + S(i.value.quantity || 0) + "件 | 总面积：" + S(i.value.surfaceArea || 0) + "㎡", 1)]), _: 1 })]), D((s(), x(Q, { "return-source-data": "", data: _.value, "cell-class-name": t(H), "max-height": t(B), style: { width: "100%" } }, { default: r(() => [a(c, { label: "序号", type: "index", align: "center", width: "60" }), a(c, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "center", "min-width": "120px" }), a(c, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", align: "center", "min-width": "120px" }), a(c, { prop: "serialNumber", label: "编号", align: "center", "min-width": "80px" }), a(c, { prop: "quantity", label: "编号", align: "center", "min-width": "80px" }), a(c, { prop: "surfaceArea", label: "面积(㎡)", align: "center", "min-width": "80px" }, { default: r(({ row: n }) => [p.value ? (s(), x(J, { key: 1, modelValue: n.surfaceArea, "onUpdate:modelValue": (X) => n.surfaceArea = X, step: 1, min: 0, precision: t(k).COM_AREA__M2, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "面积" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (s(), h("div", Ie, S(n.sourceSurfaceArea), 1))]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])), [[W, w.value]]), a(Z, { total: t(q), "current-page": t(v).pageNumber, "page-size": t(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(U), onCurrentChange: t(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(t(_e), { visible: C.value, "onUpdate:visible": e[4] || (e[4] = (n) => C.value = n), data: _.value, onSaveSuccess: L }, null, 8, ["visible", "data"])]);
  };
} };
export {
  ze as default
};
