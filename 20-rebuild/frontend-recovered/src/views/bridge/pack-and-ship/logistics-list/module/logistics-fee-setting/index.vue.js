import { ref as b } from "vue";
import { watch as J } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as l } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { withModifiers as X } from "vue";
import { createTextVNode as R } from "vue";
import { createCommentVNode as d } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as p } from "vue";
import { toDisplayString as f } from "vue";
import { createElementBlock as v } from "vue";
import { normalizeClass as Y } from "vue";
import { isRef as Z } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { l as ae, a as ie } from "../../../../../../modules/logistics-list-3b33cbe0.js";
import { g as le } from "../../../../../../modules/base-6bc46ddf.js";
import { _ as re, t as se, u as ne, x as ce, o as de, z as pe, bB as E, bs as I, bn as ue, G as me, an as _e, P as fe } from "../../../../../../shared/runtime.js";
import he from "./module/header.vue.js";
import we from "./module/form.vue.js";
import be from "./module/price-all-detail.vue.js";
const ge = { class: "head-container" }, ye = { class: "project-name" }, ve = { key: 0 }, xe = { key: 1 }, ke = { style: { width: "100%" } }, Ce = { style: { "margin-left": "3px" } }, Te = { key: 0 }, Ve = { key: 1 }, Pe = { __name: "index", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(S, { emit: M }) {
  const { decimalPrecision: V } = se(), P = b(), B = M, x = b(false), u = b({}), m = b([]), D = S, { visible: k, handleClose: H } = ne({ emit: B, props: D, field: "visible" }), g = { get: [], edit: [], add: [], del: [] }, A = { add: true, edit: false, del: false, download: false }, N = b(), { crud: c, columns: h, CRUD: F } = ce({ title: "物流费设置", permission: { ...g }, optShow: { ...A }, crudApi: { ...ae }, queryOnPresenterCreated: false }, N), { maxHeight: z } = de({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, P);
  J(() => D.visible, (r) => {
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
    const o = y("common-button"), i = ee, w = y("table-cell-tag"), L = te, G = y("common-table"), $ = y("common-drawer"), K = j("permission"), Q = j("parse-time"), W = oe;
    return l(), n($, { ref_key: "drawerRef", ref: P, title: "物流费设置", modelValue: e(k), "onUpdate:modelValue": a[1] || (a[1] = (t) => Z(k) ? k.value = t : null), direction: "rtl", "before-close": e(H), size: "50%" }, { titleRight: s(() => [e(c).optShow.add ? T((l(), n(o, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: X(e(c).toAdd, ["stop"]) }, { default: s(() => a[2] || (a[2] = [R(" 新增 ")])), _: 1, __: [2] }, 8, ["onClick"])), [[K, g.add]]) : d("", true)]), content: s(() => [_("div", ge, [p(e(he))]), T((l(), n(G, { ref_key: "tableRef", ref: N, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(z), style: { width: "100%" }, onSortChange: e(c).handleSortChange }, { default: s(() => [p(i, { label: "序号", type: "index", align: "center", width: "60" }), e(h).visible("project.shortName") && !e(c).query.projectId ? (l(), n(i, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", sortable: "custom", "min-width": "200" }, { default: s((t) => [_("span", ye, f(e(pe)(t.row.project)), 1)]), _: 1 })) : d("", true), e(h).visible("supplier") ? (l(), n(i, { key: "supplier", prop: "supplier", "show-overflow-tooltip": true, label: "物流公司", sortable: "custom", "min-width": "140" }, { default: s((t) => {
      var C;
      return [p(w, { show: t.row.boolPersonalEnum, name: "个人", offset: 15 }, null, 8, ["show"]), t.row.boolPersonalEnum ? (l(), v("span", xe, f(t.row.licensePlate), 1)) : (l(), v("span", ve, f(t.row.supplier && ((C = t.row.supplier) == null ? void 0 : C.name)), 1))];
    }), _: 1 })) : d("", true), e(h).visible("price") ? (l(), n(i, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "价格", sortable: "custom", align: "right", "min-width": "150" }, { default: s((t) => [_("div", ke, [_("span", { class: Y(t.row.priceType === e(E).WEIGHT.V ? "blue" : "orange") }, [_("span", null, f(e(I)(t.row.price, e(V).bridge)), 1), _("span", Ce, f(e(E).V[t.row.priceType].unit), 1)], 2), p(L, { style: { cursor: "pointer", "margin-left": "5px" }, onClick: (C) => q(t.row), type: "success" }, { default: s(() => a[3] || (a[3] = [R("ALL")])), _: 2, __: [3] }, 1032, ["onClick"])])]), _: 1 })) : d("", true), e(h).visible("tax") ? (l(), n(i, { key: "tax", prop: "tax", "show-overflow-tooltip": true, sortable: "custom", label: "税率", align: "center", "min-width": "80" }, { default: s((t) => [t.row.tax ? (l(), v("span", Te, f(e(I)(t.row.tax, e(V).bridge)) + "%", 1)) : (l(), v("span", Ve, f(e(ue)("", "/")), 1))]), _: 1 })) : d("", true), e(h).visible("userName") ? (l(), n(i, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "填写人", sortable: "custom", align: "center", "min-width": "90" })) : d("", true), e(h).visible("createTime") ? (l(), n(i, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "创建时间", sortable: "custom", align: "center", "min-width": "90" }, { default: s((t) => [T(_("span", null, null, 512), [[Q, t.row.createTime]])]), _: 1 })) : d("", true), e(me)([...g.edit, ...g.del]) ? (l(), n(i, { key: 6, label: "操作", width: "140px", align: "center", fixed: "right" }, { default: s((t) => [p(e(_e), { data: t.row }, null, 8, ["data"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[W, e(c).loading]]), p(e(fe)), p(e(we)), p(e(be), { modelValue: x.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => x.value = t), detailInfo: u.value }, null, 8, ["modelValue", "detailInfo"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Me = re(Pe, [["__scopeId", "data-v-6db98c6a"]]);
export {
  Me as default
};
