import { computed as q } from "vue";
import { ref as P } from "vue";
import { provide as Pe } from "vue";
import { watch as M } from "vue";
import { reactive as ze } from "vue";
import { watchEffect as Re } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as We } from "vue";
import { unref as h } from "vue";
import { openBlock as v } from "vue";
import { createBlock as je } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as o } from "vue";
import { createSlots as Ye } from "vue";
import { createElementBlock as g } from "vue";
import { createCommentVNode as Q } from "vue";
import { normalizeClass as te } from "vue";
import { toDisplayString as y } from "vue";
import { withDirectives as ae } from "vue";
import { Fragment as Y } from "vue";
import { normalizeStyle as $ } from "vue";
import { renderList as le } from "vue";
import { ElMessage as I } from "element-plus";
import { ElMessageBox as Fe } from "element-plus";
import { ElFormItem as Ae } from "element-plus";
import { ElDescriptionsItem as He } from "element-plus";
import { ElTableColumn as De } from "element-plus";
import { ElInput as Ge } from "element-plus";
import { ElForm as Ke } from "element-plus";
import { _ as Xe, y1 as Je, gG as F, c as ie, sQ as Ze, bC as et, jY as tt, iX as R, i as U, y2 as ne, qS as at, zL as lt, zN as it, aw as nt, fK as se, V as A, x_ as ue, jl as st, y4 as ut, b as oe, c9 as W } from "../../../../../../../../../shared/runtime.js";
import ot from "../components/common-material-info.vue.js";
import rt from "../components/descriptions-material-info.vue.js";
import { M as re } from "../../../../../../../../../modules/index-330e9f5e.js";
const dt = { style: { "min-width": "800px" } }, mt = { style: { display: "flex" } }, ct = { key: 0, class: "tip" }, pt = { key: 0, class: "material-info" }, ft = { key: 1, class: "form-info" }, ht = { key: 2, class: "plate-out-material-info" }, vt = { key: 0, class: "tip", style: { "margin-top": "10px" } }, gt = { style: { display: "flex", "margin-bottom": "15px", "margin-top": "15px" } }, yt = { class: "total-info" }, bt = { class: "total-item" }, _t = { class: "total-value" }, wt = { class: "total-item" }, xt = { class: "total-value" }, Et = { class: "total-item total-item-surplus" }, Vt = { class: "total-value" }, qt = { class: "total-item total-item-surplus" }, kt = { class: "total-value" }, Ct = { key: 0, style: { "margin-left": "30px" } }, Qt = { class: "other-info" }, Ut = { style: { width: "530px" } }, Bt = { style: { "margin-bottom": "10px" } }, B = 260, Tt = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number } }, emits: ["confirmNext"], setup(j, { expose: de, emit: me }) {
  const { steelMinLengthConfig: H } = Je(), k = { BY_LENGTH: { L: "按长度出库", K: "BY_LENGTH ", V: 1 }, BY_PLATE: { L: "按条板出库", K: "BY_PLATE", V: 2 }, BY_WEIGHT: { L: "按重量出库", K: "BY_WEIGHT", V: 4 } }, ce = me, pe = q(() => a.value.outboundTypeSelection === F.PRODUCE.V ? [k.BY_PLATE.V] : [k.BY_PLATE.V, k.BY_WEIGHT.V]), D = q(() => {
    var t, e;
    return (t = H.value) != null && t.steelPlateShortestSideMinLength ? ie((e = H.value) == null ? void 0 : e.steelPlateShortestSideMinLength, "mm", "m") : 0;
  }), C = j, L = P(), a = P({ list: [] }), { loaded: fe, baseUnit: b } = Ze(C.basicClass);
  et(L, a, ["quantity"]);
  const u = q(() => C.material || {}), x = P([{}]), G = P([]), _ = q(() => a.value.materialOutboundMode === k.BY_PLATE.V), he = (t, e, i) => {
    if (oe(e)) return i(new Error("请填写数量"));
    if (e <= 0) return i(new Error("数量必须大于0"));
    if (e > T.value) return i(new Error("数量不可超过可操作数量"));
    i();
  }, ve = (t, e, i) => {
    var l;
    if (oe(e)) return i(new Error("请填写核算量"));
    if (e <= 0) return i(new Error("必须大于0"));
    if (e > ((l = C.material) == null ? void 0 : l.operableMete)) return i(new Error("不可超过可操作核算量"));
    i();
  }, { outboundCfg: ge } = tt(), K = q(() => {
    let t = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: he, trigger: "blur" }], outboundMete: [{ required: true, validator: ve, trigger: "blur" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return ge.value.productionOutBoundUserIsRequired && (t = Object.assign(t, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), a.value.outboundTypeSelection !== F.CONSTRUCTION_SITE_USE.V && (t = Object.assign(t, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), t;
  }), ye = { remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, be = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: W, message: "宽度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: W, message: "数量必须大于0", trigger: "blur" }] }, X = { singleQuantity: [{ required: true, message: "请填写单段长度", trigger: "blur" }, { pattern: W, message: "单段长度必须大于0", trigger: "blur" }], segmentQuantity: [{ required: true, message: "请填写段数", trigger: "blur" }, { pattern: W, message: "段数必须大于0", trigger: "blur" }] }, { tableValidate: _e, wrongCellMask: we } = nt({ rules: be });
  q(() => _.value ? Object.assign({}, ye) : Object.assign({}, K));
  const T = q(() => !a.value || !a.value.projectId || !u.value.projectFrozenForUnitKV ? u.value.corOperableQuantity : u.value.corOperableQuantity + (u.value.projectFrozenForUnitKV[a.value.projectId] || 0));
  Pe("maxQuantity", T);
  const xe = q(() => R(T.value - a.value.quantity, u.value.outboundUnitPrecision)), Ee = q(() => {
    var t, e;
    return a.value.quantity === T.value ? 0 : R(u.value.operableMete - a.value.totalWeight, (e = (t = b.value) == null ? void 0 : t.weight) == null ? void 0 : e.precision);
  }), E = q(() => {
    let t = u.value.width, e = a.value.singleTotalWeight;
    return a.value.list.forEach((i) => {
      t -= i.width * (i.quantity || 1) || 0, e -= i.mete || 0;
    }), { width: t, mete: e > 0 ? e : 0 };
  }), S = q(() => {
    let t = 0;
    return a.value.list.forEach((e) => {
      t += e.quantity || 0;
    }), E.value.width > 0 && (t += 1), t;
  });
  M(u, (t) => {
    Ue(t);
  }, { immediate: true }), M(() => _.value, (t) => {
    if (t) {
      const e = Z();
      a.value.list = [], a.value.list.push(e);
    }
  }, { immediate: true }), M([() => a.value.singleQuantity, () => a.value.segmentQuantity], () => {
    _.value && (a.value.quantity = R(a.value.singleQuantity && a.value.segmentQuantity ? a.value.singleQuantity * a.value.segmentQuantity : 0, u.value.outboundUnitPrecision));
  }), M(x.value, (t) => {
    let e = 0;
    U(t) && t.forEach((i) => {
      i.singleQuantity && i.segmentQuantity && (e += i.singleQuantity * i.segmentQuantity);
    }), a.value.quantity = e, J();
  }, { immediate: true, deep: true });
  async function J() {
    const t = [], e = [];
    a.value.totalWeight = 0, U(a.value.list) && U(x.value) && a.value.list.forEach((i) => {
      x.value.forEach((l) => {
        for (let p = 0; p < l.segmentQuantity; p++) t.push({ ...i, quantity: i.quantity || 0, length: l.singleQuantity || 0 });
      });
    });
    for (let i = 0; i < t.length; i++) {
      const l = t[i];
      if (l.mete = 0, U(l.quantity) && U(l.length) && U(l.width)) {
        const p = await ne({ classifyId: l.classifyId, name: l.name, length: l.length, width: l.width, thickness: l.thickness, quantity: l.quantity }).then((r) => {
          l.theoryWeight = r, l.mete = l.mete || l.theoryWeight;
        });
        p && e.push(p);
      }
    }
    await Promise.all(e), t.forEach((i) => {
      i.boolSurplus = false, i.boolOutbound = true, a.value.totalWeight += i.mete || 0;
    }), G.value = t;
  }
  function Ve() {
    a.value.quantity = void 0, a.value.materialOutboundMode === k.BY_PLATE.V && ce("confirmNext", true);
  }
  function Z() {
    const t = ze({ basicClass: C.basicClass, name: u.value.classifyFullName, thickness: u.value.thickness, width: void 0, quantity: void 0, outboundAddress: at.FACTORY.V, overWidth: false, overLength: false });
    return qe(t), t;
  }
  function qe(t) {
    M([() => t], () => {
      J();
    }, { immediate: true, deep: true });
  }
  Re(async () => {
  });
  function ke(t) {
    const e = Z();
    a.value.list.splice(t + 1, 0, e);
  }
  function Ce(t) {
    a.value.list.splice(t, 1);
  }
  function Qe(t) {
    x.value.splice(t, 1);
  }
  function Ue(t) {
    const e = { materialOutboundMode: k.BY_LENGTH.V, materialId: t.id, workshopId: void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, projectId: t.project ? t.project.id : void 0, originProjectId: t.project ? t.project.id : void 0, recipientId: void 0, list: [], remark: void 0, outboundTypeSelection: F.PRODUCE.V, isNeedRemind: lt.YES.V };
    a.value = e;
  }
  function Be() {
    x.value.push({});
  }
  function ee(t, e) {
    let i = 0;
    x.value.forEach((l) => {
      l.singleQuantity && l.segmentQuantity && (i += l.singleQuantity * l.segmentQuantity);
    }), i > T.value && (t[e] = void 0, I({ message: "开平总长不能大于可出库长度", type: "error" }));
  }
  function Te({ row: t, column: e }) {
    if (!t) return;
    const i = X;
    let l = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[e.property] === false && (l = se(e.property, i[e.property], t)), l && (t.verify[e.property] = true)), l ? "" : "mask-td";
  }
  function Le() {
    if (x.value.length <= 0) return I({ message: "请先填写单段长度配置", type: "error" }), false;
    const t = X;
    let e = true;
    return x.value.map((i) => {
      i.verify = {};
      for (const l in t) i.verify[l] = se(l, t[l], i), i.verify[l] || (e = false);
    }), e ? true : (I.error("请填写表格中标红数据"), false);
  }
  async function Se() {
    var O, N;
    if (!Le() || !await L.value.validate()) return false;
    const i = A(a.value);
    if (await ue(i, { unit: i.outboundUnit, precision: i.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), a.value.quantity > T.value) return I.error("开平总长不可大于可出库长度"), false;
    let l = 0;
    if (a.value.list.forEach((w) => {
      l += w.width * w.quantity;
    }), l > u.value.width) throw I.error(`条板总宽：${l}mm，条板总宽不可大于开平宽度`), new Error("宽度超出允许值");
    if (((O = E.value) == null ? void 0 : O.width) < 0) throw I.error("余料错误"), new Error("余料错误");
    const { validResult: p } = _e(a.value.list);
    if (!p) return false;
    let r = A(G.value);
    const f = [];
    if (((N = E.value) == null ? void 0 : N.width) > 0) for (let w = 0; w < x.value.length; w++) f.push({ basicClass: C.basicClass, name: u.value.classifyFullName, thickness: u.value.thickness, width: E.value.width, length: x.value[w].singleQuantity, quantity: x.value[w].segmentQuantity, boolSurplus: true, boolOutbound: false });
    const V = [];
    for (let w = 0; w < f.length; w++) {
      const m = f[w];
      if (m.mete = 0, U(m.quantity) && U(m.length) && U(m.width)) {
        const s = await ne({ classifyId: m.classifyId, name: m.name, length: m.length, width: m.width, thickness: m.thickness, quantity: m.quantity }).then((c) => {
          m.theoryWeight = c, m.mete = m.mete || m.theoryWeight;
        });
        s && V.push(s);
      }
    }
    return await Promise.all(V), r = [...r, ...f], U(r) ? r : void 0;
  }
  async function Ie() {
    if (!await L.value.validate()) return false;
    a.value.boolPartyA = true;
    const e = A(a.value);
    if (a.value.materialOutboundMode === k.BY_WEIGHT.V) {
      const l = ie(a.value.quantity, "m", "mm"), p = R(l / C.material.originQuantity * C.material.operableMete, C.material.accountingPrecision);
      await Fe.confirm(`出库数量为${a.value.quantity}${C.material.measureUnit},对应真实出库量为${p}${C.material.accountingUnit}`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
    }
    return e.materialOutboundMode = e.materialOutboundMode === k.BY_PLATE.V ? k.BY_PLATE.V : k.BY_LENGTH.V, await ue(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), _.value && (e.battenList = await st(e.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] })), await ut(e);
  }
  function Oe() {
    L.value.resetFields();
  }
  function Me() {
    L.value && L.value.clearValidate();
  }
  function $e(t) {
    const { columns: e, data: i } = t, l = [];
    return e.forEach((p, r) => {
      if (r === 0) {
        l[r] = "余料";
        return;
      }
      if (p.property === "width") {
        let f = u.value.width;
        i.forEach((V) => {
          f -= V.width * (V.quantity || 1) || 0;
        }), l[r] = f;
      }
      if (p.property === "mete") {
        let f = a.value.singleTotalWeight;
        i.forEach((V) => {
          f -= V.mete || 0;
        }), l[r] = f > 0 ? f : 0;
      }
      p.property === "quantity" && (l[r] = 1);
    }), l;
  }
  return de({ submit: Ie, nextSubmit: Se, resetForm: Oe, clearValidate: Me, enlargeWth: q(() => _.value) }), (t, e) => {
    const i = z("common-radio"), l = Ae, p = He, r = De, f = z("common-input-number"), V = z("common-button"), O = z("common-table"), N = Ge, w = Ke, m = We("empty");
    return h(fe) ? (v(), je(w, { key: 0, ref_key: "formRef", ref: L, model: a.value, rules: K.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: d(() => [n("div", dt, [o(l, { class: "material-outbound-mode-info", label: "出库方式" }, Ye({ default: d(() => [n("div", mt, [o(i, { modelValue: a.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (s) => a.value.materialOutboundMode = s), options: k, unshowVal: pe.value, size: "default", type: "enum", onChange: Ve }, null, 8, ["modelValue", "unshowVal"]), _.value ? (v(), g("div", ct, e[3] || (e[3] = [n("span", null, "* 提示：", -1), n("span", null, " 出库至钢板库后，无法再进行退库操作，请谨慎操作", -1)]))) : Q("", true)])]), _: 2 }, [_.value ? { name: "label", fn: d(() => [e[2] || (e[2] = n("span", { class: "set-title" }, "出库方式", -1))]), key: "0" } : void 0]), 1024), n("div", { class: te(_.value ? "plate-out-form" : "form") }, [_.value ? Q("", true) : (v(), g("div", pt, [o(ot, { form: a.value, material: u.value }, { afterSpec: d(() => [o(l, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${u.value.thickness}${h(b).thickness.unit} * ${u.value.width}${h(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [o(l, { label: "炉批号/卷号" }, { default: d(() => [ae(n("span", null, null, 512), [[m, { val: u.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])), _.value ? Q("", true) : (v(), g("div", ft, [o(it, { form: a.value, material: u.value }, null, 8, ["form", "material"])])), _.value ? (v(), g("div", ht, [o(h(rt), { form: a.value, material: u.value }, { afterSpec: d(() => [o(p, { label: "厚 * 宽" }, { default: d(() => [n("span", null, y(`${u.value.thickness}${h(b).thickness.unit} * ${u.value.width}${h(b).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [o(p, { label: "炉批号" }, { default: d(() => [ae(n("span", null, null, 512), [[m, { val: u.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])) : Q("", true), _.value ? (v(), g(Y, { key: 3 }, [e[11] || (e[11] = n("div", { class: "divider" }, null, -1)), e[12] || (e[12] = n("span", { class: "set-title" }, "单段配置", -1)), o(O, { "cell-class-name": h(we), data: a.value.list, "max-height": j.maxHeight, "show-empty-symbol": false, "summary-method": $e, "return-source-data": "", "show-summary": "", style: { width: "100%", "margin-top": "15px" } }, { default: d(() => [o(r, { align: "center", label: "序号", type: "index", width: "60" }), o(r, { label: `宽 (${h(b).width.unit})`, align: "center", prop: "width" }, { default: d(({ row: s }) => [o(f, { modelValue: s.width, "onUpdate:modelValue": (c) => s.width = c, class: te({ "over-weight-tip": s.overWidth }), controls: false, max: 999999999, min: D.value, precision: h(b).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "min", "precision"])]), _: 1 }, 8, ["label"]), o(r, { align: "center", label: "数量 (张)", prop: "quantity" }, { default: d(({ row: s }) => [o(f, { modelValue: s.quantity, "onUpdate:modelValue": (c) => s.quantity = c, controls: false, max: 999999999, min: 1, precision: h(b).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), o(r, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: d(({ $index: s }) => [o(V, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => Ce(s) }, null, 8, ["onClick"]), o(V, { class: "icon-button", icon: "el-icon-plus", size: "default", type: "success", onClick: (c) => ke(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]), E.value.width < 0 ? (v(), g("div", vt, e[4] || (e[4] = [n("span", null, "* 错误提示：", -1), n("span", null, " 条板总宽不可大于开平宽度", -1)]))) : Q("", true), n("div", null, [e[10] || (e[10] = n("span", { class: "set-title", style: { "margin-top": "10px" } }, "单段开平预览（横向）", -1)), n("div", gt, [n("div", { style: $(`height:${B}px;`), class: "preview-info" }, [E.value.width && S.value > 1 || !E.value.width && S.value ? (v(), g("div", { key: 0, style: $(`height:${B}px;overflow:hidden;`) }, [(v(true), g(Y, null, le(a.value.list, (s, c) => (v(), g("div", { key: c }, [s.quantity && s.width ? (v(true), g(Y, { key: 0 }, le(s.quantity, (Ne) => (v(), g("div", { key: Ne, style: $({ marginBottom: c === a.value.list.length - 1 && !E.value.width ? "0px" : "1px", height: (B - (S.value - 1)) * s.width / u.value.width + "px", lineHeight: (B - (S.value - 1)) * s.width / u.value.width + "px" }), class: "plate-item" }, y(s.width) + y(h(b).width.unit), 5))), 128)) : Q("", true)]))), 128)), E.value.width ? (v(), g("div", { key: 0, style: $({ backgroundColor: "#c45656", height: (B - (S.value - 1)) * E.value.width / u.value.width + "px", lineHeight: (B - (S.value - 1)) * E.value.width / u.value.width + "px" }), class: "plate-item" }, y(E.value.width) + y(h(b).width.unit), 5)) : Q("", true)], 4)) : (v(), g("div", { key: 1, style: $(`height:${B}px;line-height:${B}px;text-align:center;color: #9e9ea1;border: 1px solid;`) }, e[5] || (e[5] = [n("span", null, "请配置单段配置！", -1)]), 4)), o(re, { customStyle: `height:${B}px;right:-12px;top:0px;`, sizeInfo: `${u.value.width}${h(b).width.unit}`, direction: "vertical" }, null, 8, ["customStyle", "sizeInfo"]), o(re, { customStyle: "width:100%;bottom:-30px;left:0px;", sizeInfo: `${a.value.singleQuantity || 0}${u.value.outboundUnit}`, direction: "horizontal" }, null, 8, ["sizeInfo"])], 4), n("div", yt, [n("div", bt, [e[6] || (e[6] = n("span", { class: "total-label" }, "开平总长", -1)), n("span", _t, y(a.value.quantity || 0) + " " + y(u.value.outboundUnit), 1)]), n("div", wt, [e[7] || (e[7] = n("span", { class: "total-label" }, "开平总重", -1)), n("span", xt, y(a.value.totalWeight || 0) + " " + y(h(b).weight.unit), 1)]), n("div", Et, [e[8] || (e[8] = n("span", { class: "total-label" }, "剩余长度", -1)), n("span", Vt, y(xe.value || 0) + " " + y(u.value.outboundUnit), 1)]), n("div", qt, [e[9] || (e[9] = n("span", { class: "total-label" }, "剩余重量", -1)), n("span", kt, y(Ee.value || 0) + " " + y(h(b).weight.unit), 1)])])])])], 64)) : Q("", true)], 2)]), _.value ? (v(), g("div", Ct, [n("div", Qt, [n("div", Ut, [n("div", Bt, [e[13] || (e[13] = n("span", { class: "set-title" }, "单段长度配置", -1)), o(V, { class: "icon-button", icon: "el-icon-plus", size: "default", style: { float: "right" }, type: "success", onClick: Be })]), o(O, { "cell-class-name": Te, data: x.value, "max-height": j.maxHeight, "show-empty-symbol": false, "return-source-data": "" }, { default: d(() => [o(r, { align: "center", label: "序号", type: "index", width: "55" }), o(r, { label: `单段长度(${u.value.outboundUnit})`, align: "center", "min-width": "120", prop: "singleQuantity" }, { default: d(({ row: s }) => [o(f, { modelValue: s.singleQuantity, "onUpdate:modelValue": (c) => s.singleQuantity = c, controls: false, max: T.value, min: D.value, precision: u.value.outboundUnitPrecision, "controls-position": "right", placeholder: "单段长度", size: "default", onBlur: (c) => ee(s, "singleQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), o(r, { label: "段数(段)", align: "center", "min-width": "120", prop: "segmentQuantity" }, { default: d(({ row: s }) => [o(f, { modelValue: s.segmentQuantity, "onUpdate:modelValue": (c) => s.segmentQuantity = c, controls: false, max: s.singleQuantity ? parseInt(T.value / s.singleQuantity) : 1, min: 0, precision: 0, "controls-position": "right", placeholder: "段数(段)", size: "default", onBlur: (c) => ee(s, "segmentQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onBlur"])]), _: 1 }), o(r, { align: "center", fixed: "right", label: "操作", width: "60px" }, { default: d(({ $index: s }) => [o(V, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (c) => Qe(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), o(l, { "label-width": "0", prop: "remark", style: { "margin-top": "10px" } }, { default: d(() => [o(N, { modelValue: a.value.remark, "onUpdate:modelValue": e[1] || (e[1] = (s) => a.value.remark = s), modelModifiers: { trim: true }, autosize: { minRows: 6, maxRows: 6 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])])])) : Q("", true)]), _: 1 }, 8, ["model", "rules"])) : Q("", true);
  };
} }, $t = Xe(Tt, [["__scopeId", "data-v-5f4954a3"]]);
export {
  $t as default
};
