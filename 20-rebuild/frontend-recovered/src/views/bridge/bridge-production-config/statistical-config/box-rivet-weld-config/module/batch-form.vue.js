import { inject as y } from "vue";
import { ref as j } from "vue";
import { reactive as se } from "vue";
import { computed as L } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as d } from "vue";
import { createBlock as N } from "vue";
import { withCtx as r } from "vue";
import { createVNode as n } from "vue";
import { unref as i } from "vue";
import { createTextVNode as S } from "vue";
import { withDirectives as ie } from "vue";
import { createElementBlock as f } from "vue";
import { toDisplayString as R } from "vue";
import { createElementVNode as ne } from "vue";
import { Fragment as z } from "vue";
import { renderList as ce } from "vue";
import { createCommentVNode as re } from "vue";
import { withModifiers as de } from "vue";
import { nextTick as ue } from "vue";
import { ElTableColumn as pe } from "element-plus";
import { ElForm as me } from "element-plus";
import { vLoading as fe } from "element-plus";
import { _ as be, a_ as ge, o as he, a$ as _e, i as T, aT as F, aw as ye, V as P, aI as ve } from "../../../../../../shared/runtime.js";
const xe = { key: 0 }, Ve = { key: 1 }, Ce = { key: 0 }, Oe = { key: 1 }, je = 5, Ne = { __name: "batch-form", props: { modelValue: { type: Boolean, require: true }, currentType: { type: Number, default: void 0 } }, setup(v) {
  const E = v, M = y("rivetWeldListObj"), Q = y("processList"), D = y("artifactTypeList"), x = y("artifactTypeListObj"), H = j(false), V = j(true), $ = se({ list: [] }), q = { classificationId: [{ required: true, message: "请选择分段类型", trigger: "change" }], numerical: [{ validator: (t, e) => !(!e.minNumerical || !e.maxNumerical || e.maxNumerical < e.minNumerical), message: "请填写数值并且最大数值不得小于最小数值", trigger: "blur" }] }, C = /* @__PURE__ */ new Map([["classificationId", -1]]), k = j(), { CRUD: O, crud: p, form: c } = ge($, k), w = L(() => p.bStatus.cu > O.STATUS.NORMAL), { tableValidate: A, cleanUpData: W, wrongCellMask: G } = ye({ rules: q, ditto: C }), { maxHeight: K } = he({ mainBox: ".rivet-weld-config-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, w);
  function J() {
    Z(c.list), V.value = true, ue(() => {
      V.value = false;
    });
  }
  O.HOOK.beforeValidateBCU = () => {
    const { validResult: t, dealList: e } = A(c.list);
    if (t) c.list = e;
    else return t;
  }, p.submitBatchFormFormat = async (t) => (W(t.list), t.list.map((s) => ({ boxTypeId: E.currentType, classificationId: s.classificationId, maxNumerical: s.maxNumerical, minNumerical: s.minNumerical, structureProcessPriceList: _e(s.processObj) })));
  const b = L(() => {
    var s;
    const t = {};
    if (!((s = c.list) != null && s.length)) return t;
    let e = null;
    for (let l = 0; l < c.list.length; l++) e = c.list[l].classificationId !== -1 ? c.list[l].classificationId : e, t[l] = e;
    return t;
  });
  function X(t, e) {
    var l, g;
    let s = {};
    T((l = x.value[t]) == null ? void 0 : l.typeProcessObj) && (s = (g = x.value[t]) == null ? void 0 : g.typeProcessObj);
    for (const m in b.value) b.value[m] === t && (c.list[m].processObj = P(s));
  }
  function Y(t, e, s) {
    for (const l in b.value) b.value[l] === b.value[e] && (c.list[Number(l)].processObj[s].wageQuotaType = t);
  }
  const Z = (t) => {
    t.length = 0;
    for (let e = 0; e < je; e++) U(t);
  }, U = (t) => {
    const e = { processObj: {} };
    e.uid = ve(), C && t.length > 0 && C.forEach((s, l) => {
      e[l] = s;
    }), t.length && T(t[t.length - 1].processObj) && (e.processObj = P(t[t.length - 1].processObj)), t.push(e);
  }, ee = (t, e) => {
    t.splice(e, 1);
  };
  return (t, e) => {
    var B;
    const s = _("common-button"), l = pe, g = _("common-select"), m = _("common-input-number"), te = _("common-table"), ae = me, le = _("common-dialog"), oe = fe;
    return d(), N(le, { fullscreen: "", "append-to-body": "", "close-on-click-modal": false, "before-close": i(p).cancelBCU, visible: w.value, title: `${i(p).bStatus.title}${v.currentType ? `: ${(B = i(M)[v.currentType]) == null ? void 0 : B.typeName}` : ""}`, "show-close": false, "custom-class": "rivet-weld-config-batch-add", onOpened: J, top: "10vh" }, { titleRight: r(() => [n(s, { size: "default", type: "success", icon: "el-icon-plus", onClick: e[0] || (e[0] = (a) => U(i(c).list)) }), n(s, { loading: i(p).bStatus.cu === i(O).STATUS.PROCESSING, type: "primary", size: "default", onClick: i(p).submitBCU }, { default: r(() => e[1] || (e[1] = [S(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), n(s, { size: "default", onClick: i(p).cancelBCU }, { default: r(() => e[2] || (e[2] = [S("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: r(() => [n(ae, { ref_key: "formRef", ref: k, model: i(c), disabled: H.value }, { default: r(() => [ie((d(), N(te, { ref: "table", data: i(c).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": i(K), "default-expand-all": "", "cell-class-name": i(G), "row-key": "uid" }, { default: r(() => [n(l, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), n(l, { prop: "classificationId", "show-overflow-tooltip": true, label: "分段类型", width: "150", align: "center", fixed: "left" }, { default: r(({ row: a, $index: o }) => [n(g, { modelValue: a.classificationId, "onUpdate:modelValue": (u) => a.classificationId = u, options: i(D), "show-extra": o !== 0, type: "other", class: "input-underline", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "分段类型", style: { width: "100%" }, onChange: (u) => X(u, o) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])]), _: 1 }), n(l, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", width: "150", align: "center", fixed: "left" }, { default: r(({ row: a, $index: o }) => {
      var u;
      return [a.classificationId === -1 && o !== 0 ? (d(), f("span", xe, "同上")) : (d(), f("span", Ve, R(a.classificationId && ((u = i(x)[a.classificationId]) == null ? void 0 : u.specPrefixStr)), 1))];
    }), _: 1 }), n(l, { prop: "numerical", "show-overflow-tooltip": true, label: "数值", width: "200", align: "center", fixed: "left" }, { default: r(({ row: a }) => [n(m, { modelValue: a.minNumerical, "onUpdate:modelValue": (o) => a.minNumerical = o, step: 1, min: 0, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), e[3] || (e[3] = ne("span", null, " ~ ", -1)), n(m, { modelValue: a.maxNumerical, "onUpdate:modelValue": (o) => a.maxNumerical = o, step: 1, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), n(l, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: r(() => [(d(true), f(z, null, ce(i(Q), (a) => (d(), N(l, { key: a.id, "show-overflow-tooltip": true, align: "center", label: a.name, width: "240px" }, { default: r(({ row: o, $index: u }) => {
      var I;
      return [i(T)(o == null ? void 0 : o.processObj[a.id]) ? (d(), f(z, { key: 0 }, [n(g, { modelValue: o.processObj[a.id].wageQuotaType, "onUpdate:modelValue": (h) => o.processObj[a.id].wageQuotaType = h, options: i(F).ENUM, type: "enum", clearable: "", size: "default", class: "input-underline", placeholder: "计量方式", style: { width: "45%", "margin-right": "5px" }, onChange: (h) => Y(h, u, a.id) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]), n(m, { modelValue: o.processObj[a.id].price, "onUpdate:modelValue": (h) => o.processObj[a.id].price = h, step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, size: "default", placeholder: "单价", style: { width: "30%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), (I = o == null ? void 0 : o.processObj[a.id]) != null && I.wageQuotaType ? (d(), f("span", Ce, R(i(F).V[o.processObj[a.id].wageQuotaType].unit), 1)) : re("", true)], 64)) : (d(), f("span", Oe, "-"))];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), n(l, { "min-width": "1px" }), n(l, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: r(({ $index: a }) => [n(s, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: de((o) => ee(i(c).list, a), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[oe, V.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ue = be(Ne, [["__scopeId", "data-v-e1d56b0a"]]);
export {
  Ue as default
};
