import { useStore as ne } from "vuex";
import { ref as c } from "vue";
import { watch as Z } from "vue";
import { computed as se } from "vue";
import { onMounted as re } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as ue } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as r } from "vue";
import { normalizeStyle as k } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as f } from "vue";
import { createVNode as _ } from "vue";
import { unref as n } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as g } from "vue";
import { withCtx as u } from "vue";
import { Fragment as de } from "vue";
import { renderList as pe } from "vue";
import { normalizeClass as me } from "vue";
import { resolveDynamicComponent as ce } from "vue";
import { nextTick as ve } from "vue";
import { ElTag as fe } from "element-plus";
import { ElTableColumn as _e } from "element-plus";
import { vLoading as ye } from "element-plus";
import { _ as Me, m as ge, o as we, n as Te, i as he, r as O, nP as be, T as K, tq as Ne, t0 as U, K as Ae, tr as q, G as Le, t3 as Se, t5 as Ee, t6 as R } from "../../../../../shared/runtime.js";
import { t as z } from "../../../../../modules/plan-d12d7ccf.js";
import xe from "./module/model-config-form.vue.js";
import Ce from "./module/model-monomer-mode.vue.js";
import Ve from "./module/model-integrate-mode.vue.js";
import ke from "../../../../supply-chain/components/audit-records.vue.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/SingleFileUploadBtn-17bec156.js";
import "./module/components/model-integrate-mode-header.vue.js";
const Ue = { class: "app-container" }, ze = { class: "header" }, Pe = { class: "model-limit" }, je = { key: 0, class: "flex-rcc mr-10 limit_box" }, De = { class: "title" }, Fe = { class: "mr-20-imp filter-item", style: { padding: "0 20px", "text-align": "center" } }, Oe = { key: 0 }, Re = { key: 1 }, Ie = { key: 1, class: "red-tip", style: { "font-size": "12px", "margin-left": "10px" } }, Ge = { key: 2, class: "red-tip", style: { "font-size": "12px", "margin-left": "10px" } }, $e = { style: { margin: "2px 0 6px 0" } }, Be = { key: 1, class: "sandwich-cell-bottom" }, He = { __name: "index", setup(We) {
  const { globalProject: w } = ge(["globalProject"]), T = ne(), Q = c(), L = c(false), P = c(false), C = c(false), d = c({}), J = c(), I = c(), j = c(false), m = c({}), e = c({}), { maxHeight: X } = we(), S = c([]), A = { TOTAL: { L: "总数", K: "TOTAL", V: 1 }, SIZE: { L: "大小", K: "SIZE", V: 2 } };
  Te(A), Z(() => w.value, (s) => {
    S.value = [], he(s) && E(s.id);
  }, { deep: true, immediate: true });
  const Y = se(() => d.value.importMode === O.INTEGRATION.V ? Ve : Ce);
  async function E(s = ((a) => (a = w.value) == null ? void 0 : a.id)()) {
    L.value = true;
    try {
      const { content: p = [] } = await be(s) || {};
      p.map((l, h) => {
        var b, N;
        l.projectName = w.value.name, l.projectShortName = w.value.shortName, l.projectSerialNumber = w.value.serialNumber, l.edition = (b = l.bimConfig) == null ? void 0 : b.edition, l.importMode = (N = l.bimConfig) == null ? void 0 : N.importMode, l.areaArr = l.areaSimpleList.filter((x) => x.productType === K.STRUCTURE.V || x.productType === K.BRIDGE.V), h === 0 && (l.rowSpanNum = p.length);
      }), console.log(p), S.value = [], p.forEach((l) => {
        var h, b;
        l.areaInfo = [], (h = l.areaArr) != null && h.length && ((b = l.areaArr) == null || b.forEach((N) => {
          N.itemizedType === 1 && l.areaInfo.push(N);
        }), S.value.push(l));
      }), console.log(S.value), L.value = false, await V();
    } catch (p) {
      console.log("获取单体列表", p), L.value = false;
    }
  }
  async function V() {
    try {
      const s = await Ne();
      e.value = s || {}, console.log(e.value.currentModelUploadFileSize, e.value.maxModelUploadFileSize, "111");
    } catch (s) {
      console.log(s, "获取模型转换限制次数失败");
    }
  }
  function ee(s) {
    d.value = Object.assign({}, s), P.value = true;
  }
  async function ae(s) {
    await V(), d.value = Object.assign({}, s), C.value = true, ve(() => {
      var a;
      (a = I.value) == null || a.fetchData();
    });
  }
  function oe(s) {
    const a = s;
    m.value.moduleType = Ee.PLAN_MANAGEMENT.V, m.value.componentNameList = [U.PLAN_MODEL_DOCUMENT_MANAGE.V], a === 1 ? (m.value.reviewStatus = R.WITHDRAW.V, m.value.waitMeCheck = true, m.value.meLaunch = false) : a === 2 ? (m.value.reviewStatus = R.WITHDRAW.V, m.value.waitMeCheck = false, m.value.meLaunch = true) : a === 3 && (m.value.reviewStatus = R.REJECT.V, m.value.waitMeCheck = false, m.value.meLaunch = false), j.value = true;
  }
  Z(() => T.state.approval_list.SubModel_Num, () => {
    E();
  }), re(async () => {
    await T.dispatch("approval_list/fetchSubNum", U.PLAN_MODEL_DOCUMENT_MANAGE.V), await T.dispatch("approval_list/fetchRejNum", U.PLAN_MODEL_DOCUMENT_MANAGE.V), await T.dispatch("approval_list/fetchApprovalNum", U.PLAN_MODEL_DOCUMENT_MANAGE.V);
  });
  function G() {
    E(), V();
  }
  function le() {
    E(), V();
  }
  return (s, a) => {
    var $, B, H;
    const p = fe, l = _e, h = D("common-button"), b = D("common-table"), N = D("common-drawer"), x = ue("permission"), te = ye;
    return t(), M("div", Ue, [i("div", ze, [i("div", Pe, [e.value.enabled ? (t(), M("div", je, [i("div", De, r(e.value.modelUploadLimitType === A.TOTAL.V ? "模型转换成功次数" : "已上传模型大小"), 1), i("div", Fe, [e.value.modelUploadLimitType === A.TOTAL.V ? (t(), M("span", Oe, [i("span", { style: k(`color: ${e.value.currentModelUploadNum && e.value.currentModelUploadNum >= e.value.maxModelUploadNum ? "#F56C6C" : "#67C23A"}`) }, r(e.value.currentModelUploadNum || 0), 5), a[6] || (a[6] = i("span", { style: { margin: "0 6px" } }, "/", -1)), i("span", null, r(e.value.maxModelUploadNum || 0), 1), i("span", null, [a[4] || (a[4] = v("（ 剩余可使用 ")), i("span", { style: k(`color: ${e.value.uploadNumPoor ? "#67C23A" : "#F56C6C"}`) }, r(e.value.uploadNumPoor ? e.value.uploadNumPoor : 0), 5), a[5] || (a[5] = v(" 次 ）"))])])) : f("", true), e.value.modelUploadLimitType === A.SIZE.V ? (t(), M("span", Re, [i("span", { style: k(`color: ${e.value.currentModelUploadFileSize && e.value.currentModelUploadFileSize >= e.value.maxModelUploadFileSize ? "#F56C6C" : "#67C23A"}`) }, r((($ = e.value.currentModelUploadFileSize) == null ? void 0 : $.toFixed(3)) || 0) + "GB ", 5), a[9] || (a[9] = i("span", { style: { margin: "0 6px" } }, "/", -1)), i("span", null, r(((B = e.value.maxModelUploadFileSize) == null ? void 0 : B.toFixed(3)) || 0) + "GB", 1), i("span", null, [a[7] || (a[7] = v("（ 剩余可使用 ")), i("span", { style: k(`color: ${e.value.fileSizePoor ? "#67C23A" : "#F56C6C"}`) }, r(e.value.fileSizePoor ? (H = e.value.fileSizePoor) == null ? void 0 : H.toFixed(2) : 0), 5), a[8] || (a[8] = v(" MB ） "))])])) : f("", true)])])) : f("", true), e.value.enabled && e.value.currentModelUploadNum && e.value.currentModelUploadNum >= e.value.maxModelUploadNum && e.value.modelUploadLimitType === A.TOTAL.V ? (t(), M("div", Ie, " * 模型转换次数已达上限 ")) : f("", true), e.value.enabled && e.value.currentModelUploadFileSize && e.value.currentModelUploadFileSize >= e.value.maxModelUploadFileSize && e.value.modelUploadLimitType === A.SIZE.V ? (t(), M("div", Ge, " * 可上传模型大小已达上限 ")) : f("", true)]), _(ke, { "module-type": n(Ee).PLAN_MANAGEMENT.V, "component-name-list": n(U).PLAN_MODEL_DOCUMENT_MANAGE.V, APPtotal: n(T).state.approval_list.APPModel_Num, "rej-total": n(T).state.approval_list.rejModel_Num, subTotal: n(T).state.approval_list.SubModel_Num, style: { "min-width": "290px", "padding-right": "5px" }, onOpenAPLists: oe }, null, 8, ["module-type", "component-name-list", "APPtotal", "rej-total", "subTotal"])]), F((t(), g(b, { ref_key: "tableRef", ref: Q, data: S.value, "empty-text": "暂无数据", loading: L.value, "max-height": n(X), showEmptySymbol: false, class: "upload-table", "return-source-data": "", style: { width: "100%" } }, { default: u(() => [_(l, { key: "name", "show-overflow-tooltip": true, align: "center", label: "单体", prop: "name" }, { default: u((o) => [i("div", $e, [i("div", null, r(o.row.name), 1), _(p, { effect: "plain" }, { default: u(() => [v(r(n(w).projectType === n(Ae).STEEL.V ? "结构" : "分段"), 1)]), _: 1 })])]), _: 1 }), _(l, { align: "center", label: "单元" }, { default: u((o) => [o.row.areaInfo.length > 0 ? (t(true), M(de, { key: 0 }, pe(o.row.areaInfo, (y, ie) => {
      var W;
      return t(), M("div", { key: y.id }, [i("div", { class: me(ie === ((W = o.row.areaInfo) == null ? void 0 : W.length) - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, r(y.name), 3)]);
    }), 128)) : (t(), M("div", Be))]), _: 1 }), _(l, { key: "importMode", align: "center", label: "上传模式", prop: "importMode", "show-overflow-tooltip": "" }, { default: u((o) => [o.row.importMode ? (t(), g(p, { key: 0, effect: "plain", size: "large" }, { default: u(() => {
      var y;
      return [v(r((y = n(O).VL) == null ? void 0 : y[o.row.importMode]), 1)];
    }), _: 2 }, 1024)) : f("", true)]), _: 1 }), _(l, { key: "edition", align: "center", label: "模型版本", prop: "edition", "show-overflow-tooltip": "" }, { default: u((o) => [o.row.edition ? (t(), g(p, { key: 0, type: "success", size: "large", effect: "plain" }, { default: u(() => {
      var y;
      return [v(r((y = n(q).VL) == null ? void 0 : y[o.row.edition]), 1)];
    }), _: 2 }, 1024)) : f("", true)]), _: 1 }), _(l, { key: "successQuantity", prop: "successQuantity", "show-overflow-tooltip": "", label: "转换成功次数", align: "center" }), n(Le)([...n(z).import, ...n(z).detail]) ? (t(), g(l, { key: "model", prop: "model", "show-overflow-tooltip": true, label: "操作", align: "center", width: "130" }, { default: u((o) => [F((t(), g(h, { size: "default", type: "warning", onClick: (y) => ee(o.row) }, { default: u(() => a[10] || (a[10] = [v("配置")])), _: 2, __: [10] }, 1032, ["onClick"])), [[x, n(z).import]]), F(_(h, { disabled: !o.row.importMode || !o.row.edition, type: "primary", size: "default", icon: "el-icon-document", onClick: (y) => ae(o.row) }, null, 8, ["disabled", "onClick"]), [[x, n(z).detail]])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "loading", "max-height"])), [[te, L.value]]), _(N, { ref_key: "drawerRef", ref: J, modelValue: C.value, "onUpdate:modelValue": a[1] || (a[1] = (o) => C.value = o), title: `模型${d.value.importMode ? "【" + n(O).VL[d.value.importMode] + "】" : ""}`, "append-to-body": "", "show-close": "", size: "60%" }, { titleAfter: u(() => [d.value.projectShortName ? (t(), g(p, { key: 0, effect: "plain", size: "large" }, { default: u(() => [v(r(d.value.projectShortName), 1)]), _: 1 })) : f("", true), d.value.name ? (t(), g(p, { key: 1, effect: "plain", size: "large" }, { default: u(() => [v(r(d.value.name), 1)]), _: 1 })) : f("", true), d.value.edition ? (t(), g(p, { key: 2, effect: "plain", size: "large", type: "warning" }, { default: u(() => {
      var o;
      return [v(r((o = n(q).VL) == null ? void 0 : o[d.value.edition]), 1)];
    }), _: 1 })) : f("", true)]), content: u(() => [(t(), g(ce(Y.value), { ref_key: "modelContentRef", ref: I, info: d.value, "project-id": n(w).id, onClose: a[0] || (a[0] = (o) => C.value = false), onSuccess: G, onTranslateSuccess: le }, null, 40, ["info", "project-id"]))]), _: 1 }, 8, ["modelValue", "title"]), _(Se, { modelValue: j.value, "onUpdate:modelValue": a[2] || (a[2] = (o) => j.value = o), form: m.value, onSuccess: E }, null, 8, ["modelValue", "form"]), _(n(xe), { visible: P.value, "onUpdate:visible": a[3] || (a[3] = (o) => P.value = o), info: d.value, onSuccess: G }, null, 8, ["visible", "info"])]);
  };
} }, la = Me(He, [["__scopeId", "data-v-209720d6"]]);
export {
  la as default
};
