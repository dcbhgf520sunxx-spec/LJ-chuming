import { ref as p } from "vue";
import { computed as De } from "vue";
import { watch as he } from "vue";
import * as L from "lodash";
import { ElMessage as Me } from "element-plus";
import { resolveComponent as A } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as d } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as x } from "vue";
import { unref as r } from "vue";
import { withDirectives as U } from "vue";
import { createElementBlock as Oe } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as h } from "vue";
import { withModifiers as Qe } from "vue";
import { vShow as Q } from "vue";
import { renderSlot as ye } from "vue";
import { isRef as He } from "vue";
import { ElButton as Je } from "element-plus";
import { ElTableColumn as Ge } from "element-plus";
import { ElTag as Ke } from "element-plus";
import { ElCheckbox as Ye } from "element-plus";
import { ElFormItem as Xe } from "element-plus";
import { ElForm as Ze } from "element-plus";
import { ElCard as ea } from "element-plus";
import { ElImage as aa } from "element-plus";
import { ElTooltip as la } from "element-plus";
import { ElPagination as ta } from "element-plus";
import { vLoading as oa } from "element-plus";
import { _ as na, x as ua, J as ia, u as sa, o as ra, r4 as q, r5 as b, r6 as da, r7 as va, r8 as pa, r9 as ca, E as fa } from "../../../../../shared/runtime.js";
import ma from "./binding-detail.vue.js";
const ha = { class: "content" }, ya = { class: "content-left" }, ga = { class: "title", style: { "margin-bottom": "10px" } }, ba = ["onClick"], _a = { class: "content-right" }, ka = { style: { "margin-top": "10px" } }, $a = { style: { "margin-top": "10px", display: "flex", "justify-content": "space-between" } }, wa = { style: { display: "flex" } }, xa = { class: "title" }, Na = { style: { "min-width": "60px" } }, Va = { style: { "min-width": "60px" } }, Ca = { style: { display: "flex", "margin-bottom": "10px", "justify-content": "space-between" } }, Ea = { style: { display: "flex" } }, Ia = { style: { color: "#16c14e" } }, za = { style: { color: "#f00a0a" } }, Aa = { style: { color: "#16c14e" } }, Fa = { style: { color: "#16c14e" } }, La = { style: { color: "#16c14e" } }, Sa = { __name: "materials-drawer", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, schedulingGroups: { type: Array, default: () => [] }, bindingWorkshopId: { type: Number }, sureBinding: { type: Array, default: () => [] } }, emits: ["update:visible", "close", "success"], setup(j, { emit: ge }) {
  const H = ge, I = j, be = { add: false, edit: false, del: false, download: false }, _e = { SELF: { L: "自采物料", SL: "自采", K: "SELF", V: false }, PARTY_A: { L: "甲供物料", SL: "甲供", K: "PARTY_A", V: true } }, se = p(), { columns: w } = ua({ title: "钢材绑定", sort: [], optShow: { ...be }, crudApi: {}, queryOnPresenterCreated: false, invisibleColumns: ["brand", "heatNoAndBatchNo"] }, se), { handleSizeChange: ke, handleCurrentChange: $e, total: we, setTotalPage: xe, queryPage: J } = ia({ fetchHook: E }), { visible: G, handleClose: K } = sa({ emit: H, props: I, field: "visible", showHook: Ne, closeHook: () => {
    i.value = void 0, u.value = void 0, F.value = false, H("close", pe.value);
  } }), { maxHeight: Y } = ra({ navbar: false, paginate: true }), re = p([]), de = p([]), X = p(void 0), R = p(void 0), Z = p(void 0), W = p(void 0), ee = p(void 0), u = p(void 0), i = p(void 0), N = p([]), S = p([]), ae = p(0), _ = p({}), D = p({}), le = p(false), T = p(q.AREA.V), V = p({}), te = p(false), z = p(void 0), B = p(void 0), P = p(void 0), k = p({}), $ = p({}), M = p(0), O = p(0), ve = p([]), F = p(false), f = p([]), oe = p([]), pe = De(() => {
    const n = Object.values(V.value).filter((l) => l), e = Object.values(_.value).reduce((l, t) => l + t, 0);
    return ae.value !== e + n.length;
  });
  he(() => z.value, () => {
    z.value ? z.value === b.PUBLIC.V ? (B.value = b.PUBLIC.projectWarehouseType, P.value = b.PUBLIC.materialIsWhole) : z.value === b.PROJECT.V ? (B.value = b.PROJECT.projectWarehouseType, P.value = b.PROJECT.materialIsWhole) : z.value === b.REMAIN.V && (B.value = void 0, P.value = b.REMAIN.materialIsWhole) : (B.value = void 0, P.value = void 0), E();
  }), he([() => i.value, () => u.value], () => {
    var e, l;
    const n = S.value.filter((t) => t.thick === i.value && t.material === u.value);
    O.value = ((e = n[0]) == null ? void 0 : e.weight) || 0, M.value = ((l = n[0]) == null ? void 0 : l.area) || 0;
  });
  async function Ne() {
    var l, t;
    f.value = L.clone(I.sureBinding), k.value = {}, $.value = {}, _.value = {}, X.value = I.bindingWorkshopId, W.value = (t = (l = I.list[0]) == null ? void 0 : l.project) == null ? void 0 : t.id, S.value = Le(I.list), ae.value = S.value.length, S.value.forEach((o) => {
      const g = `${o.thick}_${o.material}`;
      V.value[g] || (V.value[g] = false), k.value[g] = 0, $.value[g] = 0, _.value[g] = 0;
    });
    const n = new Set(I.list.map((o) => o.thick)), e = new Set(I.list.map((o) => o.material));
    de.value = Array.from(n).map((o) => ({ label: o, name: o })), re.value = Array.from(e).map((o) => ({ label: o, name: o })), f.value.length && f.value.forEach((o) => {
      $.value[o.key] ? (k.value[o.key] = parseFloat((k.value[o.key] + parseFloat((o.addNumber * parseFloat((o.length / 1e3 * (o.width / 1e3)).toFixed(2))).toFixed(2))).toFixed(2)), $.value[o.key] = $.value[o.key] + o.addNumber * o.oneWeight) : (k.value[o.key] = parseFloat((o.addNumber * parseFloat((o.length / 1e3 * (o.width / 1e3)).toFixed(2))).toFixed(2)), $.value[o.key] = o.addNumber * o.oneWeight), _.value[o.key] = 1;
    });
  }
  function Ve(n) {
    const e = `${i.value}_${u.value}`;
    V.value[e] = n, n ? (N.value = N.value.map((l) => (f.value.forEach((t) => {
      t.id === l.id && (l.frozenQuantity = l.frozenQuantity - t.addNumber, l.addNumber = 0);
    }), l)), f.value = f.value.filter((l) => l.key !== e), delete _.value[e], k.value[`${i.value}_${u.value}`] = 0, $.value[`${i.value}_${u.value}`] = 0) : (f.value = L.clone(oe.value), _.value = L.clone(D.value), f.value.forEach((l) => {
      l.key === e && (k.value[`${i.value}_${u.value}`] += parseFloat((l.length / 1e3 * (l.width / 1e3)).toFixed(2)), $.value[`${i.value}_${u.value}`] += l.oneWeight * l.addNumber);
    }), N.value = N.value.map((l) => (f.value.forEach((t) => {
      t.id === l.id && (l.frozenQuantity = l.frozenQuantity + t.addNumber, l.addNumber = t.addNumber);
    }), l)));
  }
  function Ce(n) {
    n.frozenQuantity += 1, n.addNumber = n.addNumber + 1, k.value[`${i.value}_${u.value}`] = parseFloat((k.value[`${i.value}_${u.value}`] + parseFloat((n.length / 1e3 * (n.width / 1e3)).toFixed(2))).toFixed(2)), $.value[`${i.value}_${u.value}`] = $.value[`${i.value}_${u.value}`] + n.oneWeight, _.value[`${i.value}_${u.value}`] || (_.value[`${i.value}_${u.value}`] = 1), f.value.filter((l) => l.id === n.id).length ? f.value = f.value.map((l) => (l.id === n.id && (l.addNumber += 1), l)) : f.value.push({ ...n, key: `${i.value}_${u.value}` }), oe.value = L.clone(f.value), D.value = L.clone(_.value);
  }
  function Ee(n) {
    n.addNumber -= 1, n.frozenQuantity -= 1, k.value[`${i.value}_${u.value}`] = parseFloat((k.value[`${i.value}_${u.value}`] - parseFloat((n.length / 1e3 * (n.width / 1e3)).toFixed(2))).toFixed(2)), $.value[`${i.value}_${u.value}`] -= n.oneWeight, N.value.every((l) => l.addNumber === 0) && (_.value[`${i.value}_${u.value}`] = 0, D.value[`${i.value}_${u.value}`] = 0);
    const e = f.value.map((l) => {
      if (l.id === n.id) if (l.addNumber > 1) l.addNumber -= 1;
      else return null;
      return l;
    });
    f.value = e.filter((l) => l !== null), oe.value = L.clone(f.value);
  }
  function Ie(n) {
    F.value = true, ve.value = I.list.filter((e) => e.thick === n.thick && e.material === n.material).sort((e, l) => l.length - e.length);
  }
  const ze = (n) => {
    i.value = n.thick, u.value = n.material, E();
  };
  function Ae() {
    H("success", { bindingData: f.value }), K();
  }
  function Fe() {
    for (const n in _.value) _.value[n] = 0, k.value[n] = 0, $.value[n] = 0;
    N.value = N.value.map((n) => (f.value.forEach((e) => {
      e.id === n.id && (n.frozenQuantity = n.frozenQuantity - e.addNumber, n.addNumber = 0);
    }), n)), D.value = {}, f.value = [];
  }
  async function E() {
    te.value = true;
    try {
      const n = await da({ workshopIds: R.value == null ? void 0 : [R.value], thickness: i.value, warehouseId: Z.value, projectId: W.value, specification: u.value, projectWarehouseType: B.value, materialIsWhole: P.value, boolPartyA: ee.value, ...J });
      xe(n.totalElements), N.value = n.content.map((l) => (f.value.forEach((t) => {
        t.id === l.id && (l.frozenQuantity = t.addNumber + l.frozenQuantity, l.addNumber = t.addNumber);
      }), l.oneWeight = Math.round(l.mete / l.quantity), l.originNumber = l.quantity - l.frozenQuantity, l.addNumber = l.addNumber || 0, l)), Array.from(new Set(N.value.map((l) => l.classifyId))).forEach(async (l) => {
        const t = await va(l);
        N.value.forEach((o) => {
          o.classifyId === l && (o.outboundUnit = t.measureUnit, o.outboundUnitPrecision = t.outboundUnitType, o.outboundUnitType = t.outboundUnitType);
        });
      });
    } catch (n) {
      console.error(n), Me.error("获取套料钢板数据失败");
    } finally {
      te.value = false;
    }
  }
  function Le(n) {
    const e = n.reduce((t, o) => {
      const g = `${o.thick}_${o.material}`;
      return t[g] ? (t[g].quantity += o.quantity, t[g].weight = parseFloat((t[g].weight + o.weight).toFixed(2)), t[g].area += o.area) : t[g] = { thick: o.thick, material: o.material, quantity: o.quantity, weight: parseFloat(o.weight.toFixed(2)), area: o.area }, t;
    }, {});
    return Object.values(e).sort((t, o) => t.thick - o.thick);
  }
  return (n, e) => {
    const l = Je, t = Ge, o = A("common-table"), g = Ke, ne = A("common-radio-button"), Se = A("project-cascader"), ue = A("common-select"), Te = Ye, Be = Xe, Pe = Ze, Ue = ea, ie = A("common-button"), ce = A("table-cell-tag"), fe = aa, qe = la, je = ta, Re = A("common-drawer"), We = oa;
    return c(), m(Re, { title: "钢材绑定", modelValue: r(G), "onUpdate:modelValue": e[13] || (e[13] = (a) => He(G) ? G.value = a : null), "show-close": false, "before-close": r(K), "destroy-on-close": "", size: "100%" }, { titleRight: d(() => [s(l, { type: "warning", size: "default", onClick: Ae, disabled: pe.value }, { default: d(() => e[14] || (e[14] = [x(" 下一步 ")])), _: 1, __: [14] }, 8, ["disabled"]), s(l, { size: "default", type: "info", onClick: r(K) }, { default: d(() => e[15] || (e[15] = [x("取消")])), _: 1, __: [15] }, 8, ["onClick"])]), content: d(() => [U((c(), Oe("div", ha, [v("div", ya, [v("div", null, [v("div", ga, [e[16] || (e[16] = v("span", { style: { "background-color": "#0053ff", color: "#fff", width: "60px", display: "inline-block" } }, "项目", -1)), v("span", null, y(j.list[0].project.serialNumber + j.list[0].project.shortName), 1)])]), F.value ? (c(), m(l, { key: 0, size: "default", type: "primary", style: { float: "right", "margin-bottom": "10px" }, onClick: e[0] || (e[0] = (a) => F.value = false) }, { default: d(() => e[17] || (e[17] = [x("关闭")])), _: 1, __: [17] })) : h("", true), F.value ? (c(), m(o, { key: 1, "return-source-data": "", data: ve.value, "max-height": r(Y), "highlight-current-row": "", style: { width: "100%" } }, { default: d(() => [s(t, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" }), s(t, { key: "material", prop: "material", label: "材质", align: "center" }), s(t, { key: "specification", prop: "specification", label: "规格", align: "center" }), s(t, { key: "length", prop: "length", label: "长度", align: "center" }), s(t, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), s(t, { key: "area", prop: "area", label: "面积", align: "center" }), s(t, { key: "weight", prop: "weight", label: "重量", align: "center" })]), _: 1 }, 8, ["data", "max-height"])) : h("", true), F.value ? h("", true) : (c(), m(o, { key: 2, "return-source-data": "", data: S.value, "max-height": r(Y), "highlight-current-row": "", style: { width: "100%" }, onRowClick: ze }, { default: d(() => [s(t, { label: "序号", type: "index", align: "center", width: "60" }), s(t, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度", align: "center" }), s(t, { key: "material", prop: "material", label: "材质", align: "center" }), s(t, { key: "quantity", prop: "quantity", label: "零件数量（件）", align: "center" }, { default: d(({ row: a }) => [v("span", { style: { color: "#0053ff", cursor: "pointer" }, onClick: Qe((C) => Ie(a), ["stop"]) }, y(a.quantity), 9, ba)]), _: 1 }), s(t, { key: "weight", prop: "weight", label: "零件重量（kg）", align: "center" }), s(t, { key: "status", prop: "status", label: "绑定状态", align: "center" }, { default: d(({ row: a }) => [V.value[`${a.thick}_${a.material}`] ? h("", true) : (c(), m(g, { key: 0, type: _.value[`${a.thick}_${a.material}`] ? "success" : "danger" }, { default: d(() => [x(y(_.value[`${a.thick}_${a.material}`] ? "已绑定" : "未绑定"), 1)]), _: 2 }, 1032, ["type"])), V.value[`${a.thick}_${a.material}`] ? (c(), m(g, { key: 1, type: "primary" }, { default: d(() => e[18] || (e[18] = [x("无需绑定")])), _: 1, __: [18] })) : h("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]))]), v("div", _a, [U(s(g, { type: "info", size: "large" }, { default: d(() => e[19] || (e[19] = [x(" * 点击左边某行可查看物料列表 ")])), _: 1, __: [19] }, 512), [[Q, !i.value || !u.value]]), U(s(Ue, { shadow: "always" }, { default: d(() => [v("div", null, [s(ne, { modelValue: z.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => z.value = a), options: r(b).ENUM, showOptionAll: "", type: "enum", size: "default" }, null, 8, ["modelValue", "options"]), s(ne, { modelValue: ee.value, "onUpdate:modelValue": e[2] || (e[2] = (a) => ee.value = a), options: _e, "show-option-all": "", type: "enumSL", size: "default", class: "filter-item", style: { "margin-left": "10px" }, onChange: E }, null, 8, ["modelValue"])]), v("div", ka, [s(Se, { modelValue: W.value, "onUpdate:modelValue": e[3] || (e[3] = (a) => W.value = a), placeholder: "所属项目", style: { width: "270px" }, clearable: "", onChange: E, class: "filter-item" }, null, 8, ["modelValue"]), s(ue, { modelValue: X.value, "onUpdate:modelValue": e[4] || (e[4] = (a) => X.value = a), options: j.schedulingGroups, "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "全部车间", style: { margin: "0 10px" }, clearable: "" }, null, 8, ["modelValue", "options"]), s(pa, { modelValue: R.value, "onUpdate:modelValue": e[5] || (e[5] = (a) => R.value = a), placeholder: "请选择仓库", style: { "margin-left": "10px" }, clearable: "", class: "filter-item", onChange: E }, null, 8, ["modelValue"]), s(ca, { modelValue: Z.value, "onUpdate:modelValue": e[6] || (e[6] = (a) => Z.value = a), workshopId: R.value, placeholder: "存储位置", class: "filter-item", style: { "margin-left": "10px" }, "show-all": "", clearable: "", onChange: E }, null, 8, ["modelValue", "workshopId"])]), v("div", $a, [s(Pe, { "label-width": "auto", style: { "max-width": "800px" } }, { default: d(() => [s(Be, { label: "其它厚度和材质筛选" }, { default: d(() => [s(ue, { modelValue: i.value, "onUpdate:modelValue": e[7] || (e[7] = (a) => i.value = a), options: de.value, "data-structure": { key: "name", label: "label", value: "name" }, placeholder: "厚度筛选", onChange: E }, null, 8, ["modelValue", "options"]), s(ue, { modelValue: u.value, "onUpdate:modelValue": e[8] || (e[8] = (a) => u.value = a), options: re.value, "data-structure": { key: "name", label: "label", value: "name" }, placeholder: "材质筛选", style: { margin: "0 10px" }, onChange: E }, null, 8, ["modelValue", "options"]), s(Te, { modelValue: V.value[`${i.value}_${u.value}`], "onUpdate:modelValue": e[9] || (e[9] = (a) => V.value[`${i.value}_${u.value}`] = a), label: "无需绑定钢板", onChange: Ve }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), v("div", wa, [v("div", xa, [e[20] || (e[20] = v("span", { style: { "background-color": "#0053ff", color: "#fff", width: "70px" } }, "钢板种类", -1)), v("span", Na, y(ae.value) + "种", 1)]), v("div", { class: "title", style: { "margin-left": "10px" }, onClick: e[10] || (e[10] = (a) => le.value = true) }, [e[21] || (e[21] = v("span", { style: { "background-color": "#16c14e", color: "#fff", width: "70px" } }, "已绑定", -1)), v("span", Va, y(Object.values(_.value).reduce((a, C) => a + C, 0) || 0) + "种", 1)])])])]), _: 1 }, 512), [[Q, i.value && u.value]]), U(v("div", Ca, [v("div", Ea, [s(ne, { modelValue: T.value, "onUpdate:modelValue": e[11] || (e[11] = (a) => T.value = a), options: r(q).ENUM, type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options"]), s(ie, { style: { "margin-left": "10px" }, size: "default" }, { default: d(() => [v("span", Ia, y(T.value === r(q).AREA.V ? `零件面积：${M.value.toFixed(2)}㎡` : `零件重量：${Math.round(O.value)}kg`), 1), e[22] || (e[22] = x(" | ")), v("span", za, y(T.value === r(q).AREA.V ? `钢板面积：${k.value[`${i.value}_${u.value}`] || 0}㎡` : `钢板重量：${Math.round($.value[`${i.value}_${u.value}`] / 1e3 || 0)}kg`), 1), e[23] || (e[23] = x(" | ")), v("span", Aa, " 吻合度：" + y(T.value === r(q).AREA.V ? k.value[`${i.value}_${u.value}`] && M.value ? (k.value[`${i.value}_${u.value}`] / M.value * 100).toFixed(2) : 0 : $.value[`${i.value}_${u.value}`] && O.value ? ($.value[`${i.value}_${u.value}`] / 1e3 / O.value * 100).toFixed(2) : 0) + "% ", 1)]), _: 1, __: [22, 23] })])], 512), [[Q, i.value && u.value]]), i.value && u.value ? (c(), m(r(fa), { key: 0 }, { optLeft: d(() => [ye(n.$slots, "optLeft", {}, void 0, true)]), viewLeft: d(() => [ye(n.$slots, "viewLeft", {}, void 0, true)]), _: 3 })) : h("", true), U(s(o, { ref_key: "tableRef", ref: se, "return-source-data": "", data: N.value, "max-height": r(Y) - 170, style: { width: "100%" }, id: "steelListTable" }, { default: d(() => [s(t, { label: "序号", type: "index", align: "center", width: "60" }), r(w).visible("classifyName") ? (c(), m(t, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: a }) => {
      var C, me;
      return [a.materialIsWhole === r(b).REMAIN.materialIsWhole ? (c(), m(ce, { key: 0, name: r(b).VL[r(b).REMAIN.V], color: (C = r(b)) == null ? void 0 : C.V[r(b).REMAIN.V].COLOR, offset: 15 }, null, 8, ["name", "color"])) : (c(), m(ce, { key: 1, name: r(b).VL[a.warehouseType], color: (me = r(b)) == null ? void 0 : me.V[a.warehouseType].COLOR, offset: 15 }, null, 8, ["name", "color"])), v("span", null, y(a.classifyName), 1)];
    }), _: 1 })) : h("", true), r(w).visible("specification") ? (c(), m(t, { key: "specification", prop: "specification", label: "材质", align: "center", "show-overflow-tooltip": true })) : h("", true), r(w).visible("thickness") ? (c(), m(t, { key: "thickness", prop: "thickness", label: "厚（mm）", align: "center" })) : h("", true), r(w).visible("material") ? (c(), m(t, { key: "material", prop: "material", label: "规格", align: "center", "show-overflow-tooltip": true, width: "120px" }, { default: d(({ row: a }) => [v("span", null, y(`${a.length} * ${a.width}`), 1)]), _: 1 })) : h("", true), r(w).visible("quantity") ? (c(), m(t, { key: "quantity", prop: "quantity", label: "库存（张）", align: "center" }, { default: d(({ row: a }) => [v("span", Fa, y(a.quantity - a.frozenQuantity), 1), e[24] || (e[24] = x(" / ")), v("span", null, y(a.quantity), 1)]), _: 1 })) : h("", true), r(w).visible("mete") ? (c(), m(t, { key: "mete", prop: "mete", label: "重量（kg）", align: "center", "min-width": "120px", "show-overflow-tooltip": true }, { default: d(({ row: a }) => [v("span", La, y(Math.round((a.quantity - a.frozenQuantity) * a.oneWeight / 1e3)), 1), e[25] || (e[25] = x(" / ")), v("span", null, y(Math.round(a.mete / 1e3)), 1)]), _: 1 })) : h("", true), r(w).visible("area") ? (c(), m(t, { key: "area", prop: "area", label: "单张面积（㎡）", align: "center", "min-width": "100px", "show-overflow-tooltip": true }, { default: d(({ row: a }) => [v("span", null, y((a.length / 1e3 * (a.width / 1e3)).toFixed(2)), 1)]), _: 1 })) : h("", true), r(w).visible("brand") ? (c(), m(t, { key: "brand", prop: "brand", label: "品牌", align: "center", "show-overflow-tooltip": true })) : h("", true), r(w).visible("heatNoAndBatchNo") ? (c(), m(t, { key: "heatNoAndBatchNo", prop: "heatNoAndBatchNo", label: "炉批号", align: "center", "show-overflow-tooltip": true })) : h("", true), r(w).visible("projectName") ? (c(), m(t, { key: "projectName", prop: "projectName", label: "所属项目", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: a }) => {
      var C;
      return [v("span", null, y(((C = a == null ? void 0 : a.project) == null ? void 0 : C.name) || "-"), 1)];
    }), _: 1 })) : h("", true), r(w).visible("warehouseName") ? (c(), m(t, { key: "warehouseName", prop: "warehouseName", label: "库位", align: "center", "min-width": "100px", "show-overflow-tooltip": true }, { default: d(({ row: a }) => [v("span", null, y(a.warehouse.name), 1)]), _: 1 })) : h("", true), r(w).visible("picturePath") ? (c(), m(t, { key: "picturePath", prop: "picturePath", label: "缩略图", align: "center" }, { default: d((a) => [s(qe, { placement: "top", effect: "light", ref: "tooltip", "show-after": 300 }, { content: d(() => [s(fe, { style: { width: "200px", height: "200px" }, fit: "scale-down", "scroll-container": "#steelListTable .el-table__body-wrapper", src: `${a.row.picturePath}` }, null, 8, ["src"])]), default: d(() => [s(fe, { style: { width: "100%", height: "20px" }, lazy: "", fit: "scale-down", "scroll-container": "#steelListTable .el-table__body-wrapper", src: `${a.row.picturePath}` }, null, 8, ["src"])]), _: 2 }, 1536)]), _: 1 })) : h("", true), s(t, { label: "操作", width: "160", align: "center" }, { default: d(({ row: a }) => [s(ie, { type: "success", size: "default", disabled: a.quantity - a.frozenQuantity < 1 || V.value[`${i.value}_${u.value}`], onClick: (C) => Ce(a) }, { default: d(() => e[26] || (e[26] = [x("添加")])), _: 2, __: [26] }, 1032, ["disabled", "onClick"]), s(ie, { type: "warning", size: "default", disabled: !a.addNumber || V.value[`${i.value}_${u.value}`], onClick: (C) => Ee(a) }, { default: d(() => e[27] || (e[27] = [x("减少")])), _: 2, __: [27] }, 1032, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), [[Q, i.value && u.value]]), i.value && u.value ? (c(), m(je, { key: 1, total: r(we), "current-page": r(J).pageNumber, "page-size": r(J).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(ke), onCurrentChange: r($e) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])) : h("", true)])])), [[We, te.value]]), s(ma, { visible: le.value, "onUpdate:visible": e[12] || (e[12] = (a) => le.value = a), detailList: f.value, onDelete: Fe }, null, 8, ["visible", "detailList"])]), _: 3 }, 8, ["modelValue", "before-close"]);
  };
} }, Ua = na(Sa, [["__scopeId", "data-v-ecba08cd"]]);
export {
  Ua as default
};
