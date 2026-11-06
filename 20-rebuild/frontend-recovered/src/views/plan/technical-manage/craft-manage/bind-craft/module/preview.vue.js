import { computed as b } from "vue";
import { withDirectives as i } from "vue";
import { resolveDirective as a } from "vue";
import { createVNode as l } from "vue";
import { resolveComponent as f } from "vue";
import { ref as u } from "vue";
import { openBlock as G } from "vue";
import { createBlock as Y } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as J } from "vue";
import { unref as g } from "vue";
import { createElementVNode as T } from "vue";
import { normalizeStyle as Q } from "vue";
import { isRef as X } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTag as ee } from "element-plus";
import { ElTableV2 as te } from "element-plus";
import { ElAutoResizer as ae } from "element-plus";
import { l as E, fg as re, aa as le, oG as oe, tE as n, u as ne, o as ie, b as x, _ as de } from "../../../../../../shared/runtime.js";
function ue(s) {
  return E({ module: "plan", url: "CappCraftCardProductLink/list", method: "get", params: s });
}
function R(s) {
  return E({ module: "plan", url: "CappCraftCardProductLink/update", method: "post", data: s });
}
const Ce = { get: ue, save: R }, se = { class: "bind-craft-preview-header" }, ce = { __name: "preview", props: { modelValue: { type: Boolean, require: true }, customClass: { type: String, default: "bind-craft-preview-drawer" }, param: { type: Object, default: () => {
} }, tableData: { type: Array, default: () => [] }, craftList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "success"], setup(s, { emit: B }) {
  const V = B, { projectMap: M, monomerMap: U, areaMap: K } = re(), o = s, A = b(() => {
    var e, r, p, h, y, C;
    return [(r = (e = M.value) == null ? void 0 : e[o.param.projectId]) == null ? void 0 : r.name, (h = (p = U.value) == null ? void 0 : p[o.param.monomerId]) == null ? void 0 : h.name, (C = (y = K.value) == null ? void 0 : y[o.param.areaId]) == null ? void 0 : C.name].join(" > ");
  }), L = b(() => {
    const t = [{ key: "index", dataKey: "index", title: "序号", minWidth: 60, align: "center", cellRenderer: ({ rowIndex: e }) => `${e + 1}` }, { key: "weldSerialNumber", dataKey: "weldSerialNumber", title: "焊缝编号", width: 1e3, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.weldSerialNumber]), [[a("ellipsis")], [a("empty-text")]]) }];
    return o.param.productType === le.ASSEMBLY.V && t.push({ key: "productSerialNumber", dataKey: "productSerialNumber", title: "编号", width: 1e3, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.productSerialNumber]), [[a("ellipsis")], [a("empty-text")]]) }), t.push({ key: "productSpecification", dataKey: "productSpecification", title: "规格", width: 1400, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.productSpecification]), [[a("ellipsis")], [a("empty-text")]]) }, { key: "productLength", dataKey: "productLength", title: "长度(mm)", width: 1e3, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.productLength]), [[a("ellipsis")], [a("empty-text")]]) }, { key: "productMaterial", dataKey: "productMaterial", title: "材质", width: 1e3, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.productMaterial]), [[a("ellipsis")], [a("empty-text")]]) }, { key: "weldCount", dataKey: "weldCount", title: "焊缝数量", width: 1e3, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.weldCount]), [[a("ellipsis")], [a("empty-text")]]) }, { key: "productDwgNum", dataKey: "productDwgNum", title: "图号", width: 1600, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.productDwgNum]), [[a("ellipsis")], [a("empty-text")]]) }, { key: "craftType", dataKey: "craftType", title: "工艺类型", minWidth: 200, align: "center", cellRenderer: ({ rowData: e }) => {
      var r;
      return i(l("div", null, [(r = oe.VL) == null ? void 0 : r[e.craftType]]), [[a("ellipsis")], [a("empty-text")]]);
    } }, { key: "techCappCraftCardStorehouseId", dataKey: "techCappCraftCardStorehouseId", title: "原工艺编号", minWidth: 200, align: "center", cellRenderer: ({ rowData: e }) => i(l("div", null, [e.originalTechCappCraftCardStorehouseSerialNumber]), [[a("ellipsis")], [a("empty-text")]]) }, { key: "techCappCraftCardStorehouseId", dataKey: "techCappCraftCardStorehouseId", title: "新工艺编号", minWidth: 200, align: "center", cellRenderer: ({ rowData: e }) => l(f("common-select"), { modelValue: e.techCappCraftCardStorehouseId, "onUpdate:modelValue": (r) => e.techCappCraftCardStorehouseId = r, options: o.craftList, clearable: true, dataStructure: j.value, placeholder: "工艺编号", style: "width: 100%" }, null) }, { key: "operation", dataKey: "operation", title: "操作", minWidth: 70, align: "center", cellRenderer: ({ rowData: e }) => l(f("common-button"), { icon: "el-icon-delete", size: "default", type: "danger", onClick: () => {
      e.techCappCraftCardStorehouseId = e.originalTechCappCraftCardStorehouseId, e.techCappCraftCardStorehouseSerialNumber = e.originalTechCappCraftCardStorehouseSerialNumber;
    } }, null) }), t;
  }), P = b(() => o.tableData.filter((t) => c.value === w.value ? true : c.value === D(t))), W = b(() => {
    const t = { [n.NEW.V]: 0, [n.UPDATE.V]: 0, [n.UNBIND.V]: 0 };
    return o.tableData.forEach((e) => {
      t[D(e)]++;
    }), [{ name: `全部(${o.tableData.length})`, id: w.value }, { name: `绑定新增(${t[n.NEW.V]})`, id: n.NEW.V }, { name: `绑定更新(${t[n.UPDATE.V]})`, id: n.UPDATE.V }, { name: `解绑(${t[n.UNBIND.V]})`, id: n.UNBIND.V }];
  }), { visible: v, handleClose: _ } = ne({ emit: V, props: o, showHook: H }), I = u(40), k = u(), c = u(), w = u(-1), j = u({ key: "id", label: "serialNumber", value: "id" }), S = u(false), { maxHeight: z, fixMaxHeight: $ } = ie({ mainBox: `.${o.customClass}`, extraBox: [".el-drawer__header", ".bind-craft-preview-header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, k);
  async function H() {
    c.value = w.value, $();
  }
  function D(t) {
    let e;
    return x(t.originalTechCappCraftCardStorehouseId) ? e = n.NEW.V : x(t.techCappCraftCardStorehouseId) ? e = n.UNBIND.V : e = n.UPDATE.V, e;
  }
  async function O() {
    S.value = true;
    try {
      const t = { areaId: o.param.areaId, monomerId: o.param.monomerId, productType: o.param.productType }, e = o.tableData.map((r) => ({ ...t, cappProductUpdateTypeEnum: D(r), id: r.id, productId: r.productId, craftType: r.craftType, weldingSerialNumber: r.weldSerialNumber, productSerialNumber: r.productSerialNumber, techCappCraftCardStorehouseId: r.techCappCraftCardStorehouseId }));
      await R(e), Z.success("绑定成功"), V("success"), _();
    } catch (t) {
      console.log("工艺管理绑定失败", t);
    } finally {
      S.value = false;
    }
  }
  return (t, e) => {
    const r = ee, p = f("common-button"), h = f("common-radio-button"), y = te, C = ae, F = f("common-drawer");
    return G(), Y(F, { title: "绑定工艺卡", "close-on-click-modal": false, modelValue: g(v), "onUpdate:modelValue": e[1] || (e[1] = (m) => X(v) ? v.value = m : null), "before-close": g(_), "custom-class": o.customClass, size: "100%" }, { titleAfter: d(() => [l(r, { effect: "plain" }, { default: d(() => [N(J(A.value), 1)]), _: 1 })]), titleRight: d(() => [l(p, { size: "default", type: "warning", onClick: g(_) }, { default: d(() => e[2] || (e[2] = [N("上一步")])), _: 1, __: [2] }, 8, ["onClick"]), l(p, { loading: S.value, disabled: !o.tableData.length, size: "default", type: "primary", onClick: O }, { default: d(() => e[3] || (e[3] = [N(" 提交 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])]), content: d(() => [T("div", se, [T("div", null, [l(h, { modelValue: c.value, "onUpdate:modelValue": e[0] || (e[0] = (m) => c.value = m), options: W.value }, null, 8, ["modelValue", "options"])])]), l(C, { style: Q({ height: `${g(z)}px` }) }, { default: d(({ width: m, height: q }) => [l(y, { ref_key: "tableRef", ref: k, "row-key": "uuid", data: P.value, "header-height": I.value, "row-height": I.value, columns: L.value, width: m, height: q, class: "table-v2-border" }, null, 8, ["data", "header-height", "row-height", "columns", "width", "height"])]), _: 1 }, 8, ["style"])]), _: 1 }, 8, ["modelValue", "before-close", "custom-class"]);
  };
} };
const pe = de(ce, [["__scopeId", "data-v-bdac7b93"]]), be = Object.freeze(Object.defineProperty({ __proto__: null, default: pe }, Symbol.toStringTag, { value: "Module" }));
export {
  be as a,
  Ce as c,
  ue as g,
  pe as p
};
