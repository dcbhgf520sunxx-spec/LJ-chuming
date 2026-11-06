import { ref as m } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as W } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { withDirectives as u } from "vue";
import { createBlock as l } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as x } from "vue";
import { toDisplayString as C } from "vue";
import { createTextVNode as X } from "vue";
import { normalizeStyle as Z } from "vue";
import { vShow as V } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { Edit as te } from "@element-plus/icons-vue";
import { ElIcon as ae } from "element-plus";
import { ElDivider as ie } from "element-plus";
import { ElTag as ne } from "element-plus";
import { vLoading as se } from "element-plus";
import { c as oe, g as re } from "../../../../../modules/painting-22de8667.js";
import { _ as le, x as ce, pC as g, o as P, c as H, D as R, bY as w, G as de, ba as pe } from "../../../../../shared/runtime.js";
import me from "./module/header.vue.js";
import ue from "./module/artifact-list.vue.js";
import fe from "./module/edit-form.vue.js";
import "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "../../../../../modules/use-table-change-32e98420.js";
import "./module/batch-edit-area-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const _e = { class: "app-container wrap" }, ge = { class: "wrap-left" }, he = { class: "head-container" }, ve = { style: { display: "flex", "align-items": "center" } }, xe = { style: { flex: "1" } }, ye = { style: { display: "flex", "align-items": "center" } }, be = { style: { flex: "1" } }, ke = { style: { display: "flex", "align-items": "center" } }, Me = { style: { flex: "1" } }, Ae = { class: "painting-artifact-head head-container" }, Ce = { class: "wrap-right" }, Pe = { class: "my-code" }, we = { __name: "index", setup(Ee) {
  const B = { add: false, edit: false, del: false, download: false }, E = m(), U = m(), { crud: f, columns: h, CRUD: j } = ce({ title: "涂装计算", permission: { ...g }, optShow: { ...B }, crudApi: { ...oe }, hasPagination: false }, E), { maxHeight: N } = P({ extraBox: [".head-container", ".painting-divider", ".painting-artifact-head", ".painting-artifact-table"], minHeight: 200, paginate: false }), { maxHeight: $ } = P({ extraBox: "", paginate: false }), { maxHeight: q } = P({ extraBox: [".head-container", ".painting-divider", ".painting-artifact-head", ".painting-crud-table"], minHeight: 200, paginate: false });
  j.HOOK.handleRefresh = (n, e) => {
    z(), e.data.content = e.data.content.map((a, d) => (a.id = d + "" + Math.random(), a.surfaceArea = H(a.surfaceArea, "mm²", "㎡", R.COM_AREA__M2), a));
  };
  const F = m([["primerMeasure", ["to-fixed-ck", "COM_VOLUME__L"]], ["intermediateMeasure", ["to-fixed-ck", "COM_VOLUME__L"]], ["topcoatMeasure", ["to-fixed-ck", "COM_VOLUME__L"]]]), b = m(false), I = m({}), v = m(), k = m([]), M = m(false);
  function A(n, e, a) {
    var d, _;
    de(g.edit) && (I.value = { surfaceArea: n.surfaceArea, projectId: (d = n.project) == null ? void 0 : d.id, monomerId: (_ = n.monomer) == null ? void 0 : _.id, thickness: e.thickness, loss: e.loss ? e.loss * 100 : e.loss, volumeSolids: e.volumeSolids ? e.volumeSolids * 100 : e.volumeSolids, paintingType: a }, b.value = true);
  }
  async function z() {
    try {
      k.value = [], v.value = void 0, M.value = true;
      const { content: n } = await re({ ...f.query });
      k.value = n.map((e) => (e.surfaceArea = H(e.surfaceArea, "mm²", "㎡", R.COM_AREA__M2), e));
    } catch (n) {
      console.log("获取全部构件信息失败", n);
    } finally {
      M.value = false;
    }
  }
  function Y(n) {
    var e;
    v.value = (e = n.config) == null ? void 0 : e.id;
  }
  function G(n) {
    return pe(n, { props: ["surfaceArea", "primerMeasure", "intermediateMeasure", "topcoatMeasure"] });
  }
  return (n, e) => {
    const a = ee, d = te, _ = ae, L = S("common-table"), T = ie, K = ne, Q = S("print-table"), y = J("permission"), O = se;
    return r(), W("div", _e, [o("div", ge, [o("div", he, [i(t(me))]), u((r(), l(L, { ref_key: "tableRef", ref: E, class: "painting-crud-table", data: t(f).data, "empty-text": t(f).emptyText, "max-height": t(N) - 40, "row-key": "id", style: { width: "100%" } }, { default: c(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), t(h).visible("monomer.name") ? (r(), l(a, { key: 0, prop: "monomer.name", align: "center", "show-overflow-tooltip": true, label: "单体", "min-width": "120px" })) : x("", true), t(h).visible("surfaceArea") ? (r(), l(a, { key: 1, prop: "surfaceArea", label: "面积(㎡)", align: "center", "min-width": "80px" })) : x("", true), t(h).visible("primerPainting") ? (r(), l(a, { key: 2, prop: "primerPainting", label: "底漆(um)", align: "center", "min-width": "80px" }, { default: c(({ row: s }) => {
      var p;
      return [o("div", ve, [o("span", xe, C(((p = s.primerPainting) == null ? void 0 : p.thickness) || "-"), 1), u((r(), l(_, { class: "pointer", onClick: (D) => A(s, s.primerPainting, t(w).PRIMER.V) }, { default: c(() => [i(d)]), _: 2 }, 1032, ["onClick"])), [[y, t(g).edit]])])];
    }), _: 1 })) : x("", true), t(h).visible("intermediatePainting") ? (r(), l(a, { key: 3, prop: "intermediatePainting", label: "中间漆(um)", align: "center", "min-width": "80px" }, { default: c(({ row: s }) => {
      var p;
      return [o("div", ye, [o("span", be, C(((p = s.intermediatePainting) == null ? void 0 : p.thickness) || "-"), 1), u((r(), l(_, { class: "pointer", onClick: (D) => A(s, s.intermediatePainting, t(w).INTERMEDIATE_PAINT.V) }, { default: c(() => [i(d)]), _: 2 }, 1032, ["onClick"])), [[y, t(g).edit]])])];
    }), _: 1 })) : x("", true), t(h).visible("topcoatPainting") ? (r(), l(a, { key: 4, prop: "topcoatPainting", label: "面漆(um)", align: "center", "min-width": "80px" }, { default: c(({ row: s }) => {
      var p;
      return [o("div", ke, [o("span", Me, C(((p = s.topcoatPainting) == null ? void 0 : p.thickness) || "-"), 1), u((r(), l(_, { class: "pointer", onClick: (D) => A(s, s.topcoatPainting, t(w).TOPCOAT.V) }, { default: c(() => [i(d)]), _: 2 }, 1032, ["onClick"])), [[y, t(g).edit]])])];
    }), _: 1 })) : x("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[O, t(f).loading]]), i(T, { class: "painting-divider" }, { default: c(() => e[1] || (e[1] = [o("span", { class: "title" }, "油漆用量明细 ", -1)])), _: 1, __: [1] }), o("div", Ae, [i(K, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: c(() => e[2] || (e[2] = [X("理论涂布率：9.8L/平方米")])), _: 1, __: [2] }), u(i(Q, { "api-key": "mesPaintingList", params: { ...t(f).query }, size: "default", type: "warning", style: { float: "right" }, class: "filter-item" }, null, 8, ["params"]), [[y, t(g).print]])]), u((r(), l(L, { ref_key: "artifactTableRef", ref: U, class: "painting-artifact-table", data: k.value, "max-height": t(q), "data-format": F.value, "show-summary": "", "summary-method": G, "row-key": "id", "highlight-current-row": "", onCurrentChange: Y, style: { width: "100%" } }, { default: c(() => [i(a, { label: "序号", type: "index", align: "center", width: "60" }), i(a, { prop: "config.name", "show-overflow-tooltip": true, label: "构件类型", align: "center", "min-width": "120px" }), i(a, { prop: "surfaceArea", label: "涂装面积(㎡)", align: "center", "min-width": "80px" }), i(a, { prop: "primerMeasure", label: "底漆(L)", align: "center", "min-width": "80px" }), i(a, { prop: "intermediateMeasure", label: "中间漆(L)", align: "center", "min-width": "80px" }), i(a, { prop: "topcoatMeasure", label: "面漆(L)", align: "center", "min-width": "80px" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[O, M.value]])]), i(T, { direction: "vertical", style: Z(`height: ${t($)}px`) }, null, 8, ["style"]), o("div", Ce, [u(o("div", Pe, "*点击左侧油漆用量明细查看", 512), [[V, !v.value]]), u(i(ue, { projectId: t(f).query.projectId, configId: v.value }, null, 8, ["projectId", "configId"]), [[V, v.value]])]), i(fe, { visible: b.value, "onUpdate:visible": e[0] || (e[0] = (s) => b.value = s), info: I.value, onRefresh: t(f).toQuery }, null, 8, ["visible", "info", "onRefresh"])]);
  };
} }, Ue = le(we, [["__scopeId", "data-v-3db1d111"]]);
export {
  Ue as default
};
