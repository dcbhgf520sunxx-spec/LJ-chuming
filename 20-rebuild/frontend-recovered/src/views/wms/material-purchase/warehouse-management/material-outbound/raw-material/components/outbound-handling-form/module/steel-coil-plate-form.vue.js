import { computed as U } from "vue";
import { ref as P } from "vue";
import { provide as Oe } from "vue";
import { watch as A } from "vue";
import { reactive as se } from "vue";
import { watchEffect as ze } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as Be } from "vue";
import { unref as x } from "vue";
import { openBlock as q } from "vue";
import { createBlock as Ne } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as m } from "vue";
import { normalizeClass as oe } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as k } from "vue";
import { withDirectives as $e } from "vue";
import { createCommentVNode as j } from "vue";
import { Fragment as H } from "vue";
import { normalizeStyle as N } from "vue";
import { renderList as ue } from "vue";
import { ElMessage as L } from "element-plus";
import { ElDescriptionsItem as Me } from "element-plus";
import { ElTableColumn as Pe } from "element-plus";
import { ElInput as Te } from "element-plus";
import { ElFormItem as Re } from "element-plus";
import { ElForm as Ae } from "element-plus";
import { _ as De, y1 as He, sQ as Ke, bC as Ye, c as O, iX as re, qS as Je, aw as Ge, i as Q, y2 as K, fK as de, V as Y, x_ as me, jl as Xe, y4 as Ze, b as et, c9 as T } from "../../../../../../../../../shared/runtime.js";
import tt from "../components/descriptions-material-info.vue.js";
import { M as ce } from "../../../../../../../../../modules/index-330e9f5e.js";
const lt = { style: { "min-width": "800px" } }, at = { key: 0, class: "plate-out-material-info" }, it = { key: 0, class: "tip", style: { "margin-top": "10px" } }, nt = { style: { display: "flex", "margin-bottom": "15px", "margin-top": "15px" } }, st = { class: "total-info" }, ot = { class: "total-item" }, ut = { class: "total-value" }, rt = { class: "total-item" }, dt = { class: "total-value" }, mt = { class: "total-item total-item-surplus" }, ct = { class: "total-value" }, ht = { class: "total-item total-item-surplus" }, ft = { class: "total-value" }, pt = { key: 0, style: { "margin-left": "30px" } }, gt = { class: "other-info" }, yt = { style: { width: "530px" } }, vt = { style: { "margin-bottom": "10px" } }, I = 260, wt = { __name: "steel-coil-plate-form", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number }, projectWarehouseType: { type: [Number, String], default: void 0 }, formData: { type: Object, default: () => {
} } }, setup(J, { expose: he }) {
  const { steelMinLengthConfig: G } = He(), X = { BY_LENGTH: { L: "按长度出库", K: "BY_LENGTH ", V: 1 }, BY_PLATE: { L: "按条板出库", K: "BY_PLATE", V: 2 } }, Z = U(() => {
    var e, t;
    return (e = G.value) != null && e.steelPlateShortestSideMinLength ? ((t = G.value) == null ? void 0 : t.steelPlateShortestSideMinLength) + 1 : 0;
  }), E = J, W = P(), n = P({ list: [] }), { loaded: fe, baseUnit: V } = Ke(E.basicClass);
  Ye(W, n, ["quantity"]);
  const d = U(() => {
    var t;
    const e = JSON.parse(JSON.stringify(E.material)) || {};
    return e.corQuantity = O(e.corQuantity, "m", "mm"), e.corOperableQuantity = O(e.corOperableQuantity, "m", "mm"), (t = e.projectFrozenForUnitKV) != null && t[n.value.projectId] && (e.projectFrozenForUnitKV[n.value.projectId] = O(e.projectFrozenForUnitKV[n.value.projectId], "m", "mm")), e.outboundUnit = "mm", e.outboundUnitPrecision = 0, e;
  }), g = P([{}]), $ = P([]), F = U(() => n.value.materialOutboundMode === X.BY_PLATE.V), pe = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: (e, t, a) => {
    if (et(t)) return a(new Error("请填写数量"));
    if (t <= 0) return a(new Error("数量必须大于0"));
    if (t > S.value) return a(new Error("数量不可超过可操作数量"));
    a();
  }, trigger: "blur" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, ge = { remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, ye = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: T, message: "宽度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: T, message: "数量必须大于0", trigger: "blur" }] }, ee = { singleQuantity: [{ required: true, message: "请填写单段长度", trigger: "blur" }, { pattern: T, message: "单段长度必须大于0", trigger: "blur" }], segmentQuantity: [{ required: true, message: "请填写段数", trigger: "blur" }, { pattern: T, message: "段数必须大于0", trigger: "blur" }] }, { tableValidate: ve, wrongCellMask: we } = Ge({ rules: ye }), be = U(() => F.value ? Object.assign({}, ge) : Object.assign({}, pe)), S = U(() => !n.value || !n.value.projectId || !d.value.projectFrozenForUnitKV ? d.value.corOperableQuantity : d.value.corOperableQuantity + (d.value.projectFrozenForUnitKV[n.value.projectId] || 0));
  Oe("maxQuantity", S);
  const B = U(() => re(S.value - n.value.quantity, d.value.outboundUnitPrecision)), _e = U(() => {
    var e, t;
    return n.value.quantity === S.value ? 0 : re(d.value.operableMete - n.value.totalWeight, (t = (e = V.value) == null ? void 0 : e.weight) == null ? void 0 : t.precision);
  }), v = U(() => {
    let e = d.value.width, t = n.value.singleTotalWeight;
    return n.value.list.forEach((a) => {
      e -= a.width * (a.quantity || 1) || 0, t -= a.mete || 0;
    }), { width: e, mete: t > 0 ? t : 0 };
  }), z = U(() => {
    let e = 0;
    return n.value.list.forEach((t) => {
      e += t.quantity || 0;
    }), v.value.width > 0 && (e += 1), e;
  });
  A(d, (e) => {
    le(e);
    const t = R();
    n.value.list = [], n.value.list.push(t);
  }, { immediate: true, deep: true });
  async function te() {
    var f;
    const e = [], t = [];
    Q(n.value.list) && Q(g.value) && n.value.list.forEach((i) => {
      g.value.forEach((l) => {
        for (let _ = 0; _ < l.segmentQuantity; _++) e.push({ ...i, classifyId: d.value.classifyId, quantity: i.quantity || 0, length: l.singleQuantity || 0, steelDensity: d.value.steelDensity, mete: 0 });
      });
    });
    for (let i = 0; i < e.length; i++) {
      const l = e[i];
      if (l.mete = 0, l.length = l.length ? O(l.length, "mm", "m") : 0, Q(l.quantity) && Q(l.length) && Q(l.width)) {
        const _ = await K({ classifyId: l.classifyId, name: l.name, length: l.length, width: l.width, thickness: l.thickness, quantity: l.quantity }).then((s) => {
          l.theoryWeight = s, l.mete = l.mete || l.theoryWeight;
        });
        _ && t.push(_);
      }
    }
    const a = [];
    if (((f = v.value) == null ? void 0 : f.width) > 0) for (let i = 0; i < g.value.length; i++) for (let l = 0; l < g.value[i].segmentQuantity; l++) a.push({ basicClass: E.basicClass, name: d.value.classifyFullName, classifyId: d.value.classifyId, thickness: d.value.thickness, width: v.value.width, length: O(g.value[i].singleQuantity, "mm", "m"), quantity: 1, boolSurplus: true, boolOutbound: false });
    const u = [];
    for (let i = 0; i < a.length; i++) {
      const l = a[i];
      if (l.mete = 0, Q(l.quantity) && Q(l.length) && Q(l.width)) {
        const _ = await K({ classifyId: l.classifyId, name: l.name, length: l.length, width: l.width, thickness: l.thickness, quantity: l.quantity }).then((s) => {
          l.theoryWeight = s, l.mete = l.mete || l.theoryWeight;
        });
        _ && u.push(_);
      }
    }
    await Promise.all(t), await Promise.all(u);
    let b = 0, r = E.material.operableMete, y = E.material.width;
    n.value.list.forEach((i) => {
      y -= i.width;
    }), e.forEach((i, l) => {
      i.boolSurplus = false, i.boolOutbound = true, r > 0 ? r > i.mete && (B.value > 0 || y > 0 || l < e.length - 1) ? r -= i.mete : (i.mete = r, r = 0) : i.mete = 0, b += i.mete || 0;
    }), a.forEach((i, l) => {
      r > 0 ? r > i.mete && (B.value > 0 || l < a.length - 1) ? r -= i.mete : (i.mete = r, r = 0) : i.mete = 0, b += i.mete || 0;
    }), n.value.totalWeight = b, $.value = e;
  }
  function R() {
    const e = se({ basicClass: E.basicClass, name: d.value.classifyFullName, thickness: d.value.thickness, width: void 0, quantity: void 0, outboundAddress: Je.FACTORY.V, overWidth: false, overLength: false });
    return ke(e), e;
  }
  function xe() {
    const e = se({ singleQuantity: void 0, segmentQuantity: void 0 });
    return qe(e), e;
  }
  function ke(e) {
    A([() => e], () => {
      te();
    }, { immediate: true, deep: true });
  }
  function qe(e) {
    A([() => e], () => {
      let t = 0;
      Q(g.value) && g.value.forEach((a) => {
        a.singleQuantity && a.segmentQuantity && (t += a.singleQuantity * a.segmentQuantity);
      }), n.value.quantity = t, te();
    }, { immediate: true, deep: true });
  }
  ze(async () => {
  });
  function Qe(e) {
    const t = R();
    n.value.list.splice(e + 1, 0, t);
  }
  function Ee(e) {
    if (n.value.list.length === 1) {
      L({ message: "至少保留一条明细", type: "error" });
      return;
    }
    n.value.list.splice(e, 1);
  }
  function Ve(e) {
    g.value.splice(e, 1);
  }
  function le(e) {
    var a;
    g.value = [];
    const t = { materialOutboundMode: X.BY_PLATE.V, materialId: e.id, factoryId: (a = e.factory) == null ? void 0 : a.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, projectId: e.project ? e.project.id : void 0, recipientId: void 0, list: [], remark: void 0 };
    n.value = t;
  }
  function Ce() {
    const e = xe();
    g.value.push(e);
  }
  function ae(e, t) {
    let a = 0;
    g.value.forEach((u) => {
      u.singleQuantity && u.segmentQuantity && (a += u.singleQuantity * u.segmentQuantity);
    }), a > S.value && (e[t] = void 0, L({ message: "开平总长不能大于可出库长度", type: "error" }));
  }
  function Ue({ row: e, column: t }) {
    if (!e) return;
    const a = ee;
    let u = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[t.property] === false && (u = de(t.property, a[t.property], e)), u && (e.verify[t.property] = true)), u ? "" : "mask-td";
  }
  function ie() {
    if (g.value.length <= 0) return L({ message: "请先填写单段长度配置", type: "error" }), false;
    const e = ee;
    let t = true;
    return g.value.map((a) => {
      a.verify = {};
      for (const u in e) a.verify[u] = de(u, e[u], a), a.verify[u] || (t = false);
    }), t ? true : (L.error("请填写表格中标红数据"), false);
  }
  async function Ie() {
    var p, M;
    if (!ie() || !await W.value.validate()) return false;
    const a = Y(n.value);
    if (await me(a, { unit: a.outboundUnit, precision: a.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), n.value.quantity > S.value) return L.error("开平总长不可大于可出库长度"), false;
    let u = 0;
    if (n.value.list.forEach((o) => {
      u += o.width * o.quantity;
    }), u > d.value.width) throw L.error(`条板总宽：${u}mm，条板总宽不可大于开平宽度`), new Error("宽度超出允许值");
    if (((p = v.value) == null ? void 0 : p.width) < 0) throw L.error("余料错误"), new Error("余料错误");
    const { validResult: b } = ve(n.value.list);
    if (!b) return false;
    const r = [];
    if ($.value.forEach((o) => {
      o.mete === 0 && r.push({ width: o.width, length: o.length, quantity: o.quantity, msg: "宽度(mm) " + o.width + "、数量(张) " + o.quantity + "、单段长度(mm) " + O(o.length, "m", "mm") + "，理论重量（kg）等于0，请修改！" });
    }), console.log($.value, r, "11111"), r != null && r.length) {
      const o = r.map((h) => `<div>${h.msg}<div>`).join("");
      return L({ message: o, dangerouslyUseHTMLString: true, type: "error", duration: 5e3 }), false;
    }
    let y = Y($.value);
    const f = [];
    if (((M = v.value) == null ? void 0 : M.width) > 0) for (let o = 0; o < g.value.length; o++) for (let h = 0; h < g.value[o].segmentQuantity; h++) f.push({ basicClass: E.basicClass, name: d.value.classifyFullName, classifyId: d.value.classifyId, thickness: d.value.thickness, width: v.value.width, length: O(g.value[o].singleQuantity, "mm", "m"), quantity: 1, boolSurplus: true, boolOutbound: false });
    const i = [];
    for (let o = 0; o < f.length; o++) {
      const h = f[o];
      if (h.mete = 0, Q(h.quantity) && Q(h.length) && Q(h.width)) {
        const ne = await K({ classifyId: h.classifyId, name: h.name, length: h.length, width: h.width, thickness: h.thickness, quantity: h.quantity }).then((je) => {
          h.theoryWeight = je, h.mete = h.mete || h.theoryWeight;
        });
        ne && i.push(ne);
      }
    }
    await Promise.all(i);
    let l = E.material.operableMete, _ = E.material.width;
    n.value.list.forEach((o) => {
      _ -= o.width;
    }), y.forEach((o, h) => {
      l > 0 ? l > o.mete && (B.value > 0 || _ > 0 || h < y.length - 1) ? l -= o.mete : (o.mete = l, l = 0) : o.mete = 0;
    }), f.forEach((o, h) => {
      l > 0 ? l > o.mete && (B.value > 0 || h < f.length - 1) ? l -= o.mete : (o.mete = l, l = 0) : o.mete = 0;
    }), y = [...y, ...f];
    const s = JSON.parse(JSON.stringify(n.value));
    return delete s.list, s.list = y, Object.assign(E.formData, s), true;
  }
  async function Se() {
    if (!ie() || !await W.value.validate()) return false;
    const a = Y(n.value);
    return await me(a, { unit: a.outboundUnit, precision: a.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), F.value && (a.battenList = await Xe(a.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] })), await Ze(a);
  }
  function Le() {
    W.value.resetFields();
  }
  function We() {
    W.value && W.value.clearValidate(), le(E.material);
    const e = R();
    n.value.list = [], n.value.list.push(e);
  }
  function Fe(e) {
    const { columns: t, data: a } = e, u = [];
    let b = d.value.width;
    return a.forEach((r) => {
      b -= r.width * (r.quantity || 1) || 0;
    }), t.forEach((r, y) => {
      if (y === 0) {
        u[y] = "余料";
        return;
      }
      if (r.property === "width" && (u[y] = b), r.property === "mete") {
        let f = n.value.singleTotalWeight;
        a.forEach((i) => {
          f -= i.mete || 0;
        }), u[y] = f > 0 ? f : 0;
      }
      if (r.property === "quantity") {
        let f = d.value.width;
        a.forEach((i) => {
          f -= i.width * (i.quantity || 1) || 0;
        }), u[y] = f <= 0 ? 0 : 1;
      }
    }), u;
  }
  return he({ submit: Se, validateSubmit: Ie, resetForm: Le, clearValidate: We, enlargeWth: U(() => F.value) }), (e, t) => {
    const a = Me, u = Pe, b = D("common-input-number"), r = D("common-button"), y = D("common-table"), f = Te, i = Re, l = Ae, _ = Be("empty");
    return x(fe) ? (q(), Ne(l, { key: 0, ref_key: "formRef", ref: W, model: n.value, rules: be.value, size: "default", "label-position": "left", "label-width": "120px", style: { display: "flex", overflow: "auto" } }, { default: w(() => [m("div", lt, [m("div", { class: oe(F.value ? "plate-out-form" : "form") }, [F.value ? (q(), C("div", at, [c(x(tt), { form: n.value, material: d.value }, { afterSpec: w(() => [c(a, { label: "厚 * 宽" }, { default: w(() => [m("span", null, k(`${d.value.thickness}${x(V).thickness.unit} * ${d.value.width}${x(V).width.unit}`), 1)]), _: 1 })]), afterBrand: w(() => [c(a, { label: "炉批号" }, { default: w(() => [$e(m("span", null, null, 512), [[_, { val: d.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])])) : j("", true), F.value ? (q(), C(H, { key: 1 }, [t[8] || (t[8] = m("div", { class: "divider" }, null, -1)), t[9] || (t[9] = m("span", { class: "set-title" }, "单段配置", -1)), c(y, { "cell-class-name": x(we), data: n.value.list, "max-height": 280, "show-empty-symbol": false, "summary-method": Fe, "return-source-data": "", "show-summary": "", style: { width: "100%", "margin-top": "15px" } }, { default: w(() => [c(u, { align: "center", label: "序号", type: "index", width: "60" }), c(u, { label: `宽 (${x(V).width.unit})`, align: "center", prop: "width" }, { default: w(({ row: s }) => [c(b, { modelValue: s.width, "onUpdate:modelValue": (p) => s.width = p, class: oe({ "over-weight-tip": s.overWidth }), controls: false, max: 999999999, min: Z.value, precision: x(V).width.precision, size: "default", placeholder: "宽" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "min", "precision"])]), _: 1 }, 8, ["label"]), c(u, { align: "center", label: "数量 (张)", prop: "quantity" }, { default: w(({ row: s }) => [c(b, { modelValue: s.quantity, "onUpdate:modelValue": (p) => s.quantity = p, controls: false, max: 999999999, min: 1, precision: x(V).measure.precision, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), c(u, { align: "center", fixed: "right", label: "操作", width: "100px" }, { default: w(({ $index: s }) => [c(r, { icon: "el-icon-delete", type: "danger", size: "default", class: "icon-button", onClick: (p) => Ee(s) }, null, 8, ["onClick"]), c(r, { icon: "el-icon-plus", type: "success", size: "default", class: "icon-button", onClick: (p) => Qe(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data"]), v.value.width < 0 ? (q(), C("div", it, t[1] || (t[1] = [m("span", null, "* 错误提示：", -1), m("span", null, " 条板总宽不可大于开平宽度", -1)]))) : j("", true), m("div", null, [t[7] || (t[7] = m("span", { class: "set-title", style: { "margin-top": "10px" } }, "单段开平预览（横向）", -1)), m("div", nt, [m("div", { style: N(`height:${I}px;`), class: "preview-info" }, [v.value.width && z.value > 1 || !v.value.width && z.value ? (q(), C("div", { key: 0, style: N(`height:${I}px;overflow:hidden;`) }, [(q(true), C(H, null, ue(n.value.list, (s, p) => (q(), C("div", { key: p }, [s.quantity && s.width ? (q(true), C(H, { key: 0 }, ue(s.quantity, (M) => (q(), C("div", { key: M, style: N({ marginBottom: p === n.value.list.length - 1 && !v.value.width ? "0px" : "1px", height: (I - (z.value - 1)) * s.width / d.value.width + "px", lineHeight: (I - (z.value - 1)) * s.width / d.value.width + "px" }), class: "plate-item" }, k(s.width) + k(x(V).width.unit), 5))), 128)) : j("", true)]))), 128)), v.value.width ? (q(), C("div", { key: 0, style: N({ backgroundColor: "#c45656", height: (I - (z.value - 1)) * v.value.width / d.value.width + "px", lineHeight: (I - (z.value - 1)) * v.value.width / d.value.width + "px" }), class: "plate-item" }, k(v.value.width) + k(x(V).width.unit), 5)) : j("", true)], 4)) : (q(), C("div", { key: 1, style: N(`height:${I}px;line-height:${I}px;text-align:center;color: #9e9ea1;border: 1px solid;`) }, t[2] || (t[2] = [m("span", null, "请配置单段配置！", -1)]), 4)), c(ce, { customStyle: `height:${I}px;right:-12px;top:0px;`, sizeInfo: `${d.value.width}${x(V).width.unit}`, direction: "vertical" }, null, 8, ["customStyle", "sizeInfo"]), c(ce, { customStyle: "width:100%;bottom:-30px;left:0px;", showType: "unshow", sizeInfo: `${n.value.singleQuantity || 0}${d.value.outboundUnit}`, direction: "horizontal" }, null, 8, ["sizeInfo"])], 4), m("div", st, [m("div", ot, [t[3] || (t[3] = m("span", { class: "total-label" }, "开平总长", -1)), m("span", ut, k(n.value.quantity || 0) + " " + k(d.value.outboundUnit), 1)]), m("div", rt, [t[4] || (t[4] = m("span", { class: "total-label" }, "开平总重", -1)), m("span", dt, k(n.value.totalWeight || 0) + " " + k(x(V).weight.unit), 1)]), m("div", mt, [t[5] || (t[5] = m("span", { class: "total-label" }, "剩余长度", -1)), m("span", ct, k(B.value || 0) + " " + k(d.value.outboundUnit), 1)]), m("div", ht, [t[6] || (t[6] = m("span", { class: "total-label" }, "剩余重量", -1)), m("span", ft, k(_e.value || 0) + " " + k(x(V).weight.unit), 1)])])])])], 64)) : j("", true)], 2)]), F.value ? (q(), C("div", pt, [m("div", gt, [m("div", yt, [m("div", vt, [t[10] || (t[10] = m("span", { class: "set-title" }, "单段长度配置", -1)), c(r, { icon: "el-icon-plus", style: { float: "right" }, type: "success", size: "default", class: "icon-button", onClick: Ce })]), c(y, { data: g.value, "max-height": J.maxHeight - 150, "cell-class-name": Ue, "return-source-data": "", "show-empty-symbol": false }, { default: w(() => [c(u, { label: "序号", type: "index", align: "center", width: "55" }), c(u, { prop: "singleQuantity", align: "center", label: `单段长度(${d.value.outboundUnit})`, "min-width": "120" }, { default: w(({ row: s }) => [c(b, { modelValue: s.singleQuantity, "onUpdate:modelValue": (p) => s.singleQuantity = p, controls: false, max: S.value, min: Z.value, precision: d.value.outboundUnitPrecision, size: "default", placeholder: "单段长度", onBlur: (p) => ae(s, "singleQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onBlur"])]), _: 1 }, 8, ["label"]), c(u, { label: "段数(段)", align: "center", "min-width": "120", prop: "segmentQuantity" }, { default: w(({ row: s }) => [c(b, { modelValue: s.segmentQuantity, "onUpdate:modelValue": (p) => s.segmentQuantity = p, controls: false, max: s.singleQuantity ? parseInt(S.value / s.singleQuantity) : 1, min: 0, precision: 0, size: "default", placeholder: "段数(段)", onBlur: (p) => ae(s, "segmentQuantity") }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onBlur"])]), _: 1 }), c(u, { align: "center", fixed: "right", label: "操作", width: "60px" }, { default: w(({ $index: s }) => [c(r, { icon: "el-icon-delete", type: "danger", size: "default", class: "icon-button", onClick: (p) => Ve(s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), c(i, { "label-width": "0", prop: "remark", style: { "margin-top": "10px" } }, { default: w(() => [c(f, { modelValue: n.value.remark, "onUpdate:modelValue": t[0] || (t[0] = (s) => n.value.remark = s), modelModifiers: { trim: true }, autosize: { minRows: 6, maxRows: 6 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })])])])) : j("", true)]), _: 1 }, 8, ["model", "rules"])) : j("", true);
  };
} }, Qt = De(wt, [["__scopeId", "data-v-2e7aeec3"]]);
export {
  Qt as default
};
