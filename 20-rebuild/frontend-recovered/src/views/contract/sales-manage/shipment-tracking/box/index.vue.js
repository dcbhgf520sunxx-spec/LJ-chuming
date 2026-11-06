import { ref as s } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as i } from "vue";
import { withCtx as w } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as U } from "element-plus";
import { b as S } from "../../../../../modules/shipment-tracking-bae05d4c.js";
import { Q as T } from "../../../../../modules/contract-9b18cc88.js";
import { t as Q, x as j, o as B, br as D, P as H } from "../../../../../shared/runtime.js";
import E from "./module/header.vue.js";
const F = { __name: "index", props: ["rowStyle", "rowClick"], emits: ["resetQuery"], setup(c, { emit: h }) {
  const { decimalPrecision: m } = Q(), b = h, d = { add: false, edit: false, del: false, download: false }, p = s(), f = s(), g = s([["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["unitPrice", ["to-thousand", m.value.contract]], ["totalPrice", ["to-thousand", m.value.contract]]]), { crud: n, columns: a, CRUD: v } = j({ title: "箱体制品", sort: [], permission: { ...T }, crudApi: { get: S }, optShow: { ...d }, invisibleColumns: ["actualUserName", "supplierName", "cargoSerialNumber", "workshopNames"] }, p), { maxHeight: k } = B({ extraBox: [".common-container", ".box-container"], minHeight: 300, paginate: true });
  return v.HOOK.beforeResetQuery = () => {
    b("resetQuery");
  }, (y, q) => {
    const o = R, N = P("common-table"), _ = U;
    return t(), x("div", null, [l(e(E), { ref_key: "headerRef", ref: f, class: "box-container" }, null, 512), C((t(), i(N, { ref_key: "tableRef", ref: p, data: e(n).data, "data-format": g.value, "max-height": e(k), "row-style": c.rowStyle, onRowClick: c.rowClick }, { default: w(() => [l(o, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), e(a).visible("project") && !e(n).query.projectId ? (t(), i(o, { key: "project", align: "center", label: "项目", "min-width": "150", prop: "project", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("monomer.name") ? (t(), i(o, { key: "monomer.name", align: "center", label: "单体", "min-width": "130", prop: "monomer.name", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("area.name") ? (t(), i(o, { key: "area.name", align: "center", label: "区域", "min-width": "130", prop: "area.name", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("name") ? (t(), i(o, { key: "name", align: "center", label: "名称", "min-width": "130", prop: "name", "show-overflow-tooltip": "" }, { default: w(() => {
      var u;
      return [l(D, { offset: 15, show: !!((u = y.row) != null && u.boolExistReturn), color: "#e64242", name: "退货" }, null, 8, ["show"])];
    }), _: 1 })) : r("", true), e(a).visible("serialNumber") ? (t(), i(o, { key: "serialNumber", align: "center", label: "编号", "min-width": "120", prop: "serialNumber", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("specification") ? (t(), i(o, { key: "specification", align: "center", label: "规格", "min-width": "140", prop: "specification", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("material") ? (t(), i(o, { key: "material", align: "center", label: "材质", "min-width": "110", prop: "material", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("totalQuantity") ? (t(), i(o, { key: "totalQuantity", align: "center", label: "数量", "min-width": "70", prop: "totalQuantity", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("weight") ? (t(), i(o, { key: "weight", align: "center", label: "总量(kg)", "min-width": "110", prop: "weight", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("unitPrice") ? (t(), i(o, { key: "unitPrice", align: "right", label: "单价", "min-width": "100", prop: "unitPrice" })) : r("", true), e(a).visible("totalPrice") ? (t(), i(o, { key: "totalPrice", align: "right", label: "金额", "min-width": "100", prop: "totalPrice" })) : r("", true), e(a).visible("createTime") ? (t(), i(o, { key: "createTime", align: "center", label: "发运日期", prop: "createTime", width: "100" })) : r("", true), e(a).visible("auditUserName") ? (t(), i(o, { key: "auditUserName", align: "center", label: "发运人", prop: "auditUserName", "show-overflow-tooltip": "", width: "90" })) : r("", true), e(a).visible("actualUserName") ? (t(), i(o, { key: "actualUserName", align: "center", label: "过磅人", prop: "actualUserName", "show-overflow-tooltip": "", width: "90" })) : r("", true), e(a).visible("supplierName") ? (t(), i(o, { key: "supplierName", align: "center", label: "物流公司", "min-width": "120", prop: "supplierName", "show-overflow-tooltip": "" })) : r("", true), e(a).visible("cargoSerialNumber") ? (t(), i(o, { key: "cargoSerialNumber", prop: "cargoSerialNumber", "show-overflow-tooltip": "", label: "车次/船次", align: "center", width: "110" })) : r("", true), e(a).visible("licensePlate") ? (t(), i(o, { key: "licensePlate", prop: "licensePlate", "show-overflow-tooltip": "", label: "车牌/船牌", align: "center", width: "100" })) : r("", true), e(a).visible("workshopNames") ? (t(), i(o, { key: "workshopNames", align: "center", label: "生产部门", "min-width": "120", prop: "workshopNames", "show-overflow-tooltip": "" })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "row-style", "onRowClick"])), [[_, e(n).loading]]), l(e(H))]);
  };
} };
export {
  F as default
};
