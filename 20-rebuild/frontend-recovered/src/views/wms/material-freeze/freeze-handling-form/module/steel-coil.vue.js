import { computed as q } from "vue";
import { ref as F } from "vue";
import { provide as Se } from "vue";
import { watch as z } from "vue";
import { reactive as ze } from "vue";
import { watchEffect as Me } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as Ne } from "vue";
import { unref as f } from "vue";
import { openBlock as h } from "vue";
import { createBlock as Te } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as u } from "vue";
import { createSlots as Fe } from "vue";
import { createElementBlock as g } from "vue";
import { createCommentVNode as Q } from "vue";
import { normalizeClass as Z } from "vue";
import { toDisplayString as y } from "vue";
import { withDirectives as ee } from "vue";
import { Fragment as R } from "vue";
import { normalizeStyle as M } from "vue";
import { renderList as te } from "vue";
import { ElMessage as I } from "element-plus";
import { ElFormItem as Oe } from "element-plus";
import { ElDescriptionsItem as Pe } from "element-plus";
import { ElTableColumn as We } from "element-plus";
import { ElInput as Re } from "element-plus";
import { ElForm as je } from "element-plus";
import { f as Ae } from "../../../../../modules/freeze-handling-a93ff3c0.js";
import { _ as He, y1 as Ye, c as De, sQ as Ke, bC as Ge, iX as j, i as C, y2 as le, qS as Xe, aw as Je, fK as ae, V as A, x_ as ie, jl as Ze, b as et, c9 as P } from "../../../../../shared/runtime.js";
import tt from "../components/common-form-item.vue.js";
import lt from "../components/common-material-info.vue.js";
import at from "../components/descriptions-material-info.vue.js";
import { M as ne } from "../../../../../modules/index-330e9f5e.js";
const it = { style: { "min-width": "800px" } }, nt = { style: { display: "flex" } }, st = { key: 0, class: "tip" }, ot = { key: 0, class: "material-info" }, ut = { key: 1, class: "form-info" }, rt = { key: 2, class: "plate-out-material-info" }, dt = { key: 0, class: "tip", style: { "margin-top": "10px" } }, mt = { style: { display: "flex", "margin-bottom": "15px", "margin-top": "15px" } }, ct = { class: "total-info" }, pt = { class: "total-item" }, ft = { class: "total-value" }, ht = { class: "total-item" }, vt = { class: "total-value" }, gt = { class: "total-item total-item-surplus" }, yt = { class: "total-value" }, bt = { class: "total-item total-item-surplus" }, _t = { class: "total-value" }, wt = { key: 0, style: { "margin-left": "30px" } }, xt = { class: "other-info" }, kt = { style: { width: "530px" } }, Vt = { style: { "margin-bottom": "10px" } }, E = 260, qt = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number } }, emits: ["confirmNext"], setup(W, { expose: se, emit: oe }) {
  const { steelMinLengthConfig: H } = Ye(), $ = { BY_LENGTH: { L: "按长度出库", K: "BY_LENGTH ", V: 1 }, BY_PLATE: { L: "按条板出库", K: "BY_PLATE", V: 2 } }, ue = oe, Y = q(() => {
    var t, e;
    return (t = H.value) != null && t.steelPlateShortestSideMinLength ? De((e = H.value) == null ? void 0 : e.steelPlateShortestSideMinLength, "mm", "m") : 0;
  }), N = W, B = F(), l = F({ list: [] }), { loaded: re, baseUnit: b } = Ke(N.basicClass);
  Ge(B, l, ["quantity"]);
  const o = q(() => N.material || {}), x = F([{}]), D = F([]), _ = q(() => l.value.materialOutboundMode === $.BY_PLATE.V), de = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: (t, e, a) => {
    if (et(e)) return a(new Error("请填写数量"));
    if (e <= 0) return a(new Error("数量必须大于0"));
    if (e > U.value) return a(new Error("数量不可超过可操作数量"));
    a();
  }, trigger: "blur" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, me = { remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, ce = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: P, message: "宽度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: P, message: "数量必须大于0", trigger: "blur" }] }, K = { singleQuantity: [{ required: true, message: "请填写单段长度", trigger: "blur" }, { pattern: P, message: "单段长度必须大于0", trigger: "blur" }], segmentQuantity: [{ required: true, message: "请填写段数", trigger: "blur" }, { pattern: P, message: "段数必须大于0", trigger: "blur" }] }, { tableValidate: pe, wrongCellMask: fe } = Je({ rules: ce }), he = q(() => _.value ? Object.assign({}, me) : Object.assign({}, de)), U = q(() => !l.value || !l.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[l.value.projectId] || 0));
  Se("maxQuantity", U);
  const ve = q(() => j(U.value - l.value.quantity, o.value.outboundUnitPrecision)), ge = q(() => {
    var t, e;
    return l.value.quantity === U.value ? 0 : j(o.value.operableMete - l.value.totalWeight, (e = (t = b.value) == null ? void 0 : t.weight) == null ? void 0 : e.precision);
  }), k = q(() => {
    let t = o.value.width, e = l.value.singleTotalWeight;
    return l.value.list.forEach((a) => {
      t -= a.width * (a.quantity || 1) || 0, e -= a.mete || 0;
    }), { width: t, mete: e > 0 ? e : 0 };
  }), L = q(() => {
    let t = 0;
    return l.value.list.forEach((e) => {
      t += e.quantity || 0;
    }), k.value.width > 0 && (t += 1), t;
  });
  z(o, (t) => {
    ke(t);
  }, { immediate: true }), z(() => _.value, (t) => {
    if (t) {
      const e = X();
      l.value.list = [], l.value.list.push(e);
    }
  }, { immediate: true }), z([() => l.value.singleQuantity, () => l.value.segmentQuantity], () => {
    _.value && (l.value.quantity = j(l.value.singleQuantity && l.value.segmentQuantity ? l.value.singleQuantity * l.value.segmentQuantity : 0, o.value.outboundUnitPrecision));
  }), z(x.value, (t) => {
    let e = 0;
    C(t) && t.forEach((a) => {
      a.singleQuantity && a.segmentQuantity && (e += a.singleQuantity * a.segmentQuantity);
    }), l.value.quantity = e, G();
  }, { immediate: true, deep: true });
  async function G() {
    const t = [], e = [];
    l.value.totalWeight = 0, C(l.value.list) && C(x.value) && l.value.list.forEach((a) => {
      x.value.forEach((i) => {
        for (let v = 0; v < i.segmentQuantity; v++) t.push({ ...a, quantity: a.quantity || 0, length: i.singleQuantity || 0 });
      });
    });
    for (let a = 0; a < t.length; a++) {
      const i = t[a];
      if (i.mete = 0, C(i.quantity) && C(i.length) && C(i.width)) {
        const v = await le({ classifyId: i.classifyId, name: i.name, length: i.length, width: i.width, thickness: i.thickness, quantity: i.quantity }).then((r) => {
          i.theoryWeight = r, i.mete = i.mete || i.theoryWeight;
        });
        v && e.push(v);
      }
    }
    await Promise.all(e), t.forEach((a) => {
      a.boolSurplus = false, a.boolOutbound = true, l.value.totalWeight += a.mete || 0;
    }), D.value = t;
  }
  function ye() {
    l.value.quantity = void 0, l.value.materialOutboundMode === $.BY_PLATE.V && ue("confirmNext", true);
  }
  function X() {
    const t = ze({ basicClass: N.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: void 0, quantity: void 0, outboundAddress: Xe.FACTORY.V, overWidth: false, overLength: false });
    return be(t), t;
  }
  function be(t) {
    z([() => t], () => {
      G();
    }, { immediate: true, deep: true });
  }
  Me(async () => {
  });
  function _e(t) {
    const e = X();
    l.value.list.splice(t + 1, 0, e);
  }
  function we(t) {
    l.value.list.splice(t, 1);
  }
  function xe(t) {
    x.value.splice(t, 1);
  }
  function ke(t) {
    var a;
    const e = { materialOutboundMode: $.BY_LENGTH.V, materialId: t.id, monomerId: t == null ? void 0 : t.monomerId, areaId: t == null ? void 0 : t.areaId, factoryId: (a = t.factory) == null ? void 0 : a.id, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, projectId: t.project ? t.project.id : void 0, recipientId: void 0, list: [], remark: void 0 };
    l.value = e;
  }
  const Ve = q(() => Ae);
  function qe() {
    x.value.push({});
  }
  function J(t, e) {
    let a = 0;
    x.value.forEach((i) => {
      i.singleQuantity && i.segmentQuantity && (a += i.singleQuantity * i.segmentQuantity);
    }), a > U.value && (t[e] = void 0, I({ message: "开平总长不能大于可出库长度", type: "error" }));
  }
  function Qe({ row: t, column: e }) {
    if (!t) return;
    const a = K;
    let i = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[e.property] === false && (i = ae(e.property, a[e.property], t)), i && (t.verify[e.property] = true)), i ? "" : "mask-td";
  }
  function Ce() {
    if (x.value.length <= 0) return I({ message: "请先填写单段长度配置", type: "error" }), false;
    const t = K;
    let e = true;
    return x.value.map((a) => {
      a.verify = {};
      for (const i in t) a.verify[i] = ae(i, t[i], a), a.verify[i] || (e = false);
    }), e ? true : (I.error("请填写表格中标红数据"), false);
  }
  async function Ee() {
    var S, T;
    if (!Ce() || !await B.value.validate()) return false;
    const a = A(l.value);
    if (await ie(a, { unit: a.outboundUnit, precision: a.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), l.value.quantity > U.value) return I.error("开平总长不可大于可出库长度"), false;
    let i = 0;
    if (l.value.list.forEach((w) => {
      i += w.width * w.quantity;
    }), i > o.value.width) throw I.error(`条板总宽：${i}mm，条板总宽不可大于开平宽度`), new Error("宽度超出允许值");
    if (((S = k.value) == null ? void 0 : S.width) < 0) throw I.error("余料错误"), new Error("余料错误");
    const { validResult: v } = pe(l.value.list);
    if (!v) return false;
    let r = A(D.value);
    const p = [];
    if (((T = k.value) == null ? void 0 : T.width) > 0) for (let w = 0; w < x.value.length; w++) p.push({ basicClass: N.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: k.value.width, length: x.value[w].singleQuantity, quantity: x.value[w].segmentQuantity, boolSurplus: true, boolOutbound: false });
    const V = [];
    for (let w = 0; w < p.length; w++) {
      const m = p[w];
      if (m.mete = 0, C(m.quantity) && C(m.length) && C(m.width)) {
        const s = await le({ classifyId: m.classifyId, name: m.name, length: m.length, width: m.width, thickness: m.thickness, quantity: m.quantity }).then((c) => {
          m.theoryWeight = c, m.mete = m.mete || m.theoryWeight;
        });
        s && V.push(s);
      }
    }
    return await Promise.all(V), r = [...r, ...p], C(r) ? r : void 0;
  }
  async function Ue() {
    if (!await B.value.validate()) return false;
    const e = A(l.value);
    return await ie(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), _.value && (e.battenList = await Ze(e.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] })), await Ve.value(e);
  }
  function Be() {
    B.value.resetFields();
  }
  function Le() {
    B.value && B.value.clearValidate();
  }
  function Ie(t) {
    const { columns: e, data: a } = t, i = [];
    return e.forEach((v, r) => {
      if (r === 0) {
        i[r] = "余料";
        return;
      }
      if (v.property === "width") {
        let p = o.value.width;
        a.forEach((V) => {
          p -= V.width * (V.quantity || 1) || 0;
        }), i[r] = p;
      }
      if (v.property === "mete") {
        let p = l.value.singleTotalWeight;
        a.forEach((V) => {
          p -= V.mete || 0;
        }), i[r] = p > 0 ? p : 0;
      }
      v.property === "quantity" && (i[r] = 1);
    }), i;
  }
  return se({ submit: Ue, nextSubmit: Ee, resetForm: Be, clearValidate: Le, enlargeWth: q(() => _.value) }), (t, e) => {
    const a = O("common-radio"), i = Oe, v = Pe, r = We, p = O("common-input-number"), V = O("common-button"), S = O("common-table"), T = Re, w = je, m = Ne("empty");
    return f(re) ? (h(), Te(w, { key: 0, ref_key: "formRef", ref: B, model: l.value, rules: he.value, "label-position": "left", "label-width": "120px", size: "default", style: { display: "flex", overflow: "auto" } }, { default: d(() => [n("div", it, [u(i, { class: "material-outbound-mode-info", label: "出库方式" }, Fe({ default: d(() => [n("div", nt, [u(a, { modelValue: l.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (s) => l.value.materialOutboundMode = s), options: $, unshowVal: [$.BY_PLATE.V], size: "default", type: "enum", onChange: ye }, null, 8, ["modelValue", "unshowVal"]), _.value ? (h(), g("div", st, e[3] || (e[3] = [n("span", null, "* 提示：", -1), n("span", null, " 出库至钢板库后，无法再进行退库操作，请谨慎操作", -1)]))) : Q("", true)])]), _: 2 }, [_.value ? { name: "label", fn: d(() => [e[2] || (e[2] = n("span", { class: "set-title" }, "出库方式", -1))]), key: "0" } : void 0]), 1024), n("div", { class: Z(_.value ? "plate-out-form" : "form") }, [_.value ? Q("", true) : (h(), g("div", ot, [u(lt, { form: l.value, material: o.value }, { afterSpec: d(() => [u(i, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${o.value.thickness}${f(b).thickness.unit} * ${o.value.width}${f(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [u(i, { label: "炉批号/卷号" }, { default: d(() => [ee(n("span", null, null, 512), [[m, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])), _.value ? Q("", true) : (h(), g("div", ut, [u(tt, { form: l.value, material: o.value }, null, 8, ["form", "material"])])), _.value ? (h(), g("div", rt, [u(f(at), { form: l.value, material: o.value }, { afterSpec: d(() => [u(v, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${o.value.thickness}${f(b).thickness.unit} * ${o.value.width}${f(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [u(v, { label: "炉批号" }, { default: d(() => [ee(n("span", null, null, 512), [[m, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])) : Q("", true), _.value ? (h(), g(R, { key: 3 }, [e[11] || (e[11] = n("div", { class: "divider" }, null, -1)), e[12] || (e[12] = n("span", { class: "set-title" }, "单段配置", -1)), u(S, { "cell-class-name": f(fe), data: l.value.list, "max-height": W.maxHeight, "show-empty-symbol": false, "summary-method": Ie, "return-source-data": "", "show-summary": "", style: { width: "100%", "margin-top": "15px" } }, { default: d(() => [u(r, { align: "center", label: "序号", type: "index", width: "60" }), u(r, { label: `宽 (${f(b).width.unit})`, align: "center", prop: "width" }, { default: d(({ row: s }) => [u(p, { modelValue: s.width, "onUpdate:modelValue": (c) => s.width = c, class: Z({ "over-weight-tip": s.overWidth }), controls: false, max: 999999999, min: Y.value, precision: f(b).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "min", "precision"])]), _: 1 }, 8, ["label"]), u(r, { align: "center", label: "数量 (张)", prop: "quantity" }, { default: d(({ row: s }) => [u(p, { modelValue: s.quantity, "onUpdate:modelValue": (c) => s.quantity = c, controls: false, max: 999999999, min: 1, precision: f(b).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), u(r, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: d(({ $index: s }) => [u(V, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => we(s) }, null, 8, ["onClick"]), u(V, { class: "icon-button", icon: "el-icon-plus", size: "default", type: "success", onClick: (c) => _e(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]), k.value.width < 0 ? (h(), g("div", dt, e[4] || (e[4] = [n("span", null, "* 错误提示：", -1), n("span", null, " 条板总宽不可大于开平宽度", -1)]))) : Q("", true), n("div", null, [e[10] || (e[10] = n("span", { class: "set-title", style: { "margin-top": "10px" } }, "单段开平预览（横向）", -1)), n("div", mt, [n("div", { style: M(`height:${E}px;`), class: "preview-info" }, [k.value.width && L.value > 1 || !k.value.width && L.value ? (h(), g("div", { key: 0, style: M(`height:${E}px;overflow:hidden;`) }, [(h(true), g(R, null, te(l.value.list, (s, c) => (h(), g("div", { key: c }, [s.quantity && s.width ? (h(true), g(R, { key: 0 }, te(s.quantity, ($e) => (h(), g("div", { key: $e, style: M({ marginBottom: c === l.value.list.length - 1 && !k.value.width ? "0px" : "1px", height: (E - (L.value - 1)) * s.width / o.value.width + "px", lineHeight: (E - (L.value - 1)) * s.width / o.value.width + "px" }), class: "plate-item" }, y(s.width) + y(f(b).width.unit), 5))), 128)) : Q("", true)]))), 128)), k.value.width ? (h(), g("div", { key: 0, style: M({ backgroundColor: "#c45656", height: (E - (L.value - 1)) * k.value.width / o.value.width + "px", lineHeight: (E - (L.value - 1)) * k.value.width / o.value.width + "px" }), class: "plate-item" }, y(k.value.width) + y(f(b).width.unit), 5)) : Q("", true)], 4)) : (h(), g("div", { key: 1, style: M(`height:${E}px;line-height:${E}px;text-align:center;color: #9e9ea1;border: 1px solid;`) }, e[5] || (e[5] = [n("span", null, "请配置单段配置！", -1)]), 4)), u(ne, { customStyle: `height:${E}px;right:-12px;top:0px;`, sizeInfo: `${o.value.width}${f(b).width.unit}`, direction: "vertical" }, null, 8, ["customStyle", "sizeInfo"]), u(ne, { customStyle: "width:100%;bottom:-30px;left:0px;", sizeInfo: `${l.value.singleQuantity || 0}${o.value.outboundUnit}`, direction: "horizontal" }, null, 8, ["sizeInfo"])], 4), n("div", ct, [n("div", pt, [e[6] || (e[6] = n("span", { class: "total-label" }, "开平总长", -1)), n("span", ft, y(l.value.quantity || 0) + " " + y(o.value.outboundUnit), 1)]), n("div", ht, [e[7] || (e[7] = n("span", { class: "total-label" }, "开平总重", -1)), n("span", vt, y(l.value.totalWeight || 0) + " " + y(f(b).weight.unit), 1)]), n("div", gt, [e[8] || (e[8] = n("span", { class: "total-label" }, "剩余长度", -1)), n("span", yt, y(ve.value || 0) + " " + y(o.value.outboundUnit), 1)]), n("div", bt, [e[9] || (e[9] = n("span", { class: "total-label" }, "剩余重量", -1)), n("span", _t, y(ge.value || 0) + " " + y(f(b).weight.unit), 1)])])])])], 64)) : Q("", true)], 2)]), _.value ? (h(), g("div", wt, [n("div", xt, [n("div", kt, [n("div", Vt, [e[13] || (e[13] = n("span", { class: "set-title" }, "单段长度配置", -1)), u(V, { class: "icon-button", icon: "el-icon-plus", size: "default", style: { float: "right" }, type: "success", onClick: qe })]), u(S, { "cell-class-name": Qe, data: x.value, "max-height": W.maxHeight, "show-empty-symbol": false, "return-source-data": "" }, { default: d(() => [u(r, { align: "center", label: "序号", type: "index", width: "55" }), u(r, { label: `单段长度(${o.value.outboundUnit})`, align: "center", "min-width": "120", prop: "singleQuantity" }, { default: d(({ row: s }) => [u(p, { modelValue: s.singleQuantity, "onUpdate:modelValue": (c) => s.singleQuantity = c, controls: false, max: U.value, min: Y.value, precision: o.value.outboundUnitPrecision, "controls-position": "right", placeholder: "单段长度", size: "default", onBlur: (c) => J(s, "singleQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), u(r, { label: "段数(段)", align: "center", "min-width": "120", prop: "segmentQuantity" }, { default: d(({ row: s }) => [u(p, { modelValue: s.segmentQuantity, "onUpdate:modelValue": (c) => s.segmentQuantity = c, controls: false, max: s.singleQuantity ? parseInt(U.value / s.singleQuantity) : 1, min: 0, precision: 0, "controls-position": "right", placeholder: "段数(段)", size: "default", onBlur: (c) => J(s, "segmentQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onBlur"])]), _: 1 }), u(r, { align: "center", fixed: "right", label: "操作", width: "60px" }, { default: d(({ $index: s }) => [u(V, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => xe(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), u(i, { "label-width": "0", prop: "remark", style: { "margin-top": "10px" } }, { default: d(() => [u(T, { modelValue: l.value.remark, "onUpdate:modelValue": e[1] || (e[1] = (s) => l.value.remark = s), modelModifiers: { trim: true }, autosize: { minRows: 6, maxRows: 6 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])])])) : Q("", true)]), _: 1 }, 8, ["model", "rules"])) : Q("", true);
  };
} }, St = He(qt, [["__scopeId", "data-v-79aa3fbf"]]);
export {
  St as default
};
