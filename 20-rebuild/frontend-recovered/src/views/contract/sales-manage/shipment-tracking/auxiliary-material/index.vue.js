import { ref as u } from "vue";
import { computed as P } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as i } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as a } from "vue";
import { createElementVNode as R } from "vue";
import { toDisplayString as S } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as j } from "element-plus";
import { a as D } from "../../../../../modules/shipment-tracking-bae05d4c.js";
import { Q as T } from "../../../../../modules/contract-9b18cc88.js";
import { t as B, x as H, o as M, P as V } from "../../../../../shared/runtime.js";
import q from "./module/header.vue.js";
const $ = { __name: "index", props: ["rowStyle", "rowClick"], emits: ["resetQuery"], setup(s, { emit: d }) {
  const { decimalPrecision: c } = B(), b = d, f = { add: false, edit: false, del: false, download: false }, m = u(), g = u(), v = P(() => [["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["unitPrice", ["to-thousand", c.value.contract]], ["totalPrice", ["to-thousand", c.value.contract]]]), { crud: l, columns: r, CRUD: y } = H({ title: "配套制品", sort: [], permission: { ...T }, crudApi: { get: D }, optShow: { ...f }, invisibleColumns: ["actualUserName", "supplierName", "cargoSerialNumber", "workshopNames", "accountingUnit", "mete"] }, m), { maxHeight: k } = M({ extraBox: [".common-container", ".auxiliary-material-container"], minHeight: 300, paginate: true });
  return y.HOOK.beforeResetQuery = () => {
    b("resetQuery");
  }, (E, L) => {
    const o = Q, N = w("table-cell-tag"), _ = w("common-table"), x = j;
    return t(), U("div", null, [n(e(q), { ref_key: "headerRef", ref: g, class: "auxiliary-material-container" }, null, 512), C((t(), i(_, { ref_key: "tableRef", ref: m, data: e(l).data, "data-format": v.value, "max-height": e(k), "row-style": s.rowStyle, onRowClick: s.rowClick }, { default: h(() => [n(o, { fixed: "left", label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("project") && !e(l).query.projectId ? (t(), i(o, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", "min-width": "150" })) : a("", true), e(r).visible("monomer.name") ? (t(), i(o, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": "", label: "单体", align: "center", "min-width": "130" })) : a("", true), e(r).visible("area.name") ? (t(), i(o, { key: "area.name", prop: "area.name", "show-overflow-tooltip": "", label: "区域", align: "center", "min-width": "130" })) : a("", true), e(r).visible("name") ? (t(), i(o, { key: "name", prop: "name", "show-overflow-tooltip": "" }, { default: h(({ row: p }) => [p.boolReturn ? (t(), i(N, { key: 0, color: "#f56c6c", name: "退量" })) : a("", true), R("span", null, S(p.name), 1)]), _: 1 })) : a("", true), e(r).visible("specification") ? (t(), i(o, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "140" })) : a("", true), e(r).visible("measureUnit") ? (t(), i(o, { key: "measureUnit", prop: "measureUnit", "show-overflow-tooltip": "", label: "计量单位", align: "center", "min-width": "120" })) : a("", true), e(r).visible("shipQuantity") ? (t(), i(o, { key: "shipQuantity", prop: "shipQuantity", label: "数量", align: "center", "min-width": "110", "show-overflow-tooltip": "" })) : a("", true), e(r).visible("accountingUnit") ? (t(), i(o, { key: "accountingUnit", prop: "accountingUnit", "show-overflow-tooltip": "", label: "核算单位", align: "center", "min-width": "120" })) : a("", true), e(r).visible("mete") ? (t(), i(o, { key: "mete", prop: "mete", "show-overflow-tooltip": "", label: "核算量", align: "center", "min-width": "120" })) : a("", true), e(r).visible("unitPrice") ? (t(), i(o, { key: "unitPrice", prop: "unitPrice", align: "right", "min-width": "120", label: "综合单价" })) : a("", true), e(r).visible("totalPrice") ? (t(), i(o, { key: "totalPrice", prop: "totalPrice", align: "right", "min-width": "120", label: "金额" })) : a("", true), e(r).visible("createTime") ? (t(), i(o, { key: "createTime", prop: "createTime", align: "center", label: "发运日期", width: "100" })) : a("", true), e(r).visible("auditUserName") ? (t(), i(o, { key: "auditUserName", prop: "auditUserName", "show-overflow-tooltip": "", label: "发运人", align: "center", width: "90" })) : a("", true), e(r).visible("userName") ? (t(), i(o, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "装车人", align: "center", width: "140" })) : a("", true), e(r).visible("actualUserName") ? (t(), i(o, { key: "actualUserName", prop: "actualUserName", "show-overflow-tooltip": "", label: "过磅人", align: "center", width: "90" })) : a("", true), e(r).visible("supplierName") ? (t(), i(o, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": "", label: "物流公司", align: "center", "min-width": "120" })) : a("", true), e(r).visible("cargoSerialNumber") ? (t(), i(o, { key: "cargoSerialNumber", prop: "cargoSerialNumber", "show-overflow-tooltip": "", label: "车次/船次", align: "center", width: "110" })) : a("", true), e(r).visible("licensePlate") ? (t(), i(o, { key: "licensePlate", prop: "licensePlate", "show-overflow-tooltip": "", label: "车牌/船牌", align: "center", width: "100" })) : a("", true), e(r).visible("workshopNames") ? (t(), i(o, { key: "workshopNames", prop: "workshopNames", "show-overflow-tooltip": "", label: "生产部门", align: "center", "min-width": "120" })) : a("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "row-style", "onRowClick"])), [[x, e(l).loading]]), n(e(V))]);
  };
} };
export {
  $ as default
};
