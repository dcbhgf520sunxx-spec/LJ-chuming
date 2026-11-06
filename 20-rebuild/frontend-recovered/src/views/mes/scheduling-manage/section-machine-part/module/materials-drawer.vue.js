import { ref as r } from "vue";
import { computed as Re } from "vue";
import { watch as fe } from "vue";
import * as I from "lodash";
import { resolveComponent as A } from "vue";
import { openBlock as v } from "vue";
import { createBlock as f } from "vue";
import { withCtx as d } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as k } from "vue";
import { unref as i } from "vue";
import { withDirectives as j } from "vue";
import { createElementBlock as Ge } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as y } from "vue";
import { withModifiers as Oe } from "vue";
import { vShow as R } from "vue";
import { renderSlot as me } from "vue";
import { isRef as Qe } from "vue";
import { ElButton as Fe } from "element-plus";
import { ElTableColumn as Je } from "element-plus";
import { ElTag as Ke } from "element-plus";
import { ElCheckbox as Ye } from "element-plus";
import { ElFormItem as Ze } from "element-plus";
import { ElForm as Xe } from "element-plus";
import { ElCard as ea } from "element-plus";
import { ElPagination as aa } from "element-plus";
import { vLoading as la } from "element-plus";
import { _ as ta, x as na, J as oa, u as ia, o as ua, r4 as M, r5 as h, rH as sa, r7 as ra, r8 as da, r9 as ca, E as pa } from "../../../../../shared/runtime.js";
import va from "./binding-detail.vue.js";
const fa = { class: "content" }, ma = { class: "content-left" }, ya = { class: "title", style: { "margin-bottom": "10px" } }, ha = ["onClick"], ga = { class: "content-right" }, ba = { style: { "margin-top": "10px" } }, _a = { style: { "margin-top": "10px", display: "flex", "justify-content": "space-between" } }, Na = { style: { display: "flex" } }, ka = { class: "title" }, wa = { style: { "min-width": "60px" } }, xa = { style: { "min-width": "60px" } }, Va = { style: { display: "flex", "margin-bottom": "10px", "justify-content": "space-between" } }, Ca = { style: { display: "flex" } }, Ea = { style: { color: "#16c14e" } }, La = { style: { color: "#f00a0a" } }, $a = { style: { color: "#16c14e" } }, Aa = { style: { color: "#16c14e" } }, Ta = { style: { color: "#16c14e" } }, Ia = { __name: "materials-drawer", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, schedulingGroups: { type: Array, default: () => [] }, bindingWorkshopId: { type: Number }, sureBinding: { type: Array, default: () => [] } }, emits: ["update:visible", "close", "success"], setup(G, { emit: ye }) {
  const O = ye, L = G, he = { add: false, edit: false, del: false, download: false }, ge = { SELF: { L: "自采物料", SL: "自采", K: "SELF", V: false }, PARTY_A: { L: "甲供物料", SL: "甲供", K: "PARTY_A", V: true } }, oe = r(), { columns: C } = na({ title: "钢材绑定", sort: [], optShow: { ...he }, crudApi: {}, queryOnPresenterCreated: false, invisibleColumns: ["brand", "heatNoAndBatchNo"] }, oe), { handleSizeChange: be, handleCurrentChange: _e, total: Ne, setTotalPage: ke, queryPage: Q } = oa({ fetchHook: E }), { visible: F, handleClose: J } = ia({ emit: O, props: L, field: "visible", showHook: xe, closeHook: () => {
    o.value = void 0, T.value = false, O("close", re.value);
  } }), { maxHeight: K } = ua({ navbar: false, paginate: true }), ie = r([]), we = r(void 0), U = r(void 0), Y = r(void 0), W = r(void 0), Z = r(void 0), o = r(void 0), w = r([]), S = r([]), X = r(0), g = r({}), P = r({}), ee = r(false), z = r(M.LENGTH.V), x = r({});
  let ue = r(void 0);
  const ae = r(false), $ = r(void 0), B = r(void 0), q = r(void 0), b = r({}), _ = r({}), D = r(0), H = r(0), se = r([]), T = r(false), p = r([]), le = r([]), re = Re(() => {
    const n = Object.values(x.value).filter((l) => l), e = Object.values(g.value).reduce((l, a) => l + a, 0);
    return X.value !== e + n.length;
  });
  fe(() => $.value, () => {
    $.value ? $.value === h.PUBLIC.V ? (B.value = h.PUBLIC.projectWarehouseType, q.value = h.PUBLIC.materialIsWhole) : $.value === h.PROJECT.V ? (B.value = h.PROJECT.projectWarehouseType, q.value = h.PROJECT.materialIsWhole) : $.value === h.REMAIN.V && (B.value = void 0, q.value = h.REMAIN.materialIsWhole) : (B.value = void 0, q.value = void 0), E();
  }), fe([() => o.value], () => {
    var e, l;
    const n = S.value.filter((a) => a.specificationAndMaterial === o.value);
    H.value = ((e = n[0]) == null ? void 0 : e.weight) || 0, D.value = ((l = n[0]) == null ? void 0 : l.length) || 0;
  });
  async function xe() {
    var e, l;
    p.value = I.clone(L.sureBinding), b.value = {}, _.value = {}, g.value = {}, we.value = L.bindingWorkshopId, W.value = (l = (e = L.list[0]) == null ? void 0 : e.project) == null ? void 0 : l.id, S.value = Ie(L.list), X.value = S.value.length, S.value.forEach((a) => {
      const c = `${a.specificationAndMaterial}`;
      x.value[c] || (x.value[c] = false), b.value[c] = 0, _.value[c] = 0, g.value[c] = 0;
    });
    const n = new Set(L.list.map((a) => a.specificationAndMaterial));
    ie.value = Array.from(n).map((a) => ({ label: a, name: a })), p.value.length && p.value.forEach((a) => {
      _.value[a.key] ? (b.value[a.key] = b.value[a.key] + a.addNumber * Number(a.length), _.value[a.key] = _.value[a.key] + a.addNumber * a.oneWeight) : (b.value[a.key] = a.addNumber * Number(a.length), _.value[a.key] = a.addNumber * a.oneWeight), g.value[a.key] = 1;
    });
  }
  function Ve(n) {
    const e = `${o.value}`;
    x.value[e] = n, n ? (w.value = w.value.map((l) => (p.value.forEach((a) => {
      a.id === l.id && (l.frozenQuantity = l.frozenQuantity - a.addNumber, l.addNumber = 0);
    }), l)), p.value = p.value.filter((l) => l.key !== e), delete g.value[e], b.value[`${o.value}`] = 0, _.value[`${o.value}`] = 0) : (p.value = I.clone(le.value), g.value = I.clone(P.value), p.value.forEach((l) => {
      l.key === e && (b.value[`${o.value}`] += Number(l.length) * l.addNumber, _.value[`${o.value}`] += l.oneWeight * l.addNumber);
    }), w.value = w.value.map((l) => (p.value.forEach((a) => {
      a.id === l.id && (l.frozenQuantity = l.frozenQuantity + a.addNumber, l.addNumber = a.addNumber);
    }), l)));
  }
  function Ce(n) {
    n.frozenQuantity += 1, n.addNumber = n.addNumber + 1, b.value[`${o.value}`] = b.value[`${o.value}`] + Number(n.length), _.value[`${o.value}`] = _.value[`${o.value}`] + n.oneWeight, g.value[`${o.value}`] || (g.value[`${o.value}`] = 1), p.value.filter((l) => l.id === n.id).length ? p.value = p.value.map((l) => (l.id === n.id && (l.addNumber += 1), l)) : p.value.push({ ...n, key: `${o.value}` }), le.value = I.clone(p.value), P.value = I.clone(g.value);
  }
  function Ee(n) {
    n.addNumber -= 1, n.frozenQuantity -= 1, b.value[`${o.value}`] = b.value[`${o.value}`] - Number(n.length), _.value[`${o.value}`] -= n.oneWeight, w.value.every((l) => l.addNumber === 0) && (g.value[`${o.value}`] = 0, P.value[`${o.value}`] = 0);
    const e = p.value.map((l) => {
      if (l.id === n.id) if (l.addNumber > 1) l.addNumber -= 1;
      else return null;
      return l;
    });
    p.value = e.filter((l) => l !== null), le.value = I.clone(p.value);
  }
  function Le(n) {
    T.value = true, se.value = L.list.filter((e) => e.specificationAndMaterial === n.specificationAndMaterial).sort((e, l) => l.length - e.length);
  }
  const $e = (n) => {
    ue = Me(n.specification), o.value = n.specificationAndMaterial, E();
  };
  function Ae() {
    O("success", { bindingData: p.value }), J();
  }
  function Te() {
    for (const n in g.value) g.value[n] = 0, b.value[n] = 0, _.value[n] = 0;
    w.value = w.value.map((n) => (p.value.forEach((e) => {
      e.id === n.id && (n.frozenQuantity = n.frozenQuantity - e.addNumber, n.addNumber = 0);
    }), n)), P.value = {}, p.value = [];
  }
  async function E() {
    ae.value = true;
    try {
      const n = await sa({ workshopId: U.value, warehouseId: Y.value, projectId: W.value, specification: Se(o.value), projectWarehouseType: B.value, materialIsWhole: q.value, boolPartyA: Z.value, specNumber: ue, ...Q });
      ke(n.totalElements), w.value = n.content.map((l) => (p.value.forEach((a) => {
        a.id === l.id && (l.frozenQuantity = a.addNumber + l.frozenQuantity, l.addNumber = a.addNumber);
      }), l.oneWeight = Math.round(l.mete / l.quantity), l.originNumber = l.quantity - l.frozenQuantity, l.addNumber = l.addNumber || 0, l)), Array.from(new Set(w.value.map((l) => l.classifyId))).forEach(async (l) => {
        const a = await ra(l);
        w.value.forEach((c) => {
          c.classifyId === l && (c.outboundUnit = a.measureUnit, c.outboundUnitPrecision = a.outboundUnitType, c.outboundUnitType = a.outboundUnitType);
        });
      });
    } catch (n) {
      console.error(n);
    } finally {
      ae.value = false;
    }
  }
  function Ie(n) {
    const e = n.reduce((a, c) => {
      c = { ...c, quantity: Number(c.quantity), weight: c.weight * c.quantity, length: c.length * c.quantity };
      const V = `${c.specificationAndMaterial}`;
      return a[V] ? (a[V].quantity += c.quantity, a[V].weight = parseFloat((a[V].weight + c.weight).toFixed(2)), a[V].length += c.length, a[V].LENGTH += c.LENGTH) : a[V] = { material: c.material, quantity: c.quantity, weight: parseFloat(c.weight.toFixed(2)), LENGTH: c.LENGTH, specificationAndMaterial: c.specificationAndMaterial, specification: c.specification, length: c.length }, a;
    }, {});
    return Object.values(e);
  }
  function Me(n) {
    return n.match(/^[A-Za-z]+/)[0];
  }
  function Se(n) {
    return n.replace(/^[A-Za-z]+/, "").trim();
  }
  return (n, e) => {
    const l = Fe, a = Je, c = A("common-table"), V = Ke, te = A("common-radio-button"), ze = A("project-cascader"), Be = A("common-select"), qe = Ye, je = Ze, Ue = Xe, We = ea, ne = A("common-button"), de = A("table-cell-tag"), Pe = aa, De = A("common-drawer"), He = la;
    return v(), f(De, { title: "钢材绑定", modelValue: i(F), "onUpdate:modelValue": e[11] || (e[11] = (t) => Qe(F) ? F.value = t : null), "show-close": false, "before-close": i(J), "destroy-on-close": "", size: "100%" }, { titleRight: d(() => [u(l, { type: "warning", onClick: Ae, disabled: re.value }, { default: d(() => e[12] || (e[12] = [k(" 下一步 ")])), _: 1, __: [12] }, 8, ["disabled"]), u(l, { type: "info", onClick: i(J) }, { default: d(() => e[13] || (e[13] = [k("取消")])), _: 1, __: [13] }, 8, ["onClick"])]), content: d(() => [j((v(), Ge("div", fa, [s("div", ma, [s("div", null, [s("div", ya, [e[14] || (e[14] = s("span", { style: { "background-color": "#0053ff", color: "#fff", width: "60px", display: "inline-block" } }, "项目", -1)), s("span", null, m(G.list[0].project.serialNumber + G.list[0].project.shortName), 1)])]), T.value ? (v(), f(l, { key: 0, type: "primary", style: { float: "right", "margin-bottom": "10px" }, onClick: e[0] || (e[0] = (t) => T.value = false) }, { default: d(() => e[15] || (e[15] = [k("关闭")])), _: 1, __: [15] })) : y("", true), T.value ? (v(), f(c, { key: 1, "return-source-data": "", data: se.value, "max-height": i(K), "highlight-current-row": "", style: { width: "100%" } }, { default: d(() => [u(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" }), u(a, { key: "specificationAndMaterial", prop: "specificationAndMaterial", "show-overflow-tooltip": true, label: "规格", align: "center" }), u(a, { key: "length", prop: "length", label: "长度", align: "center" }), u(a, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), u(a, { key: "LENGTH", prop: "LENGTH", label: "面积", align: "center" }), u(a, { key: "weight", prop: "weight", label: "重量", align: "center" })]), _: 1 }, 8, ["data", "max-height"])) : y("", true), T.value ? y("", true) : (v(), f(c, { key: 2, "return-source-data": "", data: S.value, "max-height": i(K), "highlight-current-row": "", style: { width: "100%" }, onRowClick: $e }, { default: d(() => [u(a, { label: "序号", type: "index", align: "center", width: "60" }), u(a, { key: "specificationAndMaterial", prop: "specificationAndMaterial", "show-overflow-tooltip": true, label: "规格", width: "120", align: "center" }), u(a, { key: "quantity", prop: "quantity", label: "零件数量（件）", align: "center" }, { default: d(({ row: t }) => [s("span", { style: { color: "#0053ff", cursor: "pointer" }, onClick: Oe((N) => Le(t), ["stop"]) }, m(t.quantity), 9, ha)]), _: 1 }), u(a, { key: "length", prop: "length", label: "长度", align: "center" }), u(a, { key: "weight", prop: "weight", label: "零件重量（kg）", align: "center" }), u(a, { key: "status", prop: "status", label: "绑定状态", align: "center" }, { default: d(({ row: t }) => [x.value[`${t.specificationAndMaterial}`] ? y("", true) : (v(), f(V, { key: 0, type: g.value[`${t.specificationAndMaterial}`] ? "success" : "danger" }, { default: d(() => [k(m(g.value[`${t.specificationAndMaterial}`] ? "已绑定" : "未绑定"), 1)]), _: 2 }, 1032, ["type"])), x.value[`${t.specificationAndMaterial}`] ? (v(), f(V, { key: 1, type: "primary" }, { default: d(() => e[16] || (e[16] = [k("无需绑定")])), _: 1, __: [16] })) : y("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]))]), s("div", ga, [j(u(V, { type: "info" }, { default: d(() => e[17] || (e[17] = [k(" * 点击左边某行可查看物料列表 ")])), _: 1, __: [17] }, 512), [[R, !o.value]]), j(u(We, { shadow: "always" }, { default: d(() => [s("div", null, [u(te, { modelValue: $.value, "onUpdate:modelValue": e[1] || (e[1] = (t) => $.value = t), options: i(h).ENUM, showOptionAll: "", type: "enum", size: "small" }, null, 8, ["modelValue", "options"]), u(te, { modelValue: Z.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => Z.value = t), options: ge, "show-option-all": "", type: "enumSL", size: "small", class: "filter-item", style: { "margin-left": "10px" }, onChange: E }, null, 8, ["modelValue"])]), s("div", ba, [u(ze, { modelValue: W.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => W.value = t), placeholder: "所属项目", style: { width: "270px" }, clearable: "", onChange: E, class: "filter-item" }, null, 8, ["modelValue"]), u(da, { modelValue: U.value, "onUpdate:modelValue": e[4] || (e[4] = (t) => U.value = t), placeholder: "请选择仓库", style: { "margin-left": "10px" }, clearable: "", class: "filter-item", onChange: E }, null, 8, ["modelValue"]), u(ca, { modelValue: Y.value, "onUpdate:modelValue": e[5] || (e[5] = (t) => Y.value = t), workshopId: U.value, placeholder: "存储位置", class: "filter-item", style: { "margin-left": "10px" }, "show-all": "", clearable: "", onChange: E }, null, 8, ["modelValue", "workshopId"])]), s("div", _a, [u(Ue, { "label-width": "auto", style: { "max-width": "800px" } }, { default: d(() => [u(je, { label: "其他规格筛选" }, { default: d(() => [u(Be, { modelValue: o.value, "onUpdate:modelValue": e[6] || (e[6] = (t) => o.value = t), options: ie.value, "data-structure": { key: "name", label: "label", value: "name" }, placeholder: "规格筛选", style: { margin: "0 10px", width: "300px" }, onChange: E }, null, 8, ["modelValue", "options"]), u(qe, { modelValue: x.value[`${o.value}`], "onUpdate:modelValue": e[7] || (e[7] = (t) => x.value[`${o.value}`] = t), label: "无需绑定钢板", onChange: Ve }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), s("div", Na, [s("div", ka, [e[18] || (e[18] = s("span", { style: { "background-color": "#0053ff", color: "#fff", width: "70px" } }, "钢板种类", -1)), s("span", wa, m(X.value) + "种", 1)]), s("div", { class: "title", style: { "margin-left": "10px" }, onClick: e[8] || (e[8] = (t) => ee.value = true) }, [e[19] || (e[19] = s("span", { style: { "background-color": "#16c14e", color: "#fff", width: "70px" } }, "已绑定", -1)), s("span", xa, m(Object.values(g.value).reduce((t, N) => t + N, 0) || 0) + "种", 1)])])])]), _: 1 }, 512), [[R, o.value]]), j(s("div", Va, [s("div", Ca, [u(te, { modelValue: z.value, "onUpdate:modelValue": e[9] || (e[9] = (t) => z.value = t), unshowVal: [i(M).AREA.V], options: i(M).ENUM, type: "enum", size: "small", class: "filter-item" }, null, 8, ["modelValue", "unshowVal", "options"]), u(ne, { style: { "margin-left": "10px" }, size: "small" }, { default: d(() => [s("span", Ea, m(z.value === i(M).LENGTH.V ? `零件长度：${D.value}mm` : `零件重量：${Math.round(H.value)}kg`), 1), e[20] || (e[20] = k(" | ")), s("span", La, m(z.value === i(M).LENGTH.V ? `钢板长度：${b.value[`${o.value}`] || 0}mm` : `钢板重量：${Math.round(_.value[`${o.value}`] / 1e3 || 0)}kg`), 1), e[21] || (e[21] = k(" | ")), s("span", $a, " 吻合度：" + m(z.value === i(M).LENGTH.V ? b.value[`${o.value}`] && D.value ? (b.value[`${o.value}`] / D.value * 100).toFixed(2) : 0 : _.value[`${o.value}`] && H.value ? (_.value[`${o.value}`] / 1e3 / H.value * 100).toFixed(2) : 0) + "% ", 1)]), _: 1, __: [20, 21] })])], 512), [[R, o.value]]), o.value ? (v(), f(i(pa), { key: 0 }, { optLeft: d(() => [me(n.$slots, "optLeft", {}, void 0, true)]), viewLeft: d(() => [me(n.$slots, "viewLeft", {}, void 0, true)]), _: 3 })) : y("", true), j(u(c, { ref_key: "tableRef", ref: oe, "return-source-data": "", data: w.value, "max-height": i(K) - 120, style: { width: "100%" }, id: "steelListTable" }, { default: d(() => [u(a, { label: "序号", type: "index", align: "center", width: "60" }), i(C).visible("classifyName") ? (v(), f(a, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => {
      var N, ce, pe, ve;
      return [t.materialIsWhole === i(h).REMAIN.materialIsWhole ? (v(), f(de, { key: 0, name: i(h).VL[i(h).REMAIN.V], color: (ce = (N = i(h)) == null ? void 0 : N.V[i(h).REMAIN.V]) == null ? void 0 : ce.COLOR, offset: 15 }, null, 8, ["name", "color"])) : (v(), f(de, { key: 1, name: i(h).VL[t.warehouseType], color: (ve = (pe = i(h)) == null ? void 0 : pe.V[t.warehouseType]) == null ? void 0 : ve.COLOR, offset: 15 }, null, 8, ["name", "color"])), s("span", null, m(t.classifyName), 1)];
    }), _: 1 })) : y("", true), i(C).visible("specification") ? (v(), f(a, { key: "specification", prop: "specification", label: "材质", align: "center", "show-overflow-tooltip": true })) : y("", true), i(C).visible("quantity") ? (v(), f(a, { key: "quantity", prop: "quantity", label: "库存（张）", align: "center" }, { default: d(({ row: t }) => [s("span", Aa, m(t.quantity - t.frozenQuantity), 1), e[22] || (e[22] = k(" / ")), s("span", null, m(t.quantity), 1)]), _: 1 })) : y("", true), i(C).visible("mete") ? (v(), f(a, { key: "mete", prop: "mete", label: "重量（kg）", align: "center", "min-width": "120px", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [s("span", Ta, m(Math.round((t.quantity - t.frozenQuantity) * t.oneWeight / 1e3)), 1), e[23] || (e[23] = k(" / ")), s("span", null, m(Math.round(t.mete / 1e3)), 1)]), _: 1 })) : y("", true), i(C).visible("LENGTH") ? (v(), f(a, { key: "LENGTH", prop: "LENGTH", label: "单长", align: "center", "min-width": "100px", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [s("span", null, m(t.length), 1)]), _: 1 })) : y("", true), i(C).visible("brand") ? (v(), f(a, { key: "brand", prop: "brand", label: "品牌", align: "center", "show-overflow-tooltip": true })) : y("", true), i(C).visible("heatNoAndBatchNo") ? (v(), f(a, { key: "heatNoAndBatchNo", prop: "heatNoAndBatchNo", label: "炉批号", align: "center", "show-overflow-tooltip": true })) : y("", true), i(C).visible("projectName") ? (v(), f(a, { key: "projectName", prop: "projectName", label: "所属项目", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => {
      var N;
      return [s("span", null, m(((N = t == null ? void 0 : t.project) == null ? void 0 : N.name) || "-"), 1)];
    }), _: 1 })) : y("", true), i(C).visible("warehouseName") ? (v(), f(a, { key: "warehouseName", prop: "warehouseName", label: "库位", align: "center", "min-width": "100px", "show-overflow-tooltip": true }, { default: d(({ row: t }) => {
      var N;
      return [s("span", null, m((N = t.warehouse) == null ? void 0 : N.name), 1)];
    }), _: 1 })) : y("", true), u(a, { label: "操作", width: "160", align: "center" }, { default: d(({ row: t }) => [u(ne, { type: "success", disabled: t.quantity - t.frozenQuantity < 1 || x.value[`${o.value}`], onClick: (N) => Ce(t) }, { default: d(() => e[24] || (e[24] = [k("添加")])), _: 2, __: [24] }, 1032, ["disabled", "onClick"]), u(ne, { type: "warning", disabled: !t.addNumber || x.value[`${o.value}`], onClick: (N) => Ee(t) }, { default: d(() => e[25] || (e[25] = [k(" 减少 ")])), _: 2, __: [25] }, 1032, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), [[R, o.value]]), o.value ? (v(), f(Pe, { key: 1, total: i(Ne), "current-page": i(Q).pageNumber, "page-size": i(Q).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(be), onCurrentChange: i(_e) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])) : y("", true)])])), [[He, ae.value]]), u(va, { visible: ee.value, "onUpdate:visible": e[10] || (e[10] = (t) => ee.value = t), detailList: p.value, onDelete: Te }, null, 8, ["visible", "detailList"])]), _: 3 }, 8, ["modelValue", "before-close"]);
  };
} }, Ba = ta(Ia, [["__scopeId", "data-v-8d7cfd0c"]]);
export {
  Ba as default
};
