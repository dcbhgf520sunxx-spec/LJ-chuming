import { ref as N } from "vue";
import { watch as J } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as I } from "vue";
import { createBlock as V } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as g } from "vue";
import { unref as a } from "vue";
import { withDirectives as Q } from "vue";
import { createElementVNode as h } from "vue";
import { withKeys as X } from "vue";
import { createCommentVNode as M } from "vue";
import { isRef as Y } from "vue";
import { ElTag as Z } from "element-plus";
import { ElInput as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElPagination as ae } from "element-plus";
import { vLoading as oe } from "element-plus";
import { d as le } from "../../../../../../modules/enclosure-product-receive-send-storage-2e87d697.js";
import { _ as ne, u as re, J as ie, o as se, ue, z as pe, p as ce, uj as de, c as v, D as w } from "../../../../../../shared/runtime.js";
const me = { class: "header-div" }, ge = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} }, workshopId: { type: Number }, productType: { type: Number }, dateTime: { type: [String, Array, Number] }, category: { type: Number } }, emits: ["update:modelValue", "success"], setup(k, { emit: P }) {
  const R = P, c = N({ enclosurePlanId: void 0, serialNumber: void 0 }), s = k, { visible: y, handleClose: O } = re({ emit: R, props: s }), { handleSizeChange: U, handleCurrentChange: B, total: D, setTotalPage: j, queryPage: S } = ie({ fetchHook: f });
  J(y, (u) => {
    u && (c.value.areaId = void 0, F(), f());
  });
  const z = N([]), E = N([]), q = N(), x = N(false), { maxHeight: H } = se({ mainBox: ".type-detail", extraBox: [".el-drawer__header", ".header-div"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, y);
  function A(u) {
    const { columns: o, data: p } = u, _ = [];
    return o.forEach((i, b) => {
      if (b === 0) {
        _[b] = "合计";
        return;
      }
      if (i.property === "quantity" || i.property === "inboundQuantity" || i.property === "outboundQuantity" || i.property === "stockQuantity" || i.property === "beginningQuantity") {
        const d = p.map((n) => Number(n[i.property]));
        let t = 0;
        d.every((n) => isNaN(n)) || (t = d.reduce((n, m) => {
          const L = Number(m);
          return isNaN(L) ? n : n + m;
        }, 0)), _[b] = t;
      }
      if (i.property === "totalLength" || i.property === "inboundTotalLength" || i.property === "outboundTotalLength" || i.property === "stockTotalLength" || i.property === "beginningTotalLength") {
        const d = p.map((n) => Number(n[i.property]));
        let t = 0;
        d.every((n) => isNaN(n)) || (t = d.reduce((n, m) => {
          const L = Number(m);
          return isNaN(L) ? n : n + m;
        }, 0)), _[b] = v(t, "mm", "m", w.MES_ENCLOSURE_L__M);
      }
    }), _;
  }
  async function F() {
    var u;
    try {
      const o = await ue((u = s.detailQuery) == null ? void 0 : u.projectId);
      E.value = o || [], E.value = E.value.filter((p) => p.category === s.category);
    } catch (o) {
      console.log("获取围护的批次失败", o);
    }
  }
  async function f() {
    let u = [];
    x.value = true;
    try {
      const { content: o = [], totalElements: p } = await le({ workshopId: s.workshopId, productType: s.productType, category: s.category, ...s.detailQuery, ...c.value, ...S });
      u = o, j(p);
    } catch (o) {
      console.log("明细", o);
    } finally {
      z.value = u, x.value = false;
    }
  }
  function K() {
    c.value = {}, f();
  }
  return (u, o) => {
    const p = Z, _ = T("print-table"), i = T("common-select"), b = ee, d = T("common-button"), t = te, n = T("common-table"), m = ae, L = T("common-drawer"), $ = W("permission"), G = oe;
    return I(), V(L, { ref_key: "drawerRef", ref: q, modelValue: a(y), "onUpdate:modelValue": o[2] || (o[2] = (r) => Y(y) ? y.value = r : null), "before-close": a(O), "close-on-click-modal": false, "custom-class": "type-detail", direction: "rtl", size: "90%", title: "详情" }, { titleAfter: l(() => [e(p, { size: "large" }, { default: l(() => [C(g(`项目：${a(pe)(k.detailInfo.project)}`), 1)]), _: 1 }), e(p, { size: "large" }, { default: l(() => [C(g(`查询日期：${k.dateTime ? a(ce)(k.dateTime, "{y}-{m}") : "-"}`), 1)]), _: 1 })]), titleRight: l(() => [Q(e(_, { params: { ...s.detailQuery, ...c.value, category: s.category, workshopId: s.workshopId, productType: s.productType }, "api-key": "enclosureProductSendReceiveStorageDetail", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[$, k.permission.detailPrint]])]), content: l(() => [h("div", me, [e(i, { modelValue: c.value.enclosurePlanId, "onUpdate:modelValue": o[0] || (o[0] = (r) => c.value.enclosurePlanId = r), dataStructure: { key: "id", label: "name", value: "id" }, options: E.value, class: "filter-item", clearable: "", placeholder: "请选择批次", size: "default", style: { width: "200px", "margin-left": "3px" }, type: "other", onChange: f }, null, 8, ["modelValue", "options"]), e(b, { modelValue: c.value.serialNumber, "onUpdate:modelValue": o[1] || (o[1] = (r) => c.value.serialNumber = r), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "编号搜索", size: "default", style: { width: "200px", "margin-left": "3px" }, onKeyup: X(f, ["enter"]) }, null, 8, ["modelValue"]), e(d, { class: "filter-item", icon: "el-icon-search", size: "default", style: { "margin-left": "10px" }, type: "success", onClick: f }, { default: l(() => o[3] || (o[3] = [C(" 搜索 ")])), _: 1, __: [3] }), e(d, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: K }, { default: l(() => o[4] || (o[4] = [C(" 重置 ")])), _: 1, __: [4] })]), a(y) ? Q((I(), V(n, { key: 0, data: z.value, "max-height": a(H), "summary-method": A, "show-summary": "" }, { default: l(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { key: "enclosurePlanName", align: "center", label: "批次", prop: "enclosurePlanName", "show-overflow-tooltip": "" }), e(t, { key: "serialNumber", align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s.category !== a(de).FOLDING_PIECE.V ? (I(), V(t, { key: "plate", align: "center", label: "板型", prop: "plate", "show-overflow-tooltip": "" })) : M("", true), e(t, { key: "length", align: "center", label: "单长(mm)", prop: "length", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "清单数(件/米)" }, { default: l(() => [e(t, { key: "quantity", align: "center", label: "清单数", prop: "quantity", "show-overflow-tooltip": "" }), e(t, { key: "totalLength", align: "center", label: "总长", prop: "totalLength", "show-overflow-tooltip": "" }, { default: l(({ row: r }) => [h("span", null, g(a(v)(r.totalLength, "mm", "m", a(w).MES_ENCLOSURE_L__M) || 0), 1)]), _: 1 })]), _: 1 }), e(t, { align: "center", label: "期初库存(件/米)" }, { default: l(() => [e(t, { key: "beginningQuantity", align: "center", label: "期初数", prop: "beginningQuantity", "show-overflow-tooltip": "" }), e(t, { key: "beginningTotalLength", align: "center", label: "总长", prop: "beginningTotalLength", "show-overflow-tooltip": "" }, { default: l(({ row: r }) => [h("span", null, g(a(v)(r.beginningTotalLength, "mm", "m", a(w).MES_ENCLOSURE_L__M) || 0), 1)]), _: 1 })]), _: 1 }), e(t, { align: "center", label: "入库(件/米)" }, { default: l(() => [e(t, { key: "inboundQuantity", align: "center", label: "入库数", prop: "inboundQuantity", "show-overflow-tooltip": "" }), e(t, { key: "inboundTotalLength", align: "center", label: "总长", prop: "inboundTotalLength", "show-overflow-tooltip": "" }, { default: l(({ row: r }) => [h("span", null, g(a(v)(r.inboundTotalLength, "mm", "m", a(w).MES_ENCLOSURE_L__M) || 0), 1)]), _: 1 })]), _: 1 }), e(t, { align: "center", label: "出库(件/米)" }, { default: l(() => [e(t, { key: "outboundQuantity", align: "center", label: "出库数", prop: "outboundQuantity", "show-overflow-tooltip": "" }), e(t, { key: "outboundTotalLength", align: "center", label: "总长", prop: "outboundTotalLength", "show-overflow-tooltip": "" }, { default: l(({ row: r }) => [h("span", null, g(a(v)(r.outboundTotalLength, "mm", "m", a(w).MES_ENCLOSURE_L__M) || 0), 1)]), _: 1 })]), _: 1 }), e(t, { align: "center", label: "期末库存(件/米)" }, { default: l(() => [e(t, { key: "stockQuantity", align: "center", label: "期末数", prop: "stockQuantity", "show-overflow-tooltip": "" }), e(t, { key: "stockTotalLength", align: "center", label: "期末量", prop: "stockTotalLength", "show-overflow-tooltip": "" }, { default: l(({ row: r }) => [h("span", null, g(a(v)(r.stockTotalLength, "mm", "m", a(w).MES_ENCLOSURE_L__M) || 0), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[G, x.value]]) : M("", true), e(m, { "current-page": a(S).pageNumber, "page-size": a(S).pageSize, total: a(D), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: a(U), onCurrentChange: a(B) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, be = ne(ge, [["__scopeId", "data-v-3ff892e8"]]);
export {
  be as default
};
