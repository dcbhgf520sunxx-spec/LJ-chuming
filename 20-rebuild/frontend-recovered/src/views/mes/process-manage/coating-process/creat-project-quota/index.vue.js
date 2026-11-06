import { useStore as Ge } from "vuex";
import He from "moment";
import { ref as T } from "vue";
import { computed as N } from "vue";
import { watch as M } from "vue";
import { ElMessage as q } from "element-plus";
import { resolveComponent as oe } from "vue";
import { openBlock as p } from "vue";
import { createBlock as k } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as n } from "vue";
import { unref as W } from "vue";
import { createTextVNode as se } from "vue";
import { createCommentVNode as ve } from "vue";
import { createElementBlock as V } from "vue";
import { Fragment as B } from "vue";
import { renderList as A } from "vue";
import { normalizeClass as _ } from "vue";
import { toDisplayString as x } from "vue";
import { isRef as We } from "vue";
import { ElNotification as K } from "element-plus";
import { ElInput as Ke } from "element-plus";
import { ElOption as Xe } from "element-plus";
import { ElSelect as Ze } from "element-plus";
import { ElFormItem as $e } from "element-plus";
import { ElDatePicker as ea } from "element-plus";
import { ElInputNumber as aa } from "element-plus";
import { ElCheckbox as la } from "element-plus";
import { ElForm as ta } from "element-plus";
import { g as ia, a as na, b as oa, e as sa, c as ra } from "../../../../../modules/creation-process-d3879d47.js";
import { _ as ua, m as da, fg as pa, u as ca, i as U, bY as m, bC as ma, c as va, D as fa, q as ga, cy as ba, ou as ya } from "../../../../../shared/runtime.js";
const ha = { class: "flex-rbc" }, Ta = { class: "Navbar" }, Va = { class: "input-underline" }, _a = { class: "input-border-none" }, Pa = { class: "input-border-none" }, Ca = { class: "input-border-none" }, ka = { class: "input-border-none" }, wa = { class: "input-border-none" }, Ia = { class: "paint-type" }, La = { class: "paint-type-form" }, Na = { class: "input-border-none" }, xa = { class: "input-border-none" }, Fa = { class: "input-border-none" }, Ea = { class: "input-border-none" }, Da = { key: 0, class: "dosage" }, Ba = { key: 1, class: "dosage-tips" }, Aa = { class: "paint-type" }, Ra = { class: "paint-type-form" }, qa = { class: "input-border-none" }, Ua = { class: "input-border-none" }, Sa = { class: "input-border-none" }, Oa = { class: "input-border-none" }, ja = { key: 0, class: "dosage" }, za = { key: 1, class: "dosage-tips" }, Ma = { class: "paint-type" }, Ya = { class: "paint-type-form" }, Ja = { class: "input-border-none" }, Qa = { class: "input-border-none" }, Ga = { class: "input-border-none" }, Ha = { class: "input-border-none" }, Wa = { key: 0, class: "dosage" }, Ka = { key: 1, class: "dosage-tips" }, Xa = { __name: "index", props: { visible: { type: Boolean, default: false }, paintSelectList: { type: Array, default: () => [] }, secondaryData: { type: Object, default: () => {
} } }, emits: ["update:visible", "submitSuccess"], setup(fe, { emit: ge }) {
  var me;
  const be = Ge(), { user: ye } = da("user"), { projectTree: he } = pa(), re = ge, w = fe, ue = { serialNumber: void 0, projectId: void 0, monomerIdList: [], surfaceArea: void 0, createUserId: (me = ye.value) == null ? void 0 : me.id, createDate: He().startOf("day").valueOf(), detailParamList: [] }, Te = T([{ label: "创建定额编号", value: 1 }, { label: "引用定额", value: 2 }]), C = T(), t = T(JSON.parse(JSON.stringify(ue))), X = T(false), v = T(true), f = T(true), g = T(true), b = T(), y = T(), h = T(), Y = T(1), Z = T([]), de = T(), { visible: $, handleClose: pe } = ca({ emit: re, props: w, field: "visible", showHook: xe, closeHook: Ye }), R = N(() => U(w.secondaryData)), S = N(() => Y.value === 2), I = T(), Ve = N(() => {
    let a = [];
    return a = he.value.map((e) => (e.serialNumberName = e.serialNumber + " " + e.name, e)), a || [];
  }), J = (a, e, i) => {
    !e && v.value ? i(new Error("请选择")) : i();
  }, Q = (a, e, i) => {
    !e && f.value ? i(new Error("请选择")) : i();
  }, G = (a, e, i) => {
    !e && g.value ? i(new Error("请选择")) : i();
  }, _e = { serialNumber: [{ required: true, message: "请输入定额编号", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], surfaceArea: [{ required: true, message: "请输入面积", trigger: "change" }], createUserId: [{ required: true, message: "请选择创建人", trigger: "change" }], createDate: [{ required: true, message: "请选择创建日期", trigger: "change" }], primerPaintBrand: [{ validator: J, message: "请选择底漆品牌", trigger: "change", required: true }], primerPaintType: [{ validator: J, message: "请选择底漆材质", trigger: "change", required: true }], primerFilmThickness: [{ validator: J, message: "请输入底漆漆膜厚度", trigger: "change", required: true }], primerLossCoefficient: [{ validator: J, message: "请输入底漆损耗系数", trigger: "change", required: true }], intermediatePaintBrand: [{ validator: Q, message: "请选择中间漆品牌", trigger: "change", required: true }], intermediatePaintType: [{ validator: Q, message: "请选择中间漆材质", trigger: "change", required: true }], intermediateFilmThickness: [{ validator: Q, message: "请输入中间漆漆膜厚度", trigger: "change", required: true }], intermediateLossCoefficient: [{ validator: Q, message: "请输入中间漆损耗系数", trigger: "change", required: true }], topcoatPaintBrand: [{ validator: G, message: "请选择面漆品牌", trigger: "change", required: true }], topcoatPaintType: [{ validator: G, message: "请选择面漆材质", trigger: "change", required: true }], topcoatFilmThickness: [{ validator: G, message: "请输入面漆漆膜厚度", trigger: "change", required: true }], topcoatLossCoefficient: [{ validator: G, message: "请输入面漆损耗系数", trigger: "change", required: true }] };
  function Pe(a) {
    return a > /* @__PURE__ */ new Date();
  }
  const Ce = N(() => {
    var e, i;
    let a = [];
    return a = (e = w.paintSelectList) == null ? void 0 : e.find((s) => s.id === m.PRIMER.V), ((i = a == null ? void 0 : a.nameInfos) == null ? void 0 : i.map((s) => s.name)) || [];
  }), ke = N(() => {
    var i, s, d;
    let a = [];
    const e = (i = w.paintSelectList) == null ? void 0 : i.find((u) => u.id === m.PRIMER.V);
    return t.value.primerPaintBrand && (a = (s = e == null ? void 0 : e.nameInfos) == null ? void 0 : s.find((u) => u.name === t.value.primerPaintBrand)), ((d = a == null ? void 0 : a.nameInfos) == null ? void 0 : d.map((u) => u.name)) || [];
  }), we = N(() => {
    var e, i;
    let a = [];
    return a = (e = w.paintSelectList) == null ? void 0 : e.find((s) => s.id === m.INTERMEDIATE_PAINT.V), ((i = a == null ? void 0 : a.nameInfos) == null ? void 0 : i.map((s) => s.name)) || [];
  }), Ie = N(() => {
    var i, s, d;
    let a = [];
    const e = (i = w.paintSelectList) == null ? void 0 : i.find((u) => u.id === m.INTERMEDIATE_PAINT.V);
    return t.value.intermediatePaintBrand && (a = (s = e == null ? void 0 : e.nameInfos) == null ? void 0 : s.find((u) => u.name === t.value.intermediatePaintBrand)), ((d = a == null ? void 0 : a.nameInfos) == null ? void 0 : d.map((u) => u.name)) || [];
  }), Le = N(() => {
    var e, i;
    let a = [];
    return a = (e = w.paintSelectList) == null ? void 0 : e.find((s) => s.id === m.TOPCOAT.V), ((i = a == null ? void 0 : a.nameInfos) == null ? void 0 : i.map((s) => s.name)) || [];
  }), Ne = N(() => {
    var i, s, d;
    let a = [];
    const e = (i = w.paintSelectList) == null ? void 0 : i.find((u) => u.id === m.TOPCOAT.V);
    return t.value.topcoatPaintBrand && (a = (s = e == null ? void 0 : e.nameInfos) == null ? void 0 : s.find((u) => u.name === t.value.topcoatPaintBrand)), ((d = a == null ? void 0 : a.nameInfos) == null ? void 0 : d.map((u) => u.name)) || [];
  });
  function xe() {
    if (H(), Y.value = 1, R.value) {
      const { secondaryData: a } = w;
      ce(a), I.value = true;
    }
  }
  function ce(a) {
    var i;
    const e = (a == null ? void 0 : a.detailList) || [];
    t.value.serialNumber = (a == null ? void 0 : a.serialNumber) || void 0, t.value.projectId = (a == null ? void 0 : a.projectId) || void 0, t.value.monomerIdList = (a == null ? void 0 : a.monomerIdList) || void 0, t.value.surfaceArea = (a == null ? void 0 : a.surfaceArea) || void 0, t.value.createUserId = (a == null ? void 0 : a.createUserId) || void 0, t.value.createDate = (a == null ? void 0 : a.createDate) || void 0, t.value.detailParamList = (a == null ? void 0 : a.detailList) || void 0, (i = a == null ? void 0 : a.detailList) != null && i.length && (a.detailList.forEach((s) => {
      Fe(s);
    }), v.value = ee(e, m.PRIMER.V), f.value = ee(e, m.INTERMEDIATE_PAINT.V), g.value = ee(e, m.TOPCOAT.V));
  }
  function Fe(a) {
    switch (a.paintingTypeEnum) {
      case m.PRIMER.V:
        b.value = a, t.value.primerPaintBrand = a.paintBrand, t.value.primerPaintType = a.paintType, t.value.primerFilmThickness = a.paintFilmThickness, t.value.primerLossCoefficient = a.lossCoefficient;
        break;
      case m.INTERMEDIATE_PAINT.V:
        y.value = a, t.value.intermediatePaintBrand = a.paintBrand, t.value.intermediatePaintType = a.paintType, t.value.intermediateFilmThickness = a.paintFilmThickness, t.value.intermediateLossCoefficient = a.lossCoefficient;
        break;
      case m.TOPCOAT.V:
        h.value = a, t.value.topcoatPaintBrand = a.paintBrand, t.value.topcoatPaintType = a.paintType, t.value.topcoatFilmThickness = a.paintFilmThickness, t.value.topcoatLossCoefficient = a.lossCoefficient;
        break;
    }
  }
  function ee(a, e) {
    return a.some((i) => i.paintingTypeEnum === e);
  }
  function ae(a = [], e) {
    Array.isArray(a) && (a.forEach((i) => {
      t.value && Object.prototype.hasOwnProperty.call(t.value, i) && (t.value[i] = void 0), C.value && typeof C.value.clearValidate == "function" && C.value.clearValidate(i);
    }), e && typeof e == "object" && "value" in e && (e.value = {}));
  }
  function Ee(a) {
    if (!f.value && !g.value) {
      v.value = true, K({ title: "至少选择一种油漆类型！", type: "warning" });
      return;
    }
    a || ae(["primerPaintBrand", "primerPaintType", "primerFilmThickness", "primerLossCoefficient"], b);
  }
  function De(a) {
    if (!v.value && !g.value) {
      f.value = true, K({ title: "至少选择一种油漆类型！", type: "warning" });
      return;
    }
    a || ae(["intermediatePaintBrand", "intermediatePaintType", "intermediateFilmThickness", "intermediateLossCoefficient"], y);
  }
  function Be(a) {
    if (!v.value && !f.value) {
      g.value = true, K({ title: "至少选择一种油漆类型！", type: "warning" });
      return;
    }
    a || ae(["topcoatPaintBrand", "topcoatPaintType", "topcoatFilmThickness", "topcoatLossCoefficient"], h);
  }
  function Ae(a) {
    a === 2 && Oe(), H();
  }
  function Re(a) {
    if (a) {
      const e = Z.value.find((i) => i.name === a);
      de.value = e == null ? void 0 : e.id, e != null && e.id && (H(), je(e.id), I.value = true);
    } else H();
  }
  function qe(a) {
    t.value.monomerIdList = [], I.value = false;
  }
  function Ue(a) {
    a && (I.value = false);
  }
  function O() {
    I.value = false;
  }
  function le(a, e) {
    t.value[e] = void 0;
  }
  function j(a, e) {
    e.theoreticalCoatingRate = void 0, e.practicalSpreadingRate = void 0, e.weight = void 0, e.quantity = void 0;
  }
  function H() {
    C.value && C.value.clearValidate(), C.value && C.value.resetFields(), t.value = JSON.parse(JSON.stringify(ue)), b.value = {}, y.value = {}, h.value = {}, v.value = true, f.value = true, g.value = true, ma(C, t);
  }
  M([() => t.value.primerPaintBrand, () => t.value.primerPaintType], ([a, e]) => {
    a && e && !I.value && te(m.PRIMER.V, a, e);
  }, { deep: true }), M([() => t.value.intermediatePaintBrand, () => t.value.intermediatePaintType], ([a, e]) => {
    a && e && !I.value && te(m.INTERMEDIATE_PAINT.V, a, e);
  }, { deep: true }), M([() => t.value.topcoatPaintBrand, () => t.value.topcoatPaintType], ([a, e]) => {
    a && e && !I.value && te(m.TOPCOAT.V, a, e);
  }, { deep: true }), M([() => t.value.projectId, () => t.value.monomerIdList], ([a, e]) => {
    (a || e != null && e.length) && !I.value && Se();
  }, { deep: true }), M(() => t.value.surfaceArea, (a) => {
    [b.value, y.value, h.value].forEach((i) => {
      U(i) && (i.theoreticalCoatingRate = void 0, i.practicalSpreadingRate = void 0, i.weight = void 0, i.quantity = void 0);
    });
  }, { deep: true });
  async function Se() {
    try {
      const a = { projectId: t.value.projectId, monomerIdList: t.value.monomerIdList }, e = await ia(a);
      if (!e) {
        q.error("该项目单体下面积为0！"), t.value.surfaceArea = void 0;
        return;
      }
      const i = va(e, "mm2", "m2", fa.COM_AREA__M2);
      t.value.surfaceArea = i || void 0;
    } catch (a) {
      console.log(a);
    }
  }
  async function Oe() {
    try {
      const a = await oa();
      Z.value = a || [];
    } catch (a) {
      console.log(a);
    }
  }
  async function je(a) {
    try {
      const e = await ya(a);
      U(e) && ce(e);
    } catch (e) {
      console.log(e);
    }
  }
  async function te(a, e, i) {
    try {
      const s = { paintingTypeEnum: a, paintBrand: e, paintType: i }, { content: d = [] } = await na(s);
      switch (a) {
        case m.PRIMER.V:
          b.value = (d == null ? void 0 : d[0]) || {};
          break;
        case m.INTERMEDIATE_PAINT.V:
          y.value = (d == null ? void 0 : d[0]) || {};
          break;
        case m.TOPCOAT.V:
          h.value = (d == null ? void 0 : d[0]) || {};
          break;
        default:
          break;
      }
    } catch (s) {
      console.log(s);
    }
  }
  async function ze() {
    await C.value.validate() && (U(b.value) && ie(b.value, t.value.primerFilmThickness, t.value.primerLossCoefficient), U(y.value) && ie(y.value, t.value.intermediateFilmThickness, t.value.intermediateLossCoefficient), U(h.value) && ie(h.value, t.value.topcoatFilmThickness, t.value.topcoatLossCoefficient));
  }
  function ie(a, e, i) {
    a.lossCoefficient = i, a.paintFilmThickness = e;
    const s = Number(a.volumeSolidContent), d = Number(a.specificGravity), u = Number(e), P = Number(i), c = Number(t.value.surfaceArea), z = Number(a.packageWeight);
    if (![s, d, u, P, c, z].every((L) => Number.isFinite(L))) {
      q.error("计算参数异常，请检查油漆配置和输入项！"), a.theoreticalCoatingRate = void 0, a.practicalSpreadingRate = void 0, a.weight = void 0, a.quantity = void 0;
      return;
    }
    if (d <= 0 || u <= 0 || P <= 0 || z <= 0) {
      q.error("比重、漆膜厚度、损耗系数和包装重量必须大于 0 ！"), a.theoreticalCoatingRate = void 0, a.practicalSpreadingRate = void 0, a.weight = void 0, a.quantity = void 0;
      return;
    }
    if (a.theoreticalCoatingRate = s * 10 / (d * u), a.practicalSpreadingRate = a.theoreticalCoatingRate / P, !Number.isFinite(a.practicalSpreadingRate) || a.practicalSpreadingRate <= 0) {
      q.error("实际涂布率异常，请检查输入参数"), a.weight = void 0, a.quantity = void 0;
      return;
    }
    if (a.weight = c / a.practicalSpreadingRate, !Number.isFinite(a.weight)) {
      q.error("需求重量计算异常"), a.quantity = void 0;
      return;
    }
    if (a.quantity = a.weight / z, !Number.isFinite(a.quantity)) {
      q.error("包装数量计算异常"), a.quantity = void 0;
      return;
    }
  }
  async function Me() {
    var a;
    X.value = true;
    try {
      if (await C.value.validate(), t.value.detailParamList = [], [b.value, y.value, h.value].forEach((d) => {
        U(d) && t.value.detailParamList.push(d);
      }), (a = t.value.detailParamList) == null ? void 0 : a.some((d) => !d.quantity)) {
        K({ title: "请先计算用量，确认后发起审批！", type: "warning" });
        return;
      }
      await (R.value || S.value ? sa({ ...t.value, id: S.value ? de.value : w.secondaryData.id }) : ra(t.value)), q({ message: "发起审批成功！", type: "success" }), await be.dispatch("approval_list/fetchApprovalNum"), re("submitSuccess"), pe();
    } catch (e) {
      console.log(e);
    } finally {
      X.value = false;
    }
  }
  function Ye() {
  }
  return (a, e) => {
    const i = oe("common-button"), s = oe("common-radio-button"), d = Ke, u = Xe, P = Ze, c = $e, z = ea, L = aa, ne = la, Je = ta, Qe = oe("common-drawer");
    return p(), k(Qe, { "append-to-body": "", ref: "drawerRef", title: "创建项目涂装定额", modelValue: W($), "onUpdate:modelValue": e[32] || (e[32] = (l) => We($) ? $.value = l : null), "show-close": false, "close-on-click-modal": false, size: "40%", "custom-class": "creat-project-quota-drawer" }, { title: o(() => [r("div", ha, [e[35] || (e[35] = r("span", { class: "drawer-title" }, "创建项目涂装定额", -1)), r("span", null, [n(i, { size: "default", onClick: W(pe) }, { default: o(() => e[33] || (e[33] = [se("关 闭")])), _: 1, __: [33] }, 8, ["onClick"]), n(i, { size: "default", type: "success", loading: X.value, onClick: Me }, { default: o(() => e[34] || (e[34] = [se("发起审批")])), _: 1, __: [34] }, 8, ["loading"])])]), r("div", Ta, [n(s, { modelValue: Y.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => Y.value = l), options: Te.value, dataStructure: { key: "value", label: "label", value: "value" }, disabled: R.value, class: "filter-item", default: "", onChange: Ae }, null, 8, ["modelValue", "options", "disabled"]), n(i, { size: "default", type: "primary", onClick: ze }, { default: o(() => e[36] || (e[36] = [se("计算")])), _: 1, __: [36] })])]), content: o(() => [n(Je, { ref_key: "formRef", ref: C, model: t.value, rules: _e, inline: "", size: "default", "label-position": "right", "label-width": "120px" }, { default: o(() => [n(c, { label: "定额编号：", prop: "serialNumber", key: "serialNumber", style: { width: "100%", "margin-bottom": "20px" } }, { default: o(() => [r("div", Va, [S.value ? ve("", true) : (p(), k(d, { key: 0, modelValue: t.value.serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (l) => t.value.serialNumber = l), modelModifiers: { trim: true }, placeholder: "填写定额编号", disabled: R.value, clearable: "", style: { width: "100%" }, maxlength: "15" }, null, 8, ["modelValue", "disabled"])), S.value ? (p(), k(P, { key: 1, modelValue: t.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (l) => t.value.serialNumber = l), placeholder: "选择定额编号", clearable: "", filterable: "", disabled: R.value, style: { width: "480px" }, onChange: Re }, { default: o(() => [(p(true), V(B, null, A(Z.value, (l) => (p(), k(u, { key: l.id, label: l.name, value: l.name }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])) : ve("", true)])]), _: 1 }), n(c, { label: "选择项目", prop: "projectId" }, { default: o(() => [r("div", _a, [n(P, { modelValue: t.value.projectId, "onUpdate:modelValue": e[3] || (e[3] = (l) => t.value.projectId = l), placeholder: "选择项目", clearable: "", filterable: "", disabled: R.value || S.value, class: _({ "not-allowed": R.value || S.value }), style: { width: "480px" } }, { default: o(() => [(p(true), V(B, null, A(Ve.value, (l) => (p(), k(u, { key: l.id, label: l.serialNumberName, value: l.id, onClick: qe }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "选择单体", prop: "monomerIdList" }, { default: o(() => [r("div", Pa, [n(W(ga), { ref: "monomerRef", modelValue: t.value.monomerIdList, "onUpdate:modelValue": e[4] || (e[4] = (l) => t.value.monomerIdList = l), "project-id": t.value.projectId, clearable: "", multiple: "", default: false, defaultValue: t.value.monomerIdList || void 0, "collapse-tags": "", placeholder: "全部单体", class: "monomer-select", onVisibleChange: Ue }, null, 8, ["modelValue", "project-id", "defaultValue"])])]), _: 1 }), n(c, { label: "创建人", prop: "createUserId" }, { default: o(() => [r("div", Ca, [n(W(ba), { modelValue: t.value.createUserId, "onUpdate:modelValue": e[5] || (e[5] = (l) => t.value.createUserId = l), "collapse-tags": false, filterable: "", "show-all-levels": "", placeholder: "选择创建人", style: { width: "480px" } }, null, 8, ["modelValue"])])]), _: 1 }), n(c, { label: "创建日期", prop: "createDate" }, { default: o(() => [r("div", ka, [n(z, { modelValue: t.value.createDate, "onUpdate:modelValue": e[6] || (e[6] = (l) => t.value.createDate = l), type: "date", size: "default", class: "date-item filter-item", placeholder: "选择日期", format: "YYYY-MM-DD", "value-format": "x", "disabled-date": Pe, style: { width: "480px" } }, null, 8, ["modelValue"])])]), _: 1 }), n(c, { label: "面积(m²)", prop: "surfaceArea" }, { default: o(() => [r("div", wa, [n(L, { modelValue: t.value.surfaceArea, "onUpdate:modelValue": e[7] || (e[7] = (l) => t.value.surfaceArea = l), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, placeholder: "填写面积", size: "default", style: { width: "480px" } }, null, 8, ["modelValue"])])]), _: 1 }), r("div", Ia, [e[37] || (e[37] = r("span", { class: "paint-type-title" }, "底漆", -1)), n(ne, { class: "checkbox-style", modelValue: v.value, "onUpdate:modelValue": e[8] || (e[8] = (l) => v.value = l), size: "large", onChange: Ee }, null, 8, ["modelValue"])]), r("div", La, [n(c, { label: "油漆品牌", prop: "primerPaintBrand" }, { default: o(() => [r("div", Na, [n(P, { modelValue: t.value.primerPaintBrand, "onUpdate:modelValue": e[9] || (e[9] = (l) => t.value.primerPaintBrand = l), placeholder: "请选择品牌", clearable: "", filterable: "", disabled: !v.value, class: _({ "not-allowed": !v.value }), style: { width: "480px" }, onChange: e[10] || (e[10] = (l) => le(l, "primerPaintType")) }, { default: o(() => [(p(true), V(B, null, A(Ce.value, (l) => (p(), k(u, { key: l, label: l, value: l, onClick: O }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "油漆材质", prop: "primerPaintType" }, { default: o(() => [r("div", xa, [n(P, { modelValue: t.value.primerPaintType, "onUpdate:modelValue": e[11] || (e[11] = (l) => t.value.primerPaintType = l), clearable: "", filterable: "", placeholder: "请选择材质", disabled: !v.value || !t.value.primerPaintBrand, class: _({ "not-allowed": !v.value || !t.value.primerPaintBrand }), style: { width: "480px" } }, { default: o(() => [(p(true), V(B, null, A(ke.value, (l) => (p(), k(u, { key: l, label: l, value: l, onClick: O }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "漆膜厚度(μm)", prop: "primerFilmThickness" }, { default: o(() => [r("div", Fa, [n(L, { modelValue: t.value.primerFilmThickness, "onUpdate:modelValue": e[12] || (e[12] = (l) => t.value.primerFilmThickness = l), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, disabled: !v.value, placeholder: "填写漆膜厚度", size: "default", class: _({ "not-allowed": !v.value }), style: { width: "480px" }, onChange: e[13] || (e[13] = (l) => j(l, b.value)) }, null, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "损耗系数", prop: "primerLossCoefficient" }, { default: o(() => [r("div", Ea, [n(L, { modelValue: t.value.primerLossCoefficient, "onUpdate:modelValue": e[14] || (e[14] = (l) => t.value.primerLossCoefficient = l), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, disabled: !v.value, placeholder: "填写损耗系数", size: "default", class: _({ "not-allowed": !v.value }), style: { width: "480px" }, onChange: e[15] || (e[15] = (l) => j(l, b.value)) }, null, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "用量：" }, { default: o(() => {
      var l, F, E, D;
      return [(l = b.value) != null && l.weight && ((F = b.value) != null && F.quantity) ? (p(), V("div", Da, x(b.value.weight.toFixed(2)) + "kg、" + x((E = b.value) == null ? void 0 : E.quantity.toFixed(2)) + x((D = b.value) == null ? void 0 : D.packageUnit), 1)) : (p(), V("span", Ba, "根据上方填写内容计算"))];
    }), _: 1 })]), r("div", Aa, [e[38] || (e[38] = r("span", { class: "paint-type-title" }, "中间漆", -1)), n(ne, { class: "checkbox-style", modelValue: f.value, "onUpdate:modelValue": e[16] || (e[16] = (l) => f.value = l), size: "large", onChange: De }, null, 8, ["modelValue"])]), r("div", Ra, [n(c, { label: "油漆品牌", prop: "intermediatePaintBrand" }, { default: o(() => [r("div", qa, [n(P, { modelValue: t.value.intermediatePaintBrand, "onUpdate:modelValue": e[17] || (e[17] = (l) => t.value.intermediatePaintBrand = l), placeholder: "请选择品牌", clearable: "", filterable: "", disabled: !f.value, class: _({ "not-allowed": !f.value }), style: { width: "480px" }, onChange: e[18] || (e[18] = (l) => le(l, "intermediatePaintType")) }, { default: o(() => [(p(true), V(B, null, A(we.value, (l) => (p(), k(u, { key: l, label: l, value: l, onClick: O }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "油漆材质", prop: "intermediatePaintType" }, { default: o(() => [r("div", Ua, [n(P, { modelValue: t.value.intermediatePaintType, "onUpdate:modelValue": e[19] || (e[19] = (l) => t.value.intermediatePaintType = l), clearable: "", filterable: "", placeholder: "请选择材质", disabled: !f.value || !t.value.intermediatePaintBrand, class: _({ "not-allowed": !f.value || !t.value.intermediatePaintBrand }), style: { width: "480px" } }, { default: o(() => [(p(true), V(B, null, A(Ie.value, (l) => (p(), k(u, { key: l, label: l, value: l, onClick: O }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "漆膜厚度(μm)", prop: "intermediateFilmThickness" }, { default: o(() => [r("div", Sa, [n(L, { modelValue: t.value.intermediateFilmThickness, "onUpdate:modelValue": e[20] || (e[20] = (l) => t.value.intermediateFilmThickness = l), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, disabled: !f.value, placeholder: "填写漆膜厚度", size: "default", class: _({ "not-allowed": !f.value }), style: { width: "480px" }, onChange: e[21] || (e[21] = (l) => j(l, y.value)) }, null, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "损耗系数", prop: "intermediateLossCoefficient" }, { default: o(() => [r("div", Oa, [n(L, { modelValue: t.value.intermediateLossCoefficient, "onUpdate:modelValue": e[22] || (e[22] = (l) => t.value.intermediateLossCoefficient = l), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, disabled: !f.value, placeholder: "填写损耗系数", size: "default", class: _({ "not-allowed": !f.value }), style: { width: "480px" }, onChange: e[23] || (e[23] = (l) => j(l, y.value)) }, null, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "用量：" }, { default: o(() => {
      var l, F, E, D;
      return [(l = y.value) != null && l.weight && ((F = y.value) != null && F.quantity) ? (p(), V("div", ja, x(y.value.weight.toFixed(2)) + "kg、" + x((E = y.value) == null ? void 0 : E.quantity.toFixed(2)) + x((D = y.value) == null ? void 0 : D.packageUnit), 1)) : (p(), V("span", za, "根据上方填写内容计算"))];
    }), _: 1 })]), r("div", Ma, [e[39] || (e[39] = r("span", { class: "paint-type-title" }, "面漆", -1)), n(ne, { class: "checkbox-style", modelValue: g.value, "onUpdate:modelValue": e[24] || (e[24] = (l) => g.value = l), size: "large", onChange: Be }, null, 8, ["modelValue"])]), r("div", Ya, [n(c, { label: "油漆品牌", prop: "topcoatPaintBrand" }, { default: o(() => [r("div", Ja, [n(P, { modelValue: t.value.topcoatPaintBrand, "onUpdate:modelValue": e[25] || (e[25] = (l) => t.value.topcoatPaintBrand = l), placeholder: "请选择品牌", clearable: "", filterable: "", disabled: !g.value, class: _({ "not-allowed": !g.value }), style: { width: "480px" }, onChange: e[26] || (e[26] = (l) => le(l, "topcoatPaintType")) }, { default: o(() => [(p(true), V(B, null, A(Le.value, (l) => (p(), k(u, { key: l, label: l, value: l, onClick: O }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "油漆材质", prop: "topcoatPaintType" }, { default: o(() => [r("div", Qa, [n(P, { modelValue: t.value.topcoatPaintType, "onUpdate:modelValue": e[27] || (e[27] = (l) => t.value.topcoatPaintType = l), clearable: "", filterable: "", placeholder: "请选择材质", disabled: !g.value || !t.value.topcoatPaintBrand, class: _({ "not-allowed": !g.value || !t.value.topcoatPaintBrand }), style: { width: "480px" } }, { default: o(() => [(p(true), V(B, null, A(Ne.value, (l) => (p(), k(u, { key: l, label: l, value: l, onClick: O }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "漆膜厚度(μm)", prop: "topcoatFilmThickness" }, { default: o(() => [r("div", Ga, [n(L, { modelValue: t.value.topcoatFilmThickness, "onUpdate:modelValue": e[28] || (e[28] = (l) => t.value.topcoatFilmThickness = l), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, disabled: !g.value, placeholder: "填写漆膜厚度", size: "default", class: _({ "not-allowed": !g.value }), style: { width: "480px" }, onChange: e[29] || (e[29] = (l) => j(l, h.value)) }, null, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "损耗系数", prop: "topcoatLossCoefficient" }, { default: o(() => [r("div", Ha, [n(L, { modelValue: t.value.topcoatLossCoefficient, "onUpdate:modelValue": e[30] || (e[30] = (l) => t.value.topcoatLossCoefficient = l), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, disabled: !g.value, placeholder: "填写损耗系数", size: "default", class: _({ "not-allowed": !g.value }), style: { width: "480px" }, onChange: e[31] || (e[31] = (l) => j(l, h.value)) }, null, 8, ["modelValue", "disabled", "class"])])]), _: 1 }), n(c, { label: "用量：" }, { default: o(() => {
      var l, F, E, D;
      return [(l = h.value) != null && l.weight && ((F = h.value) != null && F.quantity) ? (p(), V("div", Wa, x(h.value.weight.toFixed(2)) + "kg、" + x((E = h.value) == null ? void 0 : E.quantity.toFixed(2)) + x((D = h.value) == null ? void 0 : D.packageUnit), 1)) : (p(), V("span", Ka, "根据上方填写内容计算"))];
    }), _: 1 })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, al = ua(Xa, [["__scopeId", "data-v-fe9ac586"]]);
export {
  al as default
};
