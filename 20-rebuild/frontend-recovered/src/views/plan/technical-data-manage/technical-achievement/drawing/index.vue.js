import { computed as z } from "vue";
import { useStore as Y } from "vuex";
import { ref as T } from "vue";
import { watch as Q } from "vue";
import { onMounted as J } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as R } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as c } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as g } from "vue";
import { Fragment as q } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as w } from "vue";
import { ElTableColumn as X } from "element-plus";
import { vLoading as ee } from "element-plus";
import { _ as te, m as ae, aa as y, x as oe, t7 as le, o as re, t0 as b, G as S, L as ie, tf as ne, tg as se, P as ue } from "../../../../../shared/runtime.js";
import { r as d } from "../../../../../modules/plan-d12d7ccf.js";
import pe from "./module/header.vue.js";
import de from "./module/OAModal.vue.js";
import ce from "./module/detail.vue.js";
import "../../../../supply-chain/components/audit-records.vue.js";
import "../components/drawing-upload-btn.vue.js";
import "../../../../../modules/index-ce9deea8.js";
import "./module/match-detail/index.vue.js";
import "./module/match-detail/module/header.vue.js";
const me = { class: "app-container" }, ye = { class: "head-container" }, _e = { class: "btn flex-rcc" }, fe = { __name: "index", setup(ve) {
  const { globalProjectId: N, globalProject: j } = ae(["globalProjectId", "globalProject"]), _ = z(() => y.ARTIFACT.V | y.ASSEMBLY.V | y.MACHINE_PART.V), O = { add: false, edit: false, del: false, download: false }, o = Y(), x = T(), f = T({}), G = T(".pdf"), D = T(false), h = T(false), { crud: t, columns: P } = oe({ title: "图纸管理", permission: { ...d }, optShow: { ...O }, requiredQuery: ["projectId", "dataType"], crudApi: { ...le }, hasPagination: true }, x), { maxHeight: L } = re();
  Q(() => N.value, (n) => {
    n && (t.query.projectId = N.value, t.toQuery());
  }, { immediate: true, deep: true });
  function U(n) {
    D.value = true, f.value = { ...n, steelPlateTypeEnum: t.query.steelPlateTypeEnum }, t.query.productType === _.value && (f.value.productType, y.ARTIFACT.V);
  }
  function W(n) {
    f.value = { ...n, steelPlateTypeEnum: t.query.steelPlateTypeEnum, cplx: n.productType ? t.query.productType === _.value ? "" : y.VL[n.productType] : "" }, t.query.productType === _.value && (f.value.productType, _.value), h.value = true;
  }
  function B() {
    F();
  }
  function $() {
  }
  function F() {
    o.dispatch("approval_list/fetchApprovalNum"), o.dispatch("approval_list/fetchSubNum", b.PLAN_DRAWING_DOCUMENT_MANAGE.V), o.dispatch("approval_list/fetchRejNum", b.PLAN_DRAWING_DOCUMENT_MANAGE.V), o.dispatch("approval_list/fetchApprovalNum", b.PLAN_DRAWING_DOCUMENT_MANAGE.V), t.toQuery();
  }
  return Q(() => o.state.approval_list.SubDrawing_Num, () => {
    t.toQuery();
  }), J(async () => {
    await o.dispatch("approval_list/fetchSubNum", b.PLAN_DRAWING_DOCUMENT_MANAGE.V), await o.dispatch("approval_list/fetchRejNum", b.PLAN_DRAWING_DOCUMENT_MANAGE.V), await o.dispatch("approval_list/fetchApprovalNum", b.PLAN_DRAWING_DOCUMENT_MANAGE.V);
  }), (n, s) => {
    const u = X, V = I("common-button"), H = I("common-table"), k = K("permission"), Z = ee;
    return r(), E("div", me, [R("div", ye, [i(e(pe), { APPtotal: e(o).state.approval_list.APPDrawing_Num, globalProject: e(j), "rej-total": e(o).state.approval_list.rejDrawing_Num, subTotal: e(o).state.approval_list.SubDrawing_Num }, null, 8, ["APPtotal", "globalProject", "rej-total", "subTotal"])]), C((r(), c(H, { ref_key: "tableRef", ref: x, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(L), style: { width: "100%" } }, { default: m(() => {
      var v, M;
      return [i(u, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(P).visible("monomerName") ? (r(), c(u, { key: "monomerName", align: "center", label: "单体", prop: "monomerName", "show-overflow-tooltip": "" })) : g("", true), e(t).query.productType !== _.value ? (r(), E(q, { key: 1 }, [e(P).visible("quantity") ? (r(), c(u, { key: "quantity", label: `${(M = (v = e(y).V) == null ? void 0 : v[e(t).query.productType]) == null ? void 0 : M.L}总数`, align: "center", prop: "quantity", "show-overflow-tooltip": "" }, null, 8, ["label"])) : g("", true), e(P).visible("drawingQuantity") ? (r(), c(u, { key: "drawingQuantity", align: "center", label: "图纸匹配总数", prop: "drawingQuantity", "show-overflow-tooltip": "" })) : g("", true)], 64)) : (r(), E(q, { key: 2 }, [i(u, { key: "artifactQuantity", label: "构件数|图纸匹配数", align: "center", prop: "artifactQuantity", "show-overflow-tooltip": "" }, { default: m((a) => {
        var l, p;
        return [A(w((l = a.row.summaryDetailDTO) == null ? void 0 : l.artifactQuantity) + " | " + w((p = a.row.summaryDetailDTO) == null ? void 0 : p.artifactDrawingQuantity), 1)];
      }), _: 1 }), i(u, { key: "assembleQuantity", label: "部件数|图纸匹配数", align: "center", prop: "assembleQuantity", "show-overflow-tooltip": "" }, { default: m((a) => {
        var l, p;
        return [A(w((l = a.row.summaryDetailDTO) == null ? void 0 : l.assembleQuantity) + " | " + w((p = a.row.summaryDetailDTO) == null ? void 0 : p.assembleDrawingQuantity), 1)];
      }), _: 1 }), i(u, { key: "partQuantity", label: "零件数|图纸匹配数", align: "center", prop: "partQuantity", "show-overflow-tooltip": "" }, { default: m((a) => {
        var l, p;
        return [A(w((l = a.row.summaryDetailDTO) == null ? void 0 : l.partQuantity) + " | " + w((p = a.row.summaryDetailDTO) == null ? void 0 : p.partDrawingQuantity), 1)];
      }), _: 1 })], 64)), e(S)([...e(d).drawingZipDownload, ...e(d).import, ...e(d).detail]) ? (r(), c(u, { key: 3, align: "center", fixed: "right", label: "操作", width: "260px" }, { default: m((a) => [R("div", _e, [e(S)(e(d).drawingZipDownload) ? (r(), c(e(ie), { key: 0, fn: e(t).query.productType === _.value ? e(ne) : e(se), params: { projectId: e(N), monomerId: a.row.monomerId, taskTypeEnum: e(t).query.productType, steelPlateTypeEnum: e(t).query.productType === e(y).MACHINE_PART.V ? e(t).query.steelPlateTypeEnum : void 0 }, "response-header-result": "", boolDrawing: "", size: "default" }, { default: m(() => s[2] || (s[2] = [A(" 下载 ")])), _: 2, __: [2] }, 1032, ["fn", "params"])) : g("", true), C((r(), c(V, { size: "default", type: "success", onClick: (l) => W(a.row) }, { default: m(() => s[3] || (s[3] = [A(" 文件导入 ")])), _: 2, __: [3] }, 1032, ["onClick"])), [[k, e(d).import]]), C(i(V, { icon: "el-icon-document", size: "default", style: { "margin-left": "6px" }, type: "primary", onClick: (l) => U(a.row) }, null, 8, ["onClick"]), [[k, e(d).detail]])])]), _: 1 })) : g("", true)];
    }), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[Z, e(t).loading]]), i(e(ue)), i(ce, { modelValue: D.value, "onUpdate:modelValue": s[0] || (s[0] = (v) => D.value = v), currentRow: f.value, permission: e(d), onClose: e(t).toQuery, onSuccess: e(t).toQuery }, null, 8, ["modelValue", "currentRow", "permission", "onClose", "onSuccess"]), i(de, { visible: h.value, "onUpdate:visible": s[1] || (s[1] = (v) => h.value = v), "row-data": f.value, "upload-type": G.value, onSuccess: B, onClose: $ }, null, 8, ["visible", "row-data", "upload-type"])]);
  };
} }, Ve = te(fe, [["__scopeId", "data-v-8ab83b29"]]);
export {
  Ve as default
};
