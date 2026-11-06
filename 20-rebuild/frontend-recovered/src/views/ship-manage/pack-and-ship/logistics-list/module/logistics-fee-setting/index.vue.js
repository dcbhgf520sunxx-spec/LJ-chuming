import { ref as b } from "vue";
import { watch as J } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as l } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { withModifiers as X } from "vue";
import { createTextVNode as j } from "vue";
import { createCommentVNode as p } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as d } from "vue";
import { toDisplayString as _ } from "vue";
import { createElementBlock as v } from "vue";
import { normalizeClass as Y } from "vue";
import { isRef as Z } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { l as ae, b as ie } from "../../../../../../modules/logistics-list-4584a3aa.js";
import { g as le } from "../../../../../../modules/base-6bc46ddf.js";
import { _ as re, t as se, u as ne, x as ce, o as pe, z as de, bB as R, bs as E, bn as ue, G as me, an as fe, P as _e } from "../../../../../../shared/runtime.js";
import he from "./module/header.vue.js";
import we from "./module/form.vue.js";
import be from "./module/price-all-detail.vue.js";
const ye = { class: "head-container" }, ge = { class: "project-name" }, ve = { key: 0 }, xe = { key: 1 }, ke = { style: { width: "100%" } }, Ce = { style: { "margin-left": "3px" } }, Te = { key: 0 }, Ve = { key: 1 }, Pe = { __name: "index", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(I, { emit: S }) {
  const { decimalPrecision: M } = se(), V = b(), B = S, x = b(false), u = b({}), m = b([]), P = I, { visible: k, handleClose: H } = ne({ emit: B, props: P, field: "visible" }), y = { get: [], edit: [], add: [], del: [] }, A = { add: true, edit: false, del: false, download: false }, D = b(), { crud: c, columns: h, CRUD: F } = ce({ title: "物流费设置", permission: { ...y }, optShow: { ...A }, crudApi: { ...ae }, queryOnPresenterCreated: false }, D), { maxHeight: z } = pe({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, V);
  J(() => P.visible, (r) => {
    r && (c.toQuery(), O());
  }, { immediate: true });
  async function O() {
    try {
      const r = await le();
      m.value = r.carModels || [];
    } catch (r) {
      console.log("获取车型配置", r);
    }
  }
  async function U(r) {
    try {
      const o = (await ie(r) || {}).content || [];
      if (m.value && m.value.length > 0) for (let i = 0; i < m.value.length; i++) o.length > 0 && o.findIndex((w) => w.carModel === m.value[i]) > -1 ? u.value.list.push(o.find((w) => w.carModel === m.value[i])) : u.value.list.push({ carModel: m.value[i], price: void 0, priceType: u.value.priceType });
      x.value = true;
    } catch (a) {
      console.log("获取物流供应商车型配置", a);
    }
  }
  function q(r) {
    u.value.price = r.price, u.value.priceType = r.priceType, u.value.list = [], U(r.id);
  }
  return F.HOOK.handleRefresh = (r, a) => {
    a.data.content = a.data.content.map((o) => (o.projectId = o.project && o.project.id, o.supplierId = o.supplier && o.supplier.id, o.invoiceTypeEnum = o.invoiceTypeEnum ? Number(o.invoiceTypeEnum) : void 0, o));
  }, (r, a) => {
    const o = g("common-button"), i = ee, w = g("table-cell-tag"), L = te, G = g("common-table"), $ = g("common-drawer"), K = N("permission"), Q = N("parse-time"), W = oe;
    return l(), n($, { ref_key: "drawerRef", ref: V, title: "物流费设置", modelValue: e(k), "onUpdate:modelValue": a[1] || (a[1] = (t) => Z(k) ? k.value = t : null), direction: "rtl", "before-close": e(H), size: "50%" }, { titleRight: s(() => [e(c).optShow.add ? T((l(), n(o, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: X(e(c).toAdd, ["stop"]) }, { default: s(() => a[2] || (a[2] = [j(" 新增 ")])), _: 1, __: [2] }, 8, ["onClick"])), [[K, y.add]]) : p("", true)]), content: s(() => [f("div", ye, [d(e(he))]), T((l(), n(G, { ref_key: "tableRef", ref: D, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(z), style: { width: "100%" }, onSortChange: e(c).handleSortChange }, { default: s(() => [d(i, { label: "序号", type: "index", align: "center", width: "60" }), e(h).visible("project.shortName") && !e(c).query.projectId ? (l(), n(i, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", sortable: "custom", "min-width": "200" }, { default: s((t) => [f("span", ge, _(e(de)(t.row.project)), 1)]), _: 1 })) : p("", true), e(h).visible("supplier") ? (l(), n(i, { key: "supplier", prop: "supplier", "show-overflow-tooltip": true, label: "物流公司", sortable: "custom", "min-width": "140" }, { default: s((t) => {
      var C;
      return [d(w, { show: t.row.boolPersonalEnum, name: "个人", offset: 15 }, null, 8, ["show"]), t.row.boolPersonalEnum ? (l(), v("span", xe, _(t.row.licensePlate), 1)) : (l(), v("span", ve, _(t.row.supplier && ((C = t.row.supplier) == null ? void 0 : C.name)), 1))];
    }), _: 1 })) : p("", true), e(h).visible("price") ? (l(), n(i, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "价格", sortable: "custom", align: "right", "min-width": "150" }, { default: s((t) => [f("div", ke, [f("span", { class: Y(t.row.priceType === e(R).WEIGHT.V ? "blue" : "orange") }, [f("span", null, _(e(E)(t.row.price, e(M).shipment)), 1), f("span", Ce, _(e(R).V[t.row.priceType].unit), 1)], 2), d(L, { style: { cursor: "pointer", "margin-left": "5px" }, onClick: (C) => q(t.row), type: "success" }, { default: s(() => a[3] || (a[3] = [j("ALL")])), _: 2, __: [3] }, 1032, ["onClick"])])]), _: 1 })) : p("", true), e(h).visible("tax") ? (l(), n(i, { key: "tax", prop: "tax", "show-overflow-tooltip": true, sortable: "custom", label: "税率", align: "center", "min-width": "80" }, { default: s((t) => [t.row.tax ? (l(), v("span", Te, _(e(E)(t.row.tax, 2)) + "%", 1)) : (l(), v("span", Ve, _(e(ue)("", "/")), 1))]), _: 1 })) : p("", true), e(h).visible("userName") ? (l(), n(i, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "填写人", sortable: "custom", align: "center", "min-width": "90" })) : p("", true), e(h).visible("createTime") ? (l(), n(i, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "创建时间", sortable: "custom", align: "center", "min-width": "90" }, { default: s((t) => [T(f("span", null, null, 512), [[Q, t.row.createTime]])]), _: 1 })) : p("", true), e(me)([...y.edit, ...y.del]) ? (l(), n(i, { key: 6, label: "操作", width: "140px", align: "center", fixed: "right" }, { default: s((t) => [d(e(fe), { data: t.row }, null, 8, ["data"])]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[W, e(c).loading]]), d(e(_e)), d(e(we)), d(e(be), { modelValue: x.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => x.value = t), detailInfo: u.value }, null, 8, ["modelValue", "detailInfo"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Me = re(Pe, [["__scopeId", "data-v-165bcbff"]]);
export {
  Me as default
};
