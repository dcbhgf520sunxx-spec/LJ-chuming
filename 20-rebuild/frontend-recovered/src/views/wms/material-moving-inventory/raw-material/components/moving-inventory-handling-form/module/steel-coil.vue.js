import { computed as V } from "vue";
import { ref as P } from "vue";
import { provide as We } from "vue";
import { watch as S } from "vue";
import { reactive as $e } from "vue";
import { watchEffect as Se } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as ze } from "vue";
import { unref as h } from "vue";
import { openBlock as f } from "vue";
import { createBlock as Me } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as u } from "vue";
import { createSlots as Ne } from "vue";
import { createElementBlock as g } from "vue";
import { createCommentVNode as Q } from "vue";
import { normalizeClass as Z } from "vue";
import { toDisplayString as y } from "vue";
import { withDirectives as ee } from "vue";
import { Fragment as R } from "vue";
import { normalizeStyle as z } from "vue";
import { renderList as te } from "vue";
import { ElMessage as B } from "element-plus";
import { ElFormItem as Pe } from "element-plus";
import { ElDescriptionsItem as Te } from "element-plus";
import { ElTableColumn as Oe } from "element-plus";
import { ElInput as Fe } from "element-plus";
import { ElForm as Re } from "element-plus";
import { s as je } from "../../../../../../../modules/application-0ee072a2.js";
import { _ as Ae, y1 as He, c as Ye, sQ as De, bC as Ke, iX as j, i as C, y2 as ae, qS as Ge, aw as Xe, fK as le, V as A, x_ as ie, jl as Je, b as Ze, c9 as O } from "../../../../../../../shared/runtime.js";
import et from "../components/common-form-item.vue.js";
import tt from "../components/common-material-info.vue.js";
import at from "../components/descriptions-material-info.vue.js";
import { M as ne } from "../../../../../../../modules/index-330e9f5e.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const lt = { style: { "min-width": "800px" } }, it = { style: { display: "flex" } }, nt = { key: 0, class: "tip" }, st = { key: 0, class: "material-info" }, ot = { key: 1, class: "form-info" }, ut = { key: 2, class: "plate-out-material-info" }, rt = { key: 0, class: "tip", style: { "margin-top": "10px" } }, dt = { style: { display: "flex", "margin-bottom": "15px", "margin-top": "15px" } }, mt = { class: "total-info" }, ct = { class: "total-item" }, pt = { class: "total-value" }, ht = { class: "total-item" }, ft = { class: "total-value" }, vt = { class: "total-item total-item-surplus" }, gt = { class: "total-value" }, yt = { class: "total-item total-item-surplus" }, bt = { class: "total-value" }, _t = { key: 0, style: { "margin-left": "30px" } }, wt = { class: "other-info" }, xt = { style: { width: "530px" } }, kt = { style: { "margin-bottom": "10px" } }, I = 260, qt = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number } }, emits: ["confirmNext"], setup(F, { expose: se, emit: oe }) {
  const { steelMinLengthConfig: H } = He(), W = { BY_LENGTH: { L: "按长度出库", K: "BY_LENGTH ", V: 1 }, BY_PLATE: { L: "按条板出库", K: "BY_PLATE", V: 2 } }, ue = oe, Y = V(() => {
    var t, e;
    return (t = H.value) != null && t.steelPlateShortestSideMinLength ? Ye((e = H.value) == null ? void 0 : e.steelPlateShortestSideMinLength, "mm", "m") : 0;
  }), M = F, U = P(), a = P({ list: [] }), { loaded: re, baseUnit: b } = De(M.basicClass);
  Ke(U, a, ["quantity"]);
  const o = V(() => M.material || {}), x = P([{}]), D = P([]), _ = V(() => a.value.materialOutboundMode === W.BY_PLATE.V), de = { directionWorkshopId: [{ required: true, message: "请选择仓库", trigger: "blur" }], directionWarehouseId: [{ required: true, message: "请选择存储位置", trigger: "blur" }], quantity: [{ required: true, validator: (t, e, l) => {
    if (Ze(e)) return l(new Error("请填写数量"));
    if (e <= 0) return l(new Error("数量必须大于0"));
    if (e > E.value) return l(new Error("数量不可超过可操作数量"));
    l();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, me = { remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, ce = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: O, message: "宽度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: O, message: "数量必须大于0", trigger: "blur" }] }, K = { singleQuantity: [{ required: true, message: "请填写单段长度", trigger: "blur" }, { pattern: O, message: "单段长度必须大于0", trigger: "blur" }], segmentQuantity: [{ required: true, message: "请填写段数", trigger: "blur" }, { pattern: O, message: "段数必须大于0", trigger: "blur" }] }, { tableValidate: pe, wrongCellMask: he } = Xe({ rules: ce }), fe = V(() => _.value ? Object.assign({}, me) : Object.assign({}, de)), E = V(() => !a.value || !a.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[a.value.projectId] || 0));
  We("maxQuantity", E);
  const ve = V(() => j(E.value - a.value.quantity, o.value.outboundUnitPrecision)), ge = V(() => {
    var t, e;
    return a.value.quantity === E.value ? 0 : j(o.value.operableMete - a.value.totalWeight, (e = (t = b.value) == null ? void 0 : t.weight) == null ? void 0 : e.precision);
  }), k = V(() => {
    let t = o.value.width, e = a.value.singleTotalWeight;
    return a.value.list.forEach((l) => {
      t -= l.width * (l.quantity || 1) || 0, e -= l.mete || 0;
    }), { width: t, mete: e > 0 ? e : 0 };
  }), L = V(() => {
    let t = 0;
    return a.value.list.forEach((e) => {
      t += e.quantity || 0;
    }), k.value.width > 0 && (t += 1), t;
  });
  S(o, (t) => {
    ke(t);
  }, { immediate: true }), S(() => _.value, (t) => {
    if (t) {
      const e = X();
      a.value.list = [], a.value.list.push(e);
    }
  }, { immediate: true }), S([() => a.value.singleQuantity, () => a.value.segmentQuantity], () => {
    _.value && (a.value.quantity = j(a.value.singleQuantity && a.value.segmentQuantity ? a.value.singleQuantity * a.value.segmentQuantity : 0, o.value.outboundUnitPrecision));
  }), S(x.value, (t) => {
    let e = 0;
    C(t) && t.forEach((l) => {
      l.singleQuantity && l.segmentQuantity && (e += l.singleQuantity * l.segmentQuantity);
    }), a.value.quantity = e, G();
  }, { immediate: true, deep: true });
  async function G() {
    const t = [], e = [];
    a.value.totalWeight = 0, C(a.value.list) && C(x.value) && a.value.list.forEach((l) => {
      x.value.forEach((i) => {
        for (let v = 0; v < i.segmentQuantity; v++) t.push({ ...l, quantity: l.quantity || 0, length: i.singleQuantity || 0 });
      });
    });
    for (let l = 0; l < t.length; l++) {
      const i = t[l];
      if (i.mete = 0, C(i.quantity) && C(i.length) && C(i.width)) {
        const v = await ae({ classifyId: i.classifyId, name: i.name, length: i.length, width: i.width, thickness: i.thickness, quantity: i.quantity }).then((r) => {
          i.theoryWeight = r, i.mete = i.mete || i.theoryWeight;
        });
        v && e.push(v);
      }
    }
    await Promise.all(e), t.forEach((l) => {
      l.boolSurplus = false, l.boolOutbound = true, a.value.totalWeight += l.mete || 0;
    }), D.value = t;
  }
  function ye() {
    a.value.quantity = void 0, a.value.materialOutboundMode === W.BY_PLATE.V && ue("confirmNext", true);
  }
  function X() {
    const t = $e({ basicClass: M.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: void 0, quantity: void 0, outboundAddress: Ge.FACTORY.V, overWidth: false, overLength: false });
    return be(t), t;
  }
  function be(t) {
    S([() => t], () => {
      G();
    }, { immediate: true, deep: true });
  }
  Se(async () => {
  });
  function _e(t) {
    const e = X();
    a.value.list.splice(t + 1, 0, e);
  }
  function we(t) {
    a.value.list.splice(t, 1);
  }
  function xe(t) {
    x.value.splice(t, 1);
  }
  function ke(t) {
    var l;
    const e = { materialOutboundMode: W.BY_LENGTH.V, materialId: t.id, monomerId: t == null ? void 0 : t.monomerId, areaId: t == null ? void 0 : t.areaId, factoryId: (l = t.factory) == null ? void 0 : l.id, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, projectId: t.project ? t.project.id : void 0, recipientId: void 0, directionWarehouseId: void 0, directionWorkshopId: void 0, basicClass: t.basicClass, boolPartyA: t.boolPartyA, list: [], remark: void 0 };
    a.value = e;
  }
  function qe() {
    x.value.push({});
  }
  function J(t, e) {
    let l = 0;
    x.value.forEach((i) => {
      i.singleQuantity && i.segmentQuantity && (l += i.singleQuantity * i.segmentQuantity);
    }), l > E.value && (t[e] = void 0, B({ message: "开平总长不能大于可出库长度", type: "error" }));
  }
  function Ve({ row: t, column: e }) {
    if (!t) return;
    const l = K;
    let i = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[e.property] === false && (i = le(e.property, l[e.property], t)), i && (t.verify[e.property] = true)), i ? "" : "mask-td";
  }
  function Qe() {
    if (x.value.length <= 0) return B({ message: "请先填写单段长度配置", type: "error" }), false;
    const t = K;
    let e = true;
    return x.value.map((l) => {
      l.verify = {};
      for (const i in t) l.verify[i] = le(i, t[i], l), l.verify[i] || (e = false);
    }), e ? true : (B.error("请填写表格中标红数据"), false);
  }
  async function Ce() {
    var $, N;
    if (!Qe() || !await U.value.validate()) return false;
    const l = A(a.value);
    if (await ie(l, { unit: l.outboundUnit, precision: l.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), a.value.quantity > E.value) return B.error("开平总长不可大于可出库长度"), false;
    let i = 0;
    if (a.value.list.forEach((w) => {
      i += w.width * w.quantity;
    }), i > o.value.width) throw B.error(`条板总宽：${i}mm，条板总宽不可大于开平宽度`), new Error("宽度超出允许值");
    if ((($ = k.value) == null ? void 0 : $.width) < 0) throw B.error("余料错误"), new Error("余料错误");
    const { validResult: v } = pe(a.value.list);
    if (!v) return false;
    let r = A(D.value);
    const p = [];
    if (((N = k.value) == null ? void 0 : N.width) > 0) for (let w = 0; w < x.value.length; w++) p.push({ basicClass: M.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: k.value.width, length: x.value[w].singleQuantity, quantity: x.value[w].segmentQuantity, boolSurplus: true, boolOutbound: false });
    const q = [];
    for (let w = 0; w < p.length; w++) {
      const m = p[w];
      if (m.mete = 0, C(m.quantity) && C(m.length) && C(m.width)) {
        const s = await ae({ classifyId: m.classifyId, name: m.name, length: m.length, width: m.width, thickness: m.thickness, quantity: m.quantity }).then((c) => {
          m.theoryWeight = c, m.mete = m.mete || m.theoryWeight;
        });
        s && q.push(s);
      }
    }
    return await Promise.all(q), r = [...r, ...p], C(r) ? r : void 0;
  }
  async function Ie() {
    if (!await U.value.validate()) return false;
    const e = A(a.value);
    await ie(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), _.value && (e.battenList = await Je(e.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] }));
    const l = { directionWarehouseId: e.directionWarehouseId, directionWorkshopId: e.directionWorkshopId, basicClass: e.basicClass, detailList: [{ materialId: e.materialId, quantity: e.quantity, remark: e.remark }] };
    return await je(l);
  }
  function Ee() {
    U.value.resetFields();
  }
  function Ue() {
    U.value && U.value.clearValidate();
  }
  function Le(t) {
    const { columns: e, data: l } = t, i = [];
    return e.forEach((v, r) => {
      if (r === 0) {
        i[r] = "余料";
        return;
      }
      if (v.property === "width") {
        let p = o.value.width;
        l.forEach((q) => {
          p -= q.width * (q.quantity || 1) || 0;
        }), i[r] = p;
      }
      if (v.property === "mete") {
        let p = a.value.singleTotalWeight;
        l.forEach((q) => {
          p -= q.mete || 0;
        }), i[r] = p > 0 ? p : 0;
      }
      v.property === "quantity" && (i[r] = 1);
    }), i;
  }
  return se({ submit: Ie, nextSubmit: Ce, resetForm: Ee, clearValidate: Ue, enlargeWth: V(() => _.value) }), (t, e) => {
    const l = T("common-radio"), i = Pe, v = Te, r = Oe, p = T("common-input-number"), q = T("common-button"), $ = T("common-table"), N = Fe, w = Re, m = ze("empty");
    return h(re) ? (f(), Me(w, { key: 0, ref_key: "formRef", ref: U, model: a.value, rules: fe.value, "label-position": "left", "label-width": "120px", size: "default", style: { display: "flex", overflow: "auto" } }, { default: d(() => [n("div", lt, [u(i, { class: "material-outbound-mode-info", label: "出库方式" }, Ne({ default: d(() => [n("div", it, [u(l, { modelValue: a.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (s) => a.value.materialOutboundMode = s), options: W, unshowVal: [W.BY_PLATE.V], size: "default", type: "enum", onChange: ye }, null, 8, ["modelValue", "unshowVal"]), _.value ? (f(), g("div", nt, e[3] || (e[3] = [n("span", null, "* 提示：", -1), n("span", null, " 出库至钢板库后，无法再进行退库操作，请谨慎操作", -1)]))) : Q("", true)])]), _: 2 }, [_.value ? { name: "label", fn: d(() => [e[2] || (e[2] = n("span", { class: "set-title" }, "出库方式", -1))]), key: "0" } : void 0]), 1024), n("div", { class: Z(_.value ? "plate-out-form" : "form") }, [_.value ? Q("", true) : (f(), g("div", st, [u(tt, { form: a.value, material: o.value }, { afterSpec: d(() => [u(i, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${o.value.thickness}${h(b).thickness.unit} * ${o.value.width}${h(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [u(i, { label: "炉批号/卷号" }, { default: d(() => [ee(n("span", null, null, 512), [[m, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])), _.value ? Q("", true) : (f(), g("div", ot, [u(et, { form: a.value, material: o.value }, null, 8, ["form", "material"])])), _.value ? (f(), g("div", ut, [u(h(at), { form: a.value, material: o.value }, { afterSpec: d(() => [u(v, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${o.value.thickness}${h(b).thickness.unit} * ${o.value.width}${h(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [u(v, { label: "炉批号" }, { default: d(() => [ee(n("span", null, null, 512), [[m, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])) : Q("", true), _.value ? (f(), g(R, { key: 3 }, [e[11] || (e[11] = n("div", { class: "divider" }, null, -1)), e[12] || (e[12] = n("span", { class: "set-title" }, "单段配置", -1)), u($, { "cell-class-name": h(he), data: a.value.list, "max-height": F.maxHeight, "show-empty-symbol": false, "summary-method": Le, "return-source-data": "", "show-summary": "", style: { width: "100%", "margin-top": "15px" } }, { default: d(() => [u(r, { align: "center", label: "序号", type: "index", width: "60" }), u(r, { label: `宽 (${h(b).width.unit})`, align: "center", prop: "width" }, { default: d(({ row: s }) => [u(p, { modelValue: s.width, "onUpdate:modelValue": (c) => s.width = c, class: Z({ "over-weight-tip": s.overWidth }), controls: false, max: 999999999, min: Y.value, precision: h(b).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "min", "precision"])]), _: 1 }, 8, ["label"]), u(r, { align: "center", label: "数量 (张)", prop: "quantity" }, { default: d(({ row: s }) => [u(p, { modelValue: s.quantity, "onUpdate:modelValue": (c) => s.quantity = c, controls: false, max: 999999999, min: 1, precision: h(b).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), u(r, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: d(({ $index: s }) => [u(q, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => we(s) }, null, 8, ["onClick"]), u(q, { class: "icon-button", icon: "el-icon-plus", size: "default", type: "success", onClick: (c) => _e(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]), k.value.width < 0 ? (f(), g("div", rt, e[4] || (e[4] = [n("span", null, "* 错误提示：", -1), n("span", null, " 条板总宽不可大于开平宽度", -1)]))) : Q("", true), n("div", null, [e[10] || (e[10] = n("span", { class: "set-title", style: { "margin-top": "10px" } }, "单段开平预览（横向）", -1)), n("div", dt, [n("div", { style: z(`height:${I}px;`), class: "preview-info" }, [k.value.width && L.value > 1 || !k.value.width && L.value ? (f(), g("div", { key: 0, style: z(`height:${I}px;overflow:hidden;`) }, [(f(true), g(R, null, te(a.value.list, (s, c) => (f(), g("div", { key: c }, [s.quantity && s.width ? (f(true), g(R, { key: 0 }, te(s.quantity, (Be) => (f(), g("div", { key: Be, style: z({ marginBottom: c === a.value.list.length - 1 && !k.value.width ? "0px" : "1px", height: (I - (L.value - 1)) * s.width / o.value.width + "px", lineHeight: (I - (L.value - 1)) * s.width / o.value.width + "px" }), class: "plate-item" }, y(s.width) + y(h(b).width.unit), 5))), 128)) : Q("", true)]))), 128)), k.value.width ? (f(), g("div", { key: 0, style: z({ backgroundColor: "#c45656", height: (I - (L.value - 1)) * k.value.width / o.value.width + "px", lineHeight: (I - (L.value - 1)) * k.value.width / o.value.width + "px" }), class: "plate-item" }, y(k.value.width) + y(h(b).width.unit), 5)) : Q("", true)], 4)) : (f(), g("div", { key: 1, style: z(`height:${I}px;line-height:${I}px;text-align:center;color: #9e9ea1;border: 1px solid;`) }, e[5] || (e[5] = [n("span", null, "请配置单段配置！", -1)]), 4)), u(ne, { customStyle: `height:${I}px;right:-12px;top:0px;`, sizeInfo: `${o.value.width}${h(b).width.unit}`, direction: "vertical" }, null, 8, ["customStyle", "sizeInfo"]), u(ne, { customStyle: "width:100%;bottom:-30px;left:0px;", sizeInfo: `${a.value.singleQuantity || 0}${o.value.outboundUnit}`, direction: "horizontal" }, null, 8, ["sizeInfo"])], 4), n("div", mt, [n("div", ct, [e[6] || (e[6] = n("span", { class: "total-label" }, "开平总长", -1)), n("span", pt, y(a.value.quantity || 0) + " " + y(o.value.outboundUnit), 1)]), n("div", ht, [e[7] || (e[7] = n("span", { class: "total-label" }, "开平总重", -1)), n("span", ft, y(a.value.totalWeight || 0) + " " + y(h(b).weight.unit), 1)]), n("div", vt, [e[8] || (e[8] = n("span", { class: "total-label" }, "剩余长度", -1)), n("span", gt, y(ve.value || 0) + " " + y(o.value.outboundUnit), 1)]), n("div", yt, [e[9] || (e[9] = n("span", { class: "total-label" }, "剩余重量", -1)), n("span", bt, y(ge.value || 0) + " " + y(h(b).weight.unit), 1)])])])])], 64)) : Q("", true)], 2)]), _.value ? (f(), g("div", _t, [n("div", wt, [n("div", xt, [n("div", kt, [e[13] || (e[13] = n("span", { class: "set-title" }, "单段长度配置", -1)), u(q, { class: "icon-button", icon: "el-icon-plus", size: "default", style: { float: "right" }, type: "success", onClick: qe })]), u($, { "cell-class-name": Ve, data: x.value, "max-height": F.maxHeight, "show-empty-symbol": false, "return-source-data": "" }, { default: d(() => [u(r, { align: "center", label: "序号", type: "index", width: "55" }), u(r, { label: `单段长度(${o.value.outboundUnit})`, align: "center", "min-width": "120", prop: "singleQuantity" }, { default: d(({ row: s }) => [u(p, { modelValue: s.singleQuantity, "onUpdate:modelValue": (c) => s.singleQuantity = c, controls: false, max: E.value, min: Y.value, precision: o.value.outboundUnitPrecision, "controls-position": "right", placeholder: "单段长度", size: "default", onBlur: (c) => J(s, "singleQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), u(r, { label: "段数(段)", align: "center", "min-width": "120", prop: "segmentQuantity" }, { default: d(({ row: s }) => [u(p, { modelValue: s.segmentQuantity, "onUpdate:modelValue": (c) => s.segmentQuantity = c, controls: false, max: s.singleQuantity ? parseInt(E.value / s.singleQuantity) : 1, min: 0, precision: 0, "controls-position": "right", placeholder: "段数(段)", size: "default", onBlur: (c) => J(s, "segmentQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onBlur"])]), _: 1 }), u(r, { align: "center", fixed: "right", label: "操作", width: "60px" }, { default: d(({ $index: s }) => [u(q, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => xe(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), u(i, { "label-width": "0", prop: "remark", style: { "margin-top": "10px" } }, { default: d(() => [u(N, { modelValue: a.value.remark, "onUpdate:modelValue": e[1] || (e[1] = (s) => a.value.remark = s), modelModifiers: { trim: true }, autosize: { minRows: 6, maxRows: 6 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])])])) : Q("", true)]), _: 1 }, 8, ["model", "rules"])) : Q("", true);
  };
} }, $t = Ae(qt, [["__scopeId", "data-v-f00a918b"]]);
export {
  $t as default
};
