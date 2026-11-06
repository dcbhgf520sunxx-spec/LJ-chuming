import { ref as m } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as W } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { withDirectives as u } from "vue";
import { createBlock as r } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as v } from "vue";
import { toDisplayString as C } from "vue";
import { createTextVNode as X } from "vue";
import { normalizeStyle as Z } from "vue";
import { vShow as V } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { Edit as te } from "@element-plus/icons-vue";
import { ElIcon as ae } from "element-plus";
import { ElDivider as ie } from "element-plus";
import { ElTag as ne } from "element-plus";
import { vLoading as oe } from "element-plus";
import { c as se, g as le } from "../../../../../modules/painting-26fedd54.js";
import { _ as re, x as ce, o as P, c as B, D as H, bY as w, G as de, ba as pe } from "../../../../../shared/runtime.js";
import { w as g } from "../../../../../modules/bridge-86f96a4f.js";
import me from "./module/header.vue.js";
import ue from "./module/box-list.vue.js";
import _e from "./module/edit-form.vue.js";
import "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "../../../../../modules/use-table-change-32e98420.js";
import "./module/batch-edit-area-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const fe = { class: "app-container wrap" }, ge = { class: "wrap-left" }, he = { class: "head-container" }, xe = { style: { display: "flex", "align-items": "center" } }, ve = { style: { flex: "1" } }, be = { style: { display: "flex", "align-items": "center" } }, ye = { style: { flex: "1" } }, ke = { style: { display: "flex", "align-items": "center" } }, Me = { style: { flex: "1" } }, Ae = { class: "painting-box-head head-container" }, Ce = { class: "wrap-right" }, Pe = { class: "my-code" }, we = { __name: "index", setup(Ee) {
  const R = { add: false, edit: false, del: false, download: false }, E = m(), U = m(), { crud: _, columns: h, CRUD: j } = ce({ title: "涂装计算", permission: { ...g }, optShow: { ...R }, crudApi: { ...se }, hasPagination: false }, E), { maxHeight: N } = P({ extraBox: [".head-container", ".painting-divider", ".painting-box-head", ".painting-box-table"], minHeight: 200, paginate: false }), { maxHeight: $ } = P({ extraBox: "", paginate: false }), { maxHeight: q } = P({ extraBox: [".head-container", ".painting-divider", ".painting-box-head", ".painting-crud-table"], minHeight: 200, paginate: false });
  j.HOOK.handleRefresh = (n, e) => {
    z(), e.data.content = e.data.content.map((a, d) => (a.id = d + "" + Math.random(), a.surfaceArea = B(a.surfaceArea, "mm²", "㎡", H.COM_AREA__M2), a));
  };
  const F = m([["primerMeasure", ["to-fixed-ck", "COM_VOLUME__L"]], ["intermediateMeasure", ["to-fixed-ck", "COM_VOLUME__L"]], ["topcoatMeasure", ["to-fixed-ck", "COM_VOLUME__L"]]]), y = m(false), I = m({}), x = m(), k = m([]), M = m(false);
  function A(n, e, a) {
    var d, f;
    de(g.edit) && (I.value = { surfaceArea: n.surfaceArea, projectId: (d = n.project) == null ? void 0 : d.id, monomerId: (f = n.monomer) == null ? void 0 : f.id, thickness: e.thickness, loss: e.loss ? e.loss * 100 : e.loss, volumeSolids: e.volumeSolids ? e.volumeSolids * 100 : e.volumeSolids, paintingType: a }, y.value = true);
  }
  async function z() {
    try {
      k.value = [], x.value = void 0, M.value = true;
      const { content: n } = await le({ ..._.query });
      k.value = n.map((e) => (e.surfaceArea = B(e.surfaceArea, "mm²", "㎡", H.COM_AREA__M2), e));
    } catch (n) {
      console.log("获取全部分段信息失败", n);
    } finally {
      M.value = false;
    }
  }
  function Y(n) {
    var e;
    x.value = (e = n.config) == null ? void 0 : e.id;
  }
  function G(n) {
    return pe(n, { props: ["surfaceArea", "primerMeasure", "intermediateMeasure", "topcoatMeasure"] });
  }
  return (n, e) => {
    const a = ee, d = te, f = ae, L = S("common-table"), T = ie, K = ne, Q = S("print-table"), b = J("permission"), O = oe;
    return l(), W("div", fe, [s("div", ge, [s("div", he, [i(t(me))]), u((l(), r(L, { ref_key: "tableRef", ref: E, class: "painting-crud-table", data: t(_).data, "empty-text": t(_).emptyText, "max-height": t(N), "row-key": "id", style: { width: "100%" } }, { default: c(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), t(h).visible("monomer.name") ? (l(), r(a, { key: 0, prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体", "min-width": "120px" })) : v("", true), t(h).visible("surfaceArea") ? (l(), r(a, { key: 1, prop: "surfaceArea", label: "面积(㎡)", align: "center", "min-width": "80px" })) : v("", true), t(h).visible("primerPainting") ? (l(), r(a, { key: 2, prop: "primerPainting", label: "底漆(um)", align: "center", "min-width": "80px" }, { default: c(({ row: o }) => {
      var p;
      return [s("div", xe, [s("span", ve, C(((p = o.primerPainting) == null ? void 0 : p.thickness) || "-"), 1), u((l(), r(f, { class: "pointer", onClick: (D) => A(o, o.primerPainting, t(w).PRIMER.V) }, { default: c(() => [i(d)]), _: 2 }, 1032, ["onClick"])), [[b, t(g).edit]])])];
    }), _: 1 })) : v("", true), t(h).visible("intermediatePainting") ? (l(), r(a, { key: 3, prop: "intermediatePainting", label: "中间漆(um)", align: "center", "min-width": "80px" }, { default: c(({ row: o }) => {
      var p;
      return [s("div", be, [s("span", ye, C(((p = o.intermediatePainting) == null ? void 0 : p.thickness) || "-"), 1), u((l(), r(f, { class: "pointer", onClick: (D) => A(o, o.intermediatePainting, t(w).INTERMEDIATE_PAINT.V) }, { default: c(() => [i(d)]), _: 2 }, 1032, ["onClick"])), [[b, t(g).edit]])])];
    }), _: 1 })) : v("", true), t(h).visible("topcoatPainting") ? (l(), r(a, { key: 4, prop: "topcoatPainting", label: "面漆(um)", align: "center", "min-width": "80px" }, { default: c(({ row: o }) => {
      var p;
      return [s("div", ke, [s("span", Me, C(((p = o.topcoatPainting) == null ? void 0 : p.thickness) || "-"), 1), u((l(), r(f, { class: "pointer", onClick: (D) => A(o, o.topcoatPainting, t(w).TOPCOAT.V) }, { default: c(() => [i(d)]), _: 2 }, 1032, ["onClick"])), [[b, t(g).edit]])])];
    }), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[O, t(_).loading]]), i(T, { class: "painting-divider" }, { default: c(() => e[1] || (e[1] = [s("span", { class: "title" }, "油漆用量明细 ", -1)])), _: 1, __: [1] }), s("div", Ae, [i(K, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: c(() => e[2] || (e[2] = [X("理论涂布率：9.8L/平方米")])), _: 1, __: [2] }), u(i(Q, { "api-key": "bridgePaintingList", params: { ...t(_).query }, size: "default", type: "warning", style: { float: "right" }, class: "filter-item" }, null, 8, ["params"]), [[b, t(g).print]])]), u((l(), r(L, { ref_key: "boxTableRef", ref: U, class: "painting-box-table", data: k.value, "max-height": t(q), "data-format": F.value, "show-summary": "", "summary-method": G, "row-key": "id", "highlight-current-row": "", onCurrentChange: Y, style: { width: "100%" } }, { default: c(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), i(a, { prop: "config.name", "show-overflow-tooltip": true, label: "分段类型", align: "center", "min-width": "120px" }), i(a, { prop: "surfaceArea", label: "涂装面积(㎡)", align: "center", "min-width": "80px" }), i(a, { prop: "primerMeasure", label: "底漆(L)", align: "center", "min-width": "80px" }), i(a, { prop: "intermediateMeasure", label: "中间漆(L)", align: "center", "min-width": "80px" }), i(a, { prop: "topcoatMeasure", label: "面漆(L)", align: "center", "min-width": "80px" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[O, M.value]])]), i(T, { direction: "vertical", style: Z(`height: ${t($)}px`) }, null, 8, ["style"]), s("div", Ce, [u(s("div", Pe, "*点击左侧油漆用量明细查看", 512), [[V, !x.value]]), u(i(ue, { projectId: t(_).query.projectId, configId: x.value }, null, 8, ["projectId", "configId"]), [[V, x.value]])]), i(_e, { visible: y.value, "onUpdate:visible": e[0] || (e[0] = (o) => y.value = o), info: I.value, onRefresh: t(_).toQuery }, null, 8, ["visible", "info", "onRefresh"])]);
  };
} }, je = re(we, [["__scopeId", "data-v-46805e16"]]);
export {
  je as default
};
