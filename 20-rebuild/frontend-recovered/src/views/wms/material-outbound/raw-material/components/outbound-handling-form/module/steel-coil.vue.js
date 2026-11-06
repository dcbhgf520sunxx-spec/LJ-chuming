import { computed as V } from "vue";
import { ref as O } from "vue";
import { provide as Ne } from "vue";
import { watch as N } from "vue";
import { reactive as ze } from "vue";
import { watchEffect as We } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as Me } from "vue";
import { unref as v } from "vue";
import { openBlock as f } from "vue";
import { createBlock as Oe } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as u } from "vue";
import { createSlots as Te } from "vue";
import { createElementBlock as g } from "vue";
import { createCommentVNode as Q } from "vue";
import { normalizeClass as Z } from "vue";
import { toDisplayString as y } from "vue";
import { withDirectives as ee } from "vue";
import { Fragment as R } from "vue";
import { normalizeStyle as z } from "vue";
import { renderList as te } from "vue";
import { ElMessage as L } from "element-plus";
import { ElFormItem as Pe } from "element-plus";
import { ElDescriptionsItem as Fe } from "element-plus";
import { ElTableColumn as Re } from "element-plus";
import { ElInput as je } from "element-plus";
import { ElForm as Ae } from "element-plus";
import { _ as He, y1 as Ye, hW as De, c as Ke, sQ as Ge, bC as Xe, iX as j, i as C, y2 as le, qS as Je, y4 as Ze, aw as et, fK as ae, V as A, x_ as ie, jl as tt, b as lt, c9 as P } from "../../../../../../../shared/runtime.js";
import at from "../components/common-form-item.vue.js";
import it from "../components/common-material-info.vue.js";
import nt from "../components/descriptions-material-info.vue.js";
import { M as ne } from "../../../../../../../modules/index-330e9f5e.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const st = { style: { "min-width": "800px" } }, ot = { style: { display: "flex" } }, ut = { key: 0, class: "tip" }, rt = { key: 0, class: "material-info" }, dt = { key: 1, class: "form-info" }, mt = { key: 2, class: "plate-out-material-info" }, ct = { key: 0, class: "tip", style: { "margin-top": "10px" } }, pt = { style: { display: "flex", "margin-bottom": "15px", "margin-top": "15px" } }, ht = { class: "total-info" }, vt = { class: "total-item" }, ft = { class: "total-value" }, gt = { class: "total-item" }, yt = { class: "total-value" }, bt = { class: "total-item total-item-surplus" }, wt = { class: "total-value" }, _t = { class: "total-item total-item-surplus" }, xt = { class: "total-value" }, kt = { key: 0, style: { "margin-left": "30px" } }, qt = { class: "other-info" }, Vt = { style: { width: "530px" } }, Qt = { style: { "margin-bottom": "10px" } }, E = 260, Ct = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number } }, emits: ["confirmNext"], setup(F, { expose: se, emit: oe }) {
  const { steelMinLengthConfig: H } = Ye(), $ = { BY_LENGTH: { L: "按长度出库", K: "BY_LENGTH ", V: 1 }, BY_PLATE: { L: "按条板出库", K: "BY_PLATE", V: 2 } }, { mesWorkShopName: ue } = De(), re = oe, Y = V(() => {
    var t, e;
    return (t = H.value) != null && t.steelPlateShortestSideMinLength ? Ke((e = H.value) == null ? void 0 : e.steelPlateShortestSideMinLength, "mm", "m") : 0;
  }), W = F, I = O(), l = O({ list: [] }), { loaded: de, baseUnit: b } = Ge(W.basicClass);
  Xe(I, l, ["quantity"]);
  const o = V(() => W.material || {}), x = O([{}]), D = O([]), w = V(() => l.value.materialOutboundMode === $.BY_PLATE.V), me = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: (t, e, i) => {
    if (lt(e)) return i(new Error("请填写数量"));
    if (e <= 0) return i(new Error("数量必须大于0"));
    if (e > U.value) return i(new Error("数量不可超过可操作数量"));
    i();
  }, trigger: "blur" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, ce = { remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, pe = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: P, message: "宽度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: P, message: "数量必须大于0", trigger: "blur" }] }, K = { singleQuantity: [{ required: true, message: "请填写单段长度", trigger: "blur" }, { pattern: P, message: "单段长度必须大于0", trigger: "blur" }], segmentQuantity: [{ required: true, message: "请填写段数", trigger: "blur" }, { pattern: P, message: "段数必须大于0", trigger: "blur" }] }, { tableValidate: he, wrongCellMask: ve } = et({ rules: pe }), fe = V(() => w.value ? Object.assign({}, ce) : Object.assign({}, me)), U = V(() => !l.value || !l.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[l.value.projectId] || 0));
  Ne("maxQuantity", U);
  const ge = V(() => j(U.value - l.value.quantity, o.value.outboundUnitPrecision)), ye = V(() => {
    var t, e;
    return l.value.quantity === U.value ? 0 : j(o.value.operableMete - l.value.totalWeight, (e = (t = b.value) == null ? void 0 : t.weight) == null ? void 0 : e.precision);
  }), k = V(() => {
    let t = o.value.width, e = l.value.singleTotalWeight;
    return l.value.list.forEach((i) => {
      t -= i.width * (i.quantity || 1) || 0, e -= i.mete || 0;
    }), { width: t, mete: e > 0 ? e : 0 };
  }), B = V(() => {
    let t = 0;
    return l.value.list.forEach((e) => {
      t += e.quantity || 0;
    }), k.value.width > 0 && (t += 1), t;
  });
  N(o, (t) => {
    qe(t);
  }, { immediate: true }), N(() => w.value, (t) => {
    if (t) {
      const e = X();
      l.value.list = [], l.value.list.push(e);
    }
  }, { immediate: true }), N([() => l.value.singleQuantity, () => l.value.segmentQuantity], () => {
    w.value && (l.value.quantity = j(l.value.singleQuantity && l.value.segmentQuantity ? l.value.singleQuantity * l.value.segmentQuantity : 0, o.value.outboundUnitPrecision));
  }), N(x.value, (t) => {
    let e = 0;
    C(t) && t.forEach((i) => {
      i.singleQuantity && i.segmentQuantity && (e += i.singleQuantity * i.segmentQuantity);
    }), l.value.quantity = e, G();
  }, { immediate: true, deep: true });
  async function G() {
    const t = [], e = [];
    l.value.totalWeight = 0, C(l.value.list) && C(x.value) && l.value.list.forEach((i) => {
      x.value.forEach((a) => {
        for (let p = 0; p < a.segmentQuantity; p++) t.push({ ...i, quantity: i.quantity || 0, length: a.singleQuantity || 0 });
      });
    });
    for (let i = 0; i < t.length; i++) {
      const a = t[i];
      if (a.mete = 0, C(a.quantity) && C(a.length) && C(a.width)) {
        const p = await le({ classifyId: a.classifyId, name: a.name, length: a.length, width: a.width, thickness: a.thickness, quantity: a.quantity }).then((r) => {
          a.theoryWeight = r, a.mete = a.mete || a.theoryWeight;
        });
        p && e.push(p);
      }
    }
    await Promise.all(e), t.forEach((i) => {
      i.boolSurplus = false, i.boolOutbound = true, l.value.totalWeight += i.mete || 0;
    }), D.value = t;
  }
  function be() {
    l.value.quantity = void 0, l.value.materialOutboundMode === $.BY_PLATE.V && re("confirmNext", true);
  }
  function X() {
    const t = ze({ basicClass: W.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: void 0, quantity: void 0, outboundAddress: Je.FACTORY.V, overWidth: false, overLength: false });
    return we(t), t;
  }
  function we(t) {
    N([() => t], () => {
      G();
    }, { immediate: true, deep: true });
  }
  We(async () => {
  });
  function _e(t) {
    const e = X();
    l.value.list.splice(t + 1, 0, e);
  }
  function xe(t) {
    l.value.list.splice(t, 1);
  }
  function ke(t) {
    x.value.splice(t, 1);
  }
  function qe(t) {
    var i, a;
    const e = { materialOutboundMode: $.BY_LENGTH.V, materialId: t.id, monomerId: t == null ? void 0 : t.monomerId, areaId: t == null ? void 0 : t.areaId, workshopId: ((i = ue.value) == null ? void 0 : i.findIndex((p) => {
      var r;
      return p.id === ((r = t.workshop) == null ? void 0 : r.id);
    })) > -1 ? (a = t.workshop) == null ? void 0 : a.id : void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, projectId: t.project ? t.project.id : void 0, recipientId: void 0, list: [], remark: void 0 };
    l.value = e;
  }
  const Ve = V(() => Ze);
  function Qe() {
    x.value.push({});
  }
  function J(t, e) {
    let i = 0;
    x.value.forEach((a) => {
      a.singleQuantity && a.segmentQuantity && (i += a.singleQuantity * a.segmentQuantity);
    }), i > U.value && (t[e] = void 0, L({ message: "开平总长不能大于可出库长度", type: "error" }));
  }
  function Ce({ row: t, column: e }) {
    if (!t) return;
    const i = K;
    let a = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[e.property] === false && (a = ae(e.property, i[e.property], t)), a && (t.verify[e.property] = true)), a ? "" : "mask-td";
  }
  function Ee() {
    if (x.value.length <= 0) return L({ message: "请先填写单段长度配置", type: "error" }), false;
    const t = K;
    let e = true;
    return x.value.map((i) => {
      i.verify = {};
      for (const a in t) i.verify[a] = ae(a, t[a], i), i.verify[a] || (e = false);
    }), e ? true : (L.error("请填写表格中标红数据"), false);
  }
  async function Ue() {
    var S, M;
    if (!Ee() || !await I.value.validate()) return false;
    const i = A(l.value);
    if (await ie(i, { unit: i.outboundUnit, precision: i.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), l.value.quantity > U.value) return L.error("开平总长不可大于可出库长度"), false;
    let a = 0;
    if (l.value.list.forEach((_) => {
      a += _.width * _.quantity;
    }), a > o.value.width) throw L.error(`条板总宽：${a}mm，条板总宽不可大于开平宽度`), new Error("宽度超出允许值");
    if (((S = k.value) == null ? void 0 : S.width) < 0) throw L.error("余料错误"), new Error("余料错误");
    const { validResult: p } = he(l.value.list);
    if (!p) return false;
    let r = A(D.value);
    const h = [];
    if (((M = k.value) == null ? void 0 : M.width) > 0) for (let _ = 0; _ < x.value.length; _++) h.push({ basicClass: W.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: k.value.width, length: x.value[_].singleQuantity, quantity: x.value[_].segmentQuantity, boolSurplus: true, boolOutbound: false });
    const q = [];
    for (let _ = 0; _ < h.length; _++) {
      const m = h[_];
      if (m.mete = 0, C(m.quantity) && C(m.length) && C(m.width)) {
        const s = await le({ classifyId: m.classifyId, name: m.name, length: m.length, width: m.width, thickness: m.thickness, quantity: m.quantity }).then((c) => {
          m.theoryWeight = c, m.mete = m.mete || m.theoryWeight;
        });
        s && q.push(s);
      }
    }
    return await Promise.all(q), r = [...r, ...h], C(r) ? r : void 0;
  }
  async function Ie() {
    if (!await I.value.validate()) return false;
    const e = A(l.value);
    return await ie(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), w.value && (e.battenList = await tt(e.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] })), await Ve.value(e);
  }
  function Be() {
    I.value.resetFields();
  }
  function Le() {
    I.value && I.value.clearValidate();
  }
  function $e(t) {
    const { columns: e, data: i } = t, a = [];
    return e.forEach((p, r) => {
      if (r === 0) {
        a[r] = "余料";
        return;
      }
      if (p.property === "width") {
        let h = o.value.width;
        i.forEach((q) => {
          h -= q.width * (q.quantity || 1) || 0;
        }), a[r] = h;
      }
      if (p.property === "mete") {
        let h = l.value.singleTotalWeight;
        i.forEach((q) => {
          h -= q.mete || 0;
        }), a[r] = h > 0 ? h : 0;
      }
      p.property === "quantity" && (a[r] = 1);
    }), a;
  }
  return se({ submit: Ie, nextSubmit: Ue, resetForm: Be, clearValidate: Le, enlargeWth: V(() => w.value) }), (t, e) => {
    const i = T("common-radio"), a = Pe, p = Fe, r = Re, h = T("common-input-number"), q = T("common-button"), S = T("common-table"), M = je, _ = Ae, m = Me("empty");
    return v(de) ? (f(), Oe(_, { key: 0, ref_key: "formRef", ref: I, model: l.value, rules: fe.value, "label-position": "left", "label-width": "120px", size: "default", style: { display: "flex", overflow: "auto" } }, { default: d(() => [n("div", st, [u(a, { class: "material-outbound-mode-info", label: "出库方式" }, Te({ default: d(() => [n("div", ot, [u(i, { modelValue: l.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (s) => l.value.materialOutboundMode = s), options: $, unshowVal: [$.BY_PLATE.V], size: "default", type: "enum", onChange: be }, null, 8, ["modelValue", "unshowVal"]), w.value ? (f(), g("div", ut, e[3] || (e[3] = [n("span", null, "* 提示：", -1), n("span", null, " 出库至钢板库后，无法再进行退库操作，请谨慎操作", -1)]))) : Q("", true)])]), _: 2 }, [w.value ? { name: "label", fn: d(() => [e[2] || (e[2] = n("span", { class: "set-title" }, "出库方式", -1))]), key: "0" } : void 0]), 1024), n("div", { class: Z(w.value ? "plate-out-form" : "form") }, [w.value ? Q("", true) : (f(), g("div", rt, [u(it, { form: l.value, material: o.value }, { afterSpec: d(() => [u(a, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${o.value.thickness}${v(b).thickness.unit} * ${o.value.width}${v(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [u(a, { label: "炉批号/卷号" }, { default: d(() => [ee(n("span", null, null, 512), [[m, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])), w.value ? Q("", true) : (f(), g("div", dt, [u(at, { form: l.value, material: o.value }, null, 8, ["form", "material"])])), w.value ? (f(), g("div", mt, [u(v(nt), { form: l.value, material: o.value }, { afterSpec: d(() => [u(p, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${o.value.thickness}${v(b).thickness.unit} * ${o.value.width}${v(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [u(p, { label: "炉批号" }, { default: d(() => [ee(n("span", null, null, 512), [[m, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])) : Q("", true), w.value ? (f(), g(R, { key: 3 }, [e[11] || (e[11] = n("div", { class: "divider" }, null, -1)), e[12] || (e[12] = n("span", { class: "set-title" }, "单段配置", -1)), u(S, { "cell-class-name": v(ve), data: l.value.list, "max-height": F.maxHeight, "show-empty-symbol": false, "summary-method": $e, "return-source-data": "", "show-summary": "", style: { width: "100%", "margin-top": "15px" } }, { default: d(() => [u(r, { align: "center", label: "序号", type: "index", width: "60" }), u(r, { label: `宽 (${v(b).width.unit})`, align: "center", prop: "width" }, { default: d(({ row: s }) => [u(h, { modelValue: s.width, "onUpdate:modelValue": (c) => s.width = c, class: Z({ "over-weight-tip": s.overWidth }), controls: false, max: 999999999, min: Y.value, precision: v(b).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "min", "precision"])]), _: 1 }, 8, ["label"]), u(r, { align: "center", label: "数量 (张)", prop: "quantity" }, { default: d(({ row: s }) => [u(h, { modelValue: s.quantity, "onUpdate:modelValue": (c) => s.quantity = c, controls: false, max: 999999999, min: 1, precision: v(b).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), u(r, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: d(({ $index: s }) => [u(q, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => xe(s) }, null, 8, ["onClick"]), u(q, { class: "icon-button", icon: "el-icon-plus", size: "default", type: "success", onClick: (c) => _e(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]), k.value.width < 0 ? (f(), g("div", ct, e[4] || (e[4] = [n("span", null, "* 错误提示：", -1), n("span", null, " 条板总宽不可大于开平宽度", -1)]))) : Q("", true), n("div", null, [e[10] || (e[10] = n("span", { class: "set-title", style: { "margin-top": "10px" } }, "单段开平预览（横向）", -1)), n("div", pt, [n("div", { style: z(`height:${E}px;`), class: "preview-info" }, [k.value.width && B.value > 1 || !k.value.width && B.value ? (f(), g("div", { key: 0, style: z(`height:${E}px;overflow:hidden;`) }, [(f(true), g(R, null, te(l.value.list, (s, c) => (f(), g("div", { key: c }, [s.quantity && s.width ? (f(true), g(R, { key: 0 }, te(s.quantity, (Se) => (f(), g("div", { key: Se, style: z({ marginBottom: c === l.value.list.length - 1 && !k.value.width ? "0px" : "1px", height: (E - (B.value - 1)) * s.width / o.value.width + "px", lineHeight: (E - (B.value - 1)) * s.width / o.value.width + "px" }), class: "plate-item" }, y(s.width) + y(v(b).width.unit), 5))), 128)) : Q("", true)]))), 128)), k.value.width ? (f(), g("div", { key: 0, style: z({ backgroundColor: "#c45656", height: (E - (B.value - 1)) * k.value.width / o.value.width + "px", lineHeight: (E - (B.value - 1)) * k.value.width / o.value.width + "px" }), class: "plate-item" }, y(k.value.width) + y(v(b).width.unit), 5)) : Q("", true)], 4)) : (f(), g("div", { key: 1, style: z(`height:${E}px;line-height:${E}px;text-align:center;color: #9e9ea1;border: 1px solid;`) }, e[5] || (e[5] = [n("span", null, "请配置单段配置！", -1)]), 4)), u(ne, { customStyle: `height:${E}px;right:-12px;top:0px;`, sizeInfo: `${o.value.width}${v(b).width.unit}`, direction: "vertical" }, null, 8, ["customStyle", "sizeInfo"]), u(ne, { customStyle: "width:100%;bottom:-30px;left:0px;", sizeInfo: `${l.value.singleQuantity || 0}${o.value.outboundUnit}`, direction: "horizontal" }, null, 8, ["sizeInfo"])], 4), n("div", ht, [n("div", vt, [e[6] || (e[6] = n("span", { class: "total-label" }, "开平总长", -1)), n("span", ft, y(l.value.quantity || 0) + " " + y(o.value.outboundUnit), 1)]), n("div", gt, [e[7] || (e[7] = n("span", { class: "total-label" }, "开平总重", -1)), n("span", yt, y(l.value.totalWeight || 0) + " " + y(v(b).weight.unit), 1)]), n("div", bt, [e[8] || (e[8] = n("span", { class: "total-label" }, "剩余长度", -1)), n("span", wt, y(ge.value || 0) + " " + y(o.value.outboundUnit), 1)]), n("div", _t, [e[9] || (e[9] = n("span", { class: "total-label" }, "剩余重量", -1)), n("span", xt, y(ye.value || 0) + " " + y(v(b).weight.unit), 1)])])])])], 64)) : Q("", true)], 2)]), w.value ? (f(), g("div", kt, [n("div", qt, [n("div", Vt, [n("div", Qt, [e[13] || (e[13] = n("span", { class: "set-title" }, "单段长度配置", -1)), u(q, { class: "icon-button", icon: "el-icon-plus", size: "default", style: { float: "right" }, type: "success", onClick: Qe })]), u(S, { "cell-class-name": Ce, data: x.value, "max-height": F.maxHeight, "show-empty-symbol": false, "return-source-data": "" }, { default: d(() => [u(r, { align: "center", label: "序号", type: "index", width: "55" }), u(r, { label: `单段长度(${o.value.outboundUnit})`, align: "center", "min-width": "120", prop: "singleQuantity" }, { default: d(({ row: s }) => [u(h, { modelValue: s.singleQuantity, "onUpdate:modelValue": (c) => s.singleQuantity = c, controls: false, max: U.value, min: Y.value, precision: o.value.outboundUnitPrecision, "controls-position": "right", placeholder: "单段长度", size: "default", onBlur: (c) => J(s, "singleQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), u(r, { label: "段数(段)", align: "center", "min-width": "120", prop: "segmentQuantity" }, { default: d(({ row: s }) => [u(h, { modelValue: s.segmentQuantity, "onUpdate:modelValue": (c) => s.segmentQuantity = c, controls: false, max: s.singleQuantity ? parseInt(U.value / s.singleQuantity) : 1, min: 0, precision: 0, "controls-position": "right", placeholder: "段数(段)", size: "default", onBlur: (c) => J(s, "segmentQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onBlur"])]), _: 1 }), u(r, { align: "center", fixed: "right", label: "操作", width: "60px" }, { default: d(({ $index: s }) => [u(q, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => ke(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), u(a, { "label-width": "0", prop: "remark", style: { "margin-top": "10px" } }, { default: d(() => [u(M, { modelValue: l.value.remark, "onUpdate:modelValue": e[1] || (e[1] = (s) => l.value.remark = s), modelModifiers: { trim: true }, autosize: { minRows: 6, maxRows: 6 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])])])) : Q("", true)]), _: 1 }, 8, ["model", "rules"])) : Q("", true);
  };
} }, zt = He(Ct, [["__scopeId", "data-v-7de93d46"]]);
export {
  zt as default
};
