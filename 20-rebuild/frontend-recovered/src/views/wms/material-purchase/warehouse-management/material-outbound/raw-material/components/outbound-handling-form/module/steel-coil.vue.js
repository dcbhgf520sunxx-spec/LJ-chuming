import { computed as b } from "vue";
import { ref as L } from "vue";
import { provide as Ke } from "vue";
import { watch as A } from "vue";
import { reactive as Xe } from "vue";
import { watchEffect as Je } from "vue";
import { resolveComponent as $ } from "vue";
import { resolveDirective as Ze } from "vue";
import { unref as f } from "vue";
import { openBlock as v } from "vue";
import { createBlock as et } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as r } from "vue";
import { createSlots as tt } from "vue";
import { createElementBlock as _ } from "vue";
import { createCommentVNode as M } from "vue";
import { normalizeClass as le } from "vue";
import { toDisplayString as w } from "vue";
import { withDirectives as ue } from "vue";
import { Fragment as F } from "vue";
import { normalizeStyle as N } from "vue";
import { renderList as oe } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElMessageBox as at } from "element-plus";
import { ElFormItem as it } from "element-plus";
import { ElDescriptionsItem as nt } from "element-plus";
import { ElTableColumn as lt } from "element-plus";
import { ElInput as ut } from "element-plus";
import { ElForm as ot } from "element-plus";
import { _ as st, y1 as rt, gG as q, c as se, sQ as dt, bC as ct, jY as mt, y4 as pt, Al as gt, Am as ht, An as ft, iX as R, i as I, y2 as re, zL as de, bR as ce, bD as D, Ao as vt, aw as yt, fK as me, V as G, x_ as bt, cS as K, jl as pe, b as ge, c9 as Y } from "../../../../../../../../../shared/runtime.js";
import _t from "../components/common-material-info.vue.js";
import wt from "../components/descriptions-material-info.vue.js";
import { M as he } from "../../../../../../../../../modules/index-330e9f5e.js";
const Et = { style: { "min-width": "800px" } }, Tt = { style: { display: "flex" } }, Vt = { key: 0, class: "tip" }, Ut = { key: 0, class: "material-info" }, xt = { key: 1, class: "form-info" }, St = { key: 2, class: "plate-out-material-info" }, qt = { key: 0, class: "tip", style: { "margin-top": "10px" } }, Mt = { style: { display: "flex", "margin-bottom": "15px", "margin-top": "15px" } }, It = { class: "total-info" }, Ct = { class: "total-item" }, kt = { class: "total-value" }, Ot = { class: "total-item" }, Pt = { class: "total-value" }, Qt = { class: "total-item total-item-surplus" }, Rt = { class: "total-value" }, Bt = { class: "total-item total-item-surplus" }, Lt = { class: "total-value" }, At = { key: 0, style: { "margin-left": "30px" } }, Nt = { class: "other-info" }, Wt = { style: { width: "530px" } }, $t = { style: { "margin-bottom": "10px" } }, C = 260, Yt = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number } }, emits: ["confirmNext"], setup(j, { expose: fe, emit: ve }) {
  const { steelMinLengthConfig: X } = rt(), y = { BY_LENGTH: { L: "按长度出库", K: "BY_LENGTH ", V: 1 }, BY_PLATE: { L: "按条板出库", K: "BY_PLATE", V: 2 }, BY_WEIGHT: { L: "按重量出库", K: "BY_WEIGHT", V: 4 } }, ye = ve, be = b(() => a.value.outboundTypeSelection === q.PRODUCE.V ? [y.BY_PLATE.V] : [y.BY_PLATE.V, y.BY_WEIGHT.V]), J = b(() => {
    var i, t;
    return (i = X.value) != null && i.steelPlateShortestSideMinLength ? se((t = X.value) == null ? void 0 : t.steelPlateShortestSideMinLength, "mm", "m") : 0;
  }), s = j, O = L(), a = L({ list: [] }), { loaded: _e, baseUnit: E } = dt(s.basicClass);
  ct(O, a, ["quantity"]);
  const o = b(() => s.material || {}), U = L([{}]), Z = L([]), T = b(() => a.value.materialOutboundMode === y.BY_PLATE.V), we = (i, t, e) => {
    if (ge(t)) return e(new Error("请填写数量"));
    if (t <= 0) return e(new Error("数量必须大于0"));
    if (t > k.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, Ee = (i, t, e) => {
    var n;
    if (ge(t)) return e(new Error("请填写核算量"));
    if (t <= 0) return e(new Error("必须大于0"));
    if (t > ((n = s.material) == null ? void 0 : n.operableMete)) return e(new Error("不可超过可操作核算量"));
    e();
  }, Te = (i, t, e) => {
    a.value.invoiceType || a.value.invoiceType === 0 ? a.value.invoiceType === D.SPECIAL.V && !a.value.taxRate ? e(new Error("请选择税率")) : e() : e(new Error("请选择发票及税率")), e();
  }, { outboundCfg: Ve } = mt(), ee = b(() => {
    let i = { outboundMete: [{ required: true, validator: Ee, trigger: "blur" }], quantity: [{ required: true, validator: we, trigger: "blur" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }], theoryTotalWeight: [{ required: true, message: "请输入理论重量", trigger: "blur" }], weighingWeight: [{ required: true, message: "请输入过磅重量", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], purchaseId: [{ required: true, message: "请选择所属采购合同", trigger: "change" }], invoiceType: [{ required: true, validator: Te, trigger: "change" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return a.value.outboundTypeSelection !== q.CONSTRUCTION_SITE_USE.V && (i = Object.assign(i, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), Ve.value.productionOutBoundUserIsRequired && (i = Object.assign(i, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), i;
  }), Ue = { remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, xe = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Y, message: "宽度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Y, message: "数量必须大于0", trigger: "blur" }] }, te = { singleQuantity: [{ required: true, message: "请填写单段长度", trigger: "blur" }, { pattern: Y, message: "单段长度必须大于0", trigger: "blur" }], segmentQuantity: [{ required: true, message: "请填写段数", trigger: "blur" }, { pattern: Y, message: "段数必须大于0", trigger: "blur" }] }, { tableValidate: Se, wrongCellMask: qe } = yt({ rules: xe }), Me = b(() => {
    switch (a.value.outboundTypeSelection) {
      case q.OUTSOURCE.V:
        return ft;
      case q.FOR_SALE.V:
        return z.value ? gt : ht;
      default:
        return pt;
    }
  }), Ie = b(() => a.value.outboundTypeSelection || q.PRODUCE.V);
  b(() => T.value ? Object.assign({}, Ue) : Object.assign({}, ee));
  const k = b(() => !a.value || !a.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[a.value.projectId] || 0));
  Ke("maxQuantity", k);
  const Ce = b(() => R(k.value - a.value.quantity, o.value.outboundUnitPrecision)), ke = b(() => {
    var i, t;
    return a.value.quantity === k.value ? 0 : R(o.value.operableMete - a.value.totalWeight, (t = (i = E.value) == null ? void 0 : i.weight) == null ? void 0 : t.precision);
  }), x = b(() => {
    let i = o.value.width, t = a.value.singleTotalWeight;
    return a.value.list.forEach((e) => {
      i -= e.width * (e.quantity || 1) || 0, t -= e.mete || 0;
    }), { width: i, mete: t > 0 ? t : 0 };
  }), P = b(() => {
    let i = 0;
    return a.value.list.forEach((t) => {
      i += t.quantity || 0;
    }), x.value.width > 0 && (i += 1), i;
  });
  A(o, (i) => {
    Le(i);
  }, { immediate: true }), A(() => T.value, (i) => {
    if (i) {
      const t = ie();
      a.value.list = [], a.value.list.push(t);
    }
  }, { immediate: true }), A([() => a.value.singleQuantity, () => a.value.segmentQuantity], () => {
    T.value && (a.value.quantity = R(a.value.singleQuantity && a.value.segmentQuantity ? a.value.singleQuantity * a.value.segmentQuantity : 0, o.value.outboundUnitPrecision));
  }), A(U.value, (i) => {
    let t = 0;
    I(i) && i.forEach((e) => {
      e.singleQuantity && e.segmentQuantity && (t += e.singleQuantity * e.segmentQuantity);
    }), a.value.quantity = t, ae();
  }, { immediate: true, deep: true });
  async function ae() {
    const i = [], t = [];
    a.value.totalWeight = 0, I(a.value.list) && I(U.value) && a.value.list.forEach((e) => {
      U.value.forEach((n) => {
        for (let h = 0; h < n.segmentQuantity; h++) i.push({ ...e, quantity: e.quantity || 0, length: n.singleQuantity || 0 });
      });
    });
    for (let e = 0; e < i.length; e++) {
      const n = i[e];
      if (n.mete = 0, I(n.quantity) && I(n.length) && I(n.width)) {
        const h = await re({ classifyId: n.classifyId, name: n.name, length: n.length, width: n.width, thickness: n.thickness, quantity: n.quantity }).then((d) => {
          n.theoryWeight = d, n.mete = n.mete || n.theoryWeight;
        });
        h && t.push(h);
      }
    }
    await Promise.all(t), i.forEach((e) => {
      e.boolSurplus = false, e.boolOutbound = true, a.value.totalWeight += e.mete || 0;
    }), Z.value = i;
  }
  function Oe() {
    a.value.quantity = void 0, a.value.materialOutboundMode === y.BY_PLATE.V && ye("confirmNext", true);
  }
  function ie() {
    const i = Xe({ basicClass: s.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: void 0, quantity: void 0, overWidth: false, overLength: false });
    return Pe(i), i;
  }
  function Pe(i) {
    A([() => i], () => {
      ae();
    }, { immediate: true, deep: true });
  }
  Je(async () => {
  });
  function Qe(i) {
    const t = ie();
    a.value.list.splice(i + 1, 0, t);
  }
  function Re(i) {
    a.value.list.splice(i, 1);
  }
  function Be(i) {
    U.value.splice(i, 1);
  }
  function Le(i) {
    let t = { materialOutboundMode: y.BY_LENGTH.V, materialId: i.id, workshopId: void 0, outboundUnit: i.outboundUnit, outboundUnitPrecision: i.outboundUnitPrecision, projectId: i.project ? i.project.id : void 0, recipientId: void 0, list: [], remark: void 0, isNeedRemind: de.YES.V, boolPartyA: false, outboundTypeSelection: q.PRODUCE.V };
    if (a.value.outboundTypeSelection === q.FOR_SALE.V) {
      const e = { weightMeasurementMode: ce.THEORY.V, quantity: void 0, sellUnitPrice: void 0, sellAmount: void 0, theoryTotalWeight: void 0, weighingWeight: void 0, invoiceType: D.SPECIAL.V, inputMete: void 0, taxRate: void 0 };
      t = Object.assign(t, e);
    }
    a.value = t;
  }
  function Ae() {
    a.value.materialOutboundMode = y.BY_LENGTH.V, a.value.weightMeasurementMode = ce.THEORY.V, a.value.quantity = void 0, a.value.sellUnitPrice = void 0, a.value.sellAmount = void 0, a.value.theoryTotalWeight = void 0, a.value.weighingWeight = void 0, a.value.invoiceType = D.SPECIAL.V, a.value.taxRate = void 0, a.value.isNeedRemind = de.YES.V, a.value.inputMete = void 0;
  }
  function Ne() {
    U.value.push({});
  }
  function ne(i, t) {
    let e = 0;
    U.value.forEach((n) => {
      n.singleQuantity && n.segmentQuantity && (e += n.singleQuantity * n.segmentQuantity);
    }), e > k.value && (i[t] = void 0, Q({ message: "开平总长不能大于可出库长度", type: "error" }));
  }
  function We({ row: i, column: t }) {
    if (!i) return;
    const e = te;
    let n = true;
    return i.verify && Object.keys(i.verify) && Object.keys(i.verify).length > 0 && (i.verify[t.property] === false && (n = me(t.property, e[t.property], i)), n && (i.verify[t.property] = true)), n ? "" : "mask-td";
  }
  function $e() {
    if (U.value.length <= 0) return Q({ message: "请先填写单段长度配置", type: "error" }), false;
    const i = te;
    let t = true;
    return U.value.map((e) => {
      e.verify = {};
      for (const n in i) e.verify[n] = me(n, i[n], e), e.verify[n] || (t = false);
    }), t ? true : (Q.error("请填写表格中标红数据"), false);
  }
  async function Ye() {
    var B, W;
    if (!$e() || !await O.value.validate()) return false;
    const e = G(a.value);
    if (await bt(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), a.value.quantity > k.value) return Q.error("开平总长不可大于可出库长度"), false;
    let n = 0;
    if (a.value.list.forEach((V) => {
      n += V.width * V.quantity;
    }), n > o.value.width) throw Q.error(`条板总宽：${n}mm，条板总宽不可大于开平宽度`), new Error("宽度超出允许值");
    if (((B = x.value) == null ? void 0 : B.width) < 0) throw Q.error("余料错误"), new Error("余料错误");
    const { validResult: h } = Se(a.value.list);
    if (!h) return false;
    let d = G(Z.value);
    const m = [];
    if (((W = x.value) == null ? void 0 : W.width) > 0) for (let V = 0; V < U.value.length; V++) m.push({ basicClass: s.basicClass, name: o.value.classifyFullName, thickness: o.value.thickness, width: x.value.width, length: U.value[V].singleQuantity, quantity: U.value[V].segmentQuantity, boolSurplus: true, boolOutbound: false });
    const S = [];
    for (let V = 0; V < m.length; V++) {
      const p = m[V];
      if (p.mete = 0, I(p.quantity) && I(p.length) && I(p.width)) {
        const u = await re({ classifyId: p.classifyId, name: p.name, length: p.length, width: p.width, thickness: p.thickness, quantity: p.quantity }).then((g) => {
          p.theoryWeight = g, p.mete = p.mete || p.theoryWeight;
        });
        u && S.push(u);
      }
    }
    return await Promise.all(S), d = [...d, ...m], I(d) ? d : void 0;
  }
  const z = L();
  function je() {
    return z.value = true, H(true);
  }
  async function ze() {
    return z.value = false, H(false);
  }
  async function H(i) {
    if (!await O.value.validate()) return false;
    if (a.value.materialOutboundMode === y.BY_WEIGHT.V) {
      const d = se(a.value.quantity, "m", "mm"), m = R(d / s.material.originQuantity * s.material.operableMete, s.material.accountingPrecision);
      await at.confirm(`出库数量为${a.value.quantity}${s.material.measureUnit},对应真实出库量为${m}${s.material.accountingUnit}`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
    }
    let e = G(a.value);
    e = { ...e, outboundUnitType: s.material.outboundUnitType, unitNet: s.material.unitNet, outboundQuantity: e.materialOutboundMode === y.BY_WEIGHT.V || s.material.outboundUnitType === K.MEASURE.V ? e.quantity : s.material.measureUnit && s.material.measurePrecision && s.material.operableMete ? R(e.quantity / s.material.operableMete * s.material.operableQuantity, s.material.measurePrecision) : void 0, outboundMete: e.materialOutboundMode === y.BY_WEIGHT.V ? e.outboundMete : s.material.outboundUnitType === K.MEASURE.V ? s.material.accountingUnit && s.material.operableQuantity ? R(e.quantity / s.material.operableQuantity * s.material.operableMete, s.material.accountingPrecision) : void 0 : e.quantity }, e.outboundTypeSelection !== q.PRODUCE.V && (e.boolSubmitCheck = i), T.value && (e.battenList = await pe(e.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] })), await pe(e, { basicClass: s.material.basicClass, measureUnit: s.material.measureUnit, measurePrecision: s.material.measurePrecision, accountingUnit: s.material.accountingUnit, accountingPrecision: s.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["inputMete", "outboundMete"], amount: ["sellUnitPrice"] });
    let n = { materialId: s.material.id, monomerId: e.monomerId, areaId: e.areaId, workshopId: e.workshopId, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, projectId: e.projectId, areaBatchId: e.areaBatchId, materialOutboundMode: e.materialOutboundMode === y.BY_PLATE.V ? y.BY_PLATE.V : y.BY_LENGTH.V, halfMode: e.halfMode, outboundTypeSelection: e.outboundTypeSelection, remark: e.remark, quantity: e.outboundUnitType === K.MEASURE.V ? e.outboundQuantity : e.outboundMete, boolPartyA: false, outboundTime: e.outboundTime, isNeedRemind: e.isNeedRemind };
    if (a.value.outboundTypeSelection === q.PRODUCE.V || e.outboundTypeSelection === q.OUTSOURCE.V) {
      const d = { recipientId: e.recipientId };
      n = Object.assign(n, d);
    }
    if (e.outboundTypeSelection === q.OUTSOURCE.V) {
      const d = { purchaseId: e.purchaseId };
      n = Object.assign(n, d);
    }
    if (e.outboundTypeSelection === q.FOR_SALE.V) {
      const d = { weightMeasurementMode: e.weightMeasurementMode, sellUnitPrice: e.sellUnitPrice, sellAmount: e.sellAmount, invoiceType: e.invoiceType, inputMete: e.inputMete, taxRate: e.taxRate, branchCompanyId: e.branchCompanyId, purchaser: e.purchaser };
      n = Object.assign(n, d);
    }
    return await Me.value(n);
  }
  function He() {
    O.value.resetFields();
  }
  function Fe() {
    O.value && O.value.clearValidate();
  }
  function De(i) {
    const { columns: t, data: e } = i, n = [];
    return t.forEach((h, d) => {
      if (d === 0) {
        n[d] = "余料";
        return;
      }
      if (h.property === "width") {
        let m = o.value.width;
        e.forEach((S) => {
          m -= S.width * (S.quantity || 1) || 0;
        }), n[d] = m;
      }
      if (h.property === "mete") {
        let m = a.value.singleTotalWeight;
        e.forEach((S) => {
          m -= S.mete || 0;
        }), n[d] = m > 0 ? m : 0;
      }
      h.property === "quantity" && (n[d] = 1);
    }), n;
  }
  return fe({ submit: H, commonSubmit: ze, auditSubmit: je, nextSubmit: Ye, resetForm: He, outboundTypeSelection: Ie, clearValidate: Fe, enlargeWth: b(() => T.value), form: a, formInitTwo: Ae }), (i, t) => {
    const e = $("common-radio"), n = it, h = nt, d = lt, m = $("common-input-number"), S = $("common-button"), B = $("common-table"), W = ut, V = ot, p = Ze("empty");
    return f(_e) ? (v(), et(V, { key: 0, ref_key: "formRef", ref: O, model: a.value, rules: ee.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: c(() => [l("div", Et, [r(n, { class: "material-outbound-mode-info", label: "出库方式" }, tt({ default: c(() => [l("div", Tt, [r(e, { modelValue: a.value.materialOutboundMode, "onUpdate:modelValue": t[0] || (t[0] = (u) => a.value.materialOutboundMode = u), options: y, unshowVal: be.value, size: "default", type: "enum", onChange: Oe }, null, 8, ["modelValue", "unshowVal"]), T.value ? (v(), _("div", Vt, t[3] || (t[3] = [l("span", null, "* 提示：", -1), l("span", null, " 出库至钢板库后，无法再进行退库操作，请谨慎操作", -1)]))) : M("", true)])]), _: 2 }, [T.value ? { name: "label", fn: c(() => [t[2] || (t[2] = l("span", { class: "set-title" }, "出库方式", -1))]), key: "0" } : void 0]), 1024), l("div", { class: le(T.value ? "plate-out-form" : "form") }, [T.value ? M("", true) : (v(), _("div", Ut, [r(_t, { form: a.value, material: o.value }, { afterSpec: c(() => [r(n, { label: "厚 * 宽" }, { default: c(() => [l("span", null, w(`${o.value.thickness}${f(E).thickness.unit} * ${o.value.width}${f(E).width.unit}`), 1)]), _: 1 })]), afterBrand: c(() => [r(n, { label: "炉批号/卷号" }, { default: c(() => [ue(l("span", null, null, 512), [[p, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])), T.value ? M("", true) : (v(), _("div", xt, [r(vt, { form: a.value, material: o.value }, null, 8, ["form", "material"])])), T.value ? (v(), _("div", St, [r(f(wt), { form: a.value, material: o.value }, { afterSpec: c(() => [r(h, { label: "厚 * 宽" }, { default: c(() => [l("span", null, w(`${o.value.thickness}${f(E).thickness.unit} * ${o.value.width}${f(E).width.unit}`), 1)]), _: 1 })]), afterBrand: c(() => [r(h, { label: "炉批号" }, { default: c(() => [ue(l("span", null, null, 512), [[p, { val: o.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])) : M("", true), T.value ? (v(), _(F, { key: 3 }, [t[11] || (t[11] = l("div", { class: "divider" }, null, -1)), t[12] || (t[12] = l("span", { class: "set-title" }, "单段配置", -1)), r(B, { "cell-class-name": f(qe), data: a.value.list, "max-height": j.maxHeight, "show-empty-symbol": false, "summary-method": De, "return-source-data": "", "show-summary": "", style: { width: "100%", "margin-top": "15px" } }, { default: c(() => [r(d, { align: "center", label: "序号", type: "index", width: "60" }), r(d, { label: `宽 (${f(E).width.unit})`, align: "center", prop: "width" }, { default: c(({ row: u }) => [r(m, { modelValue: u.width, "onUpdate:modelValue": (g) => u.width = g, class: le({ "over-weight-tip": u.overWidth }), controls: false, max: 999999999, min: J.value, precision: f(E).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "min", "precision"])]), _: 1 }, 8, ["label"]), r(d, { align: "center", label: "数量 (张)", prop: "quantity" }, { default: c(({ row: u }) => [r(m, { modelValue: u.quantity, "onUpdate:modelValue": (g) => u.quantity = g, controls: false, max: 999999999, min: 1, precision: f(E).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), r(d, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: c(({ $index: u }) => [r(S, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (g) => Re(u) }, null, 8, ["onClick"]), r(S, { class: "icon-button", icon: "el-icon-plus", size: "default", type: "success", onClick: (g) => Qe(u) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]), x.value.width < 0 ? (v(), _("div", qt, t[4] || (t[4] = [l("span", null, "* 错误提示：", -1), l("span", null, " 条板总宽不可大于开平宽度", -1)]))) : M("", true), l("div", null, [t[10] || (t[10] = l("span", { class: "set-title", style: { "margin-top": "10px" } }, "单段开平预览（横向）", -1)), l("div", Mt, [l("div", { style: N(`height:${C}px;`), class: "preview-info" }, [x.value.width && P.value > 1 || !x.value.width && P.value ? (v(), _("div", { key: 0, style: N(`height:${C}px;overflow:hidden;`) }, [(v(true), _(F, null, oe(a.value.list, (u, g) => (v(), _("div", { key: g }, [u.quantity && u.width ? (v(true), _(F, { key: 0 }, oe(u.quantity, (Ge) => (v(), _("div", { key: Ge, style: N({ marginBottom: g === a.value.list.length - 1 && !x.value.width ? "0px" : "1px", height: (C - (P.value - 1)) * u.width / o.value.width + "px", lineHeight: (C - (P.value - 1)) * u.width / o.value.width + "px" }), class: "plate-item" }, w(u.width) + w(f(E).width.unit), 5))), 128)) : M("", true)]))), 128)), x.value.width ? (v(), _("div", { key: 0, style: N({ backgroundColor: "#c45656", height: (C - (P.value - 1)) * x.value.width / o.value.width + "px", lineHeight: (C - (P.value - 1)) * x.value.width / o.value.width + "px" }), class: "plate-item" }, w(x.value.width) + w(f(E).width.unit), 5)) : M("", true)], 4)) : (v(), _("div", { key: 1, style: N(`height:${C}px;line-height:${C}px;text-align:center;color: #9e9ea1;border: 1px solid;`) }, t[5] || (t[5] = [l("span", null, "请配置单段配置！", -1)]), 4)), r(he, { customStyle: `height:${C}px;right:-12px;top:0px;`, sizeInfo: `${o.value.width}${f(E).width.unit}`, direction: "vertical" }, null, 8, ["customStyle", "sizeInfo"]), r(he, { customStyle: "width:100%;bottom:-30px;left:0px;", sizeInfo: `${a.value.singleQuantity || 0}${o.value.outboundUnit}`, direction: "horizontal" }, null, 8, ["sizeInfo"])], 4), l("div", It, [l("div", Ct, [t[6] || (t[6] = l("span", { class: "total-label" }, "开平总长", -1)), l("span", kt, w(a.value.quantity || 0) + " " + w(o.value.outboundUnit), 1)]), l("div", Ot, [t[7] || (t[7] = l("span", { class: "total-label" }, "开平总重", -1)), l("span", Pt, w(a.value.totalWeight || 0) + " " + w(f(E).weight.unit), 1)]), l("div", Qt, [t[8] || (t[8] = l("span", { class: "total-label" }, "剩余长度", -1)), l("span", Rt, w(Ce.value || 0) + " " + w(o.value.outboundUnit), 1)]), l("div", Bt, [t[9] || (t[9] = l("span", { class: "total-label" }, "剩余重量", -1)), l("span", Lt, w(ke.value || 0) + " " + w(f(E).weight.unit), 1)])])])])], 64)) : M("", true)], 2)]), T.value ? (v(), _("div", At, [l("div", Nt, [l("div", Wt, [l("div", $t, [t[13] || (t[13] = l("span", { class: "set-title" }, "单段长度配置", -1)), r(S, { class: "icon-button", icon: "el-icon-plus", size: "default", style: { float: "right" }, type: "success", onClick: Ne })]), r(B, { "cell-class-name": We, data: U.value, "max-height": j.maxHeight, "show-empty-symbol": false, "return-source-data": "" }, { default: c(() => [r(d, { align: "center", label: "序号", type: "index", width: "55" }), r(d, { label: `单段长度(${o.value.outboundUnit})`, align: "center", "min-width": "120", prop: "singleQuantity" }, { default: c(({ row: u }) => [r(m, { modelValue: u.singleQuantity, "onUpdate:modelValue": (g) => u.singleQuantity = g, controls: false, max: k.value, min: J.value, precision: o.value.outboundUnitPrecision, "controls-position": "right", placeholder: "单段长度", size: "default", onBlur: (g) => ne(u, "singleQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), r(d, { label: "段数(段)", align: "center", "min-width": "120", prop: "segmentQuantity" }, { default: c(({ row: u }) => [r(m, { modelValue: u.segmentQuantity, "onUpdate:modelValue": (g) => u.segmentQuantity = g, controls: false, max: u.singleQuantity ? parseInt(k.value / u.singleQuantity) : 1, min: 0, precision: 0, "controls-position": "right", placeholder: "段数(段)", size: "default", onBlur: (g) => ne(u, "segmentQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onBlur"])]), _: 1 }), r(d, { align: "center", fixed: "right", label: "操作", width: "60px" }, { default: c(({ $index: u }) => [r(S, { class: "icon-button", icon: "el-icon-delete", size: "default", type: "danger", onClick: (g) => Be(u) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), r(n, { "label-width": "0", prop: "remark", style: { "margin-top": "10px" } }, { default: c(() => [r(W, { modelValue: a.value.remark, "onUpdate:modelValue": t[1] || (t[1] = (u) => a.value.remark = u), modelModifiers: { trim: true }, autosize: { minRows: 6, maxRows: 6 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])])])) : M("", true)]), _: 1 }, 8, ["model", "rules"])) : M("", true);
  };
} }, Gt = st(Yt, [["__scopeId", "data-v-2c09bba8"]]);
export {
  Gt as default
};
