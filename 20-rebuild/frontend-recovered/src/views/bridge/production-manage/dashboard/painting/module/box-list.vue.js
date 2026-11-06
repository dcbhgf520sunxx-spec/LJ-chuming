import { provide as Y } from "vue";
import { inject as E } from "vue";
import { ref as d } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as ae } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { Fragment as te } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as m } from "vue";
import { withModifiers as w } from "vue";
import { createBlock as A } from "vue";
import { withKeys as oe } from "vue";
import { toDisplayString as S } from "vue";
import { ElInput as ne } from "element-plus";
import { ElTag as le } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { ElPagination as ie } from "element-plus";
import { vLoading as ue } from "element-plus";
import { b as ce, a as de } from "../../../../../../modules/painting-26fedd54.js";
import { J as me, o as pe, c as j, D as k, bZ as fe } from "../../../../../../shared/runtime.js";
import { u as ge } from "../../../../../../modules/use-table-change-32e98420.js";
import ve from "./batch-edit-area-preview.vue.js";
import "../../../../../../modules/index-61ce89a1.js";
const be = { class: "box-list" }, _e = { class: "head-container box-list-head" }, ye = { style: { float: "right" } }, he = { key: 0 }, ke = { __name: "box-list", props: { projectId: { type: [Number, String], default: void 0 }, configId: { type: Number, default: void 0 } }, setup(f) {
  const g = f, { handleSizeChange: q, handleCurrentChange: U, total: B, setTotalPage: P, queryPage: v } = me({ fetchHook: u }), { maxHeight: T } = pe({ extraBox: ".box-list-head", paginate: true }), z = /* @__PURE__ */ new Map([["surfaceArea", "sourceSurfaceArea"]]);
  Y("sourceMap", z);
  const I = E("crud"), R = E("permission"), p = d(false), x = d(false), i = d({}), l = d({}), C = d(false), b = d([]), { changedCellMask: H } = ge({ fieldMap: z });
  function M() {
    l.value = { ...I.query }, v.pageNumber = 1, u();
  }
  ee(() => g.configId, () => {
    M();
  }, { immediate: true });
  async function u() {
    if (b.value = [], i.value = {}, !!g.configId) try {
      C.value = true, i.value = await ce({ configId: g.configId, ...l.value }) || {}, i.value.surfaceArea = j(i.value.surfaceArea, "mm²", "㎡", k.COM_AREA__M2);
      const { content: _, totalElements: e } = await de({ configId: g.configId, ...l.value, ...v });
      b.value = _.map((n) => {
        const y = j(n.surfaceArea, "mm²", "㎡", k.COM_AREA__M2);
        return n.sourceSurfaceArea = y, n.surfaceArea = y, n;
      }), P(e);
    } catch (_) {
      console.log("获取分段清单", _);
    } finally {
      C.value = false;
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
    x.value = true;
  }
  return (_, e) => {
    const n = N("common-button"), y = ne, F = le, c = se, J = re, Q = N("common-table"), Z = ie, G = ae("permission"), W = ue;
    return r(), h("div", be, [V("div", _e, [a(t(fe), { monomerId: l.value.monomerId, "onUpdate:monomerId": e[0] || (e[0] = (o) => l.value.monomerId = o), areaId: l.value.areaId, "onUpdate:areaId": e[1] || (e[1] = (o) => l.value.areaId = o), clearable: "", areaClearable: "", "project-id": f.projectId, monomerDisabled: !f.projectId || !!t(I).query.monomerId, areaDisabled: !f.projectId || !!t(I).query.areaId, onChange: u }, null, 8, ["monomerId", "areaId", "project-id", "monomerDisabled", "areaDisabled"]), D((r(), h("div", ye, [p.value ? (r(), h(te, { key: 0 }, [a(n, { size: "default", onClick: w(K, ["stop"]) }, { default: s(() => e[5] || (e[5] = [m("取消")])), _: 1, __: [5] }), a(n, { size: "default", type: "success", onClick: $ }, { default: s(() => e[6] || (e[6] = [m("预览并保存")])), _: 1, __: [6] })], 64)) : (r(), A(n, { key: 1, type: "primary", size: "default", onClick: O }, { default: s(() => e[7] || (e[7] = [m("编辑【面积】")])), _: 1, __: [7] }))])), [[G, t(R).editArea]]), e[10] || (e[10] = V("br", null, null, -1)), a(y, { modelValue: l.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (o) => l.value.serialNumber = o), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: oe(u, ["enter"]) }, null, 8, ["modelValue"]), a(n, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: w(u, ["stop"]) }, { default: s(() => e[8] || (e[8] = [m("搜索")])), _: 1, __: [8] }), a(n, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: e[3] || (e[3] = w((o) => M(), ["stop"])) }, { default: s(() => e[9] || (e[9] = [m(" 重置 ")])), _: 1, __: [9] }), a(F, { size: "large", class: "filter-item", style: { float: "right" }, type: "success", effect: "plain" }, { default: s(() => [m(" 总数：" + S(i.value.quantity || 0) + "件 | 总面积：" + S(i.value.surfaceArea || 0) + "㎡", 1)]), _: 1 })]), D((r(), A(Q, { "return-source-data": "", data: b.value, "cell-class-name": t(H), "max-height": t(T), style: { width: "100%" } }, { default: s(() => [a(c, { label: "序号", type: "index", align: "center", width: "60" }), a(c, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "center", "min-width": "120px" }), a(c, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", align: "center", "min-width": "120px" }), a(c, { prop: "serialNumber", label: "编号", align: "center", "min-width": "80px" }), a(c, { prop: "quantity", label: "编号", align: "center", "min-width": "80px" }), a(c, { prop: "surfaceArea", label: "面积(㎡)", align: "center", "min-width": "80px" }, { default: s(({ row: o }) => [p.value ? (r(), A(J, { key: 1, modelValue: o.surfaceArea, "onUpdate:modelValue": (X) => o.surfaceArea = X, step: 1, min: 0, precision: t(k).COM_AREA__M2, size: "default", style: { width: "100%" }, "controls-position": "right", placeholder: "面积" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (r(), h("div", he, S(o.sourceSurfaceArea), 1))]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])), [[W, C.value]]), a(Z, { total: t(B), "current-page": t(v).pageNumber, "page-size": t(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(q), onCurrentChange: t(U) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(t(ve), { visible: x.value, "onUpdate:visible": e[4] || (e[4] = (o) => x.value = o), data: b.value, onSaveSuccess: L }, null, 8, ["visible", "data"])]);
  };
} };
export {
  ke as default
};
