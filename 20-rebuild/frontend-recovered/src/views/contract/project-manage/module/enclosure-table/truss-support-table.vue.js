import { ref as y } from "vue";
import { watch as C } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as d } from "vue";
import { createBlock as m } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as k } from "vue";
import { ElTableColumn as D } from "element-plus";
const M = { __name: "truss-support-table", props: { tableData: { type: Array, default: () => [] }, isShow: { type: Boolean, default: true } }, emits: ["edit"], setup(i, { emit: f }) {
  const s = i, u = y([]);
  C(() => s.tableData, (n) => {
    u.value = s.tableData;
  }, { deep: true, immediate: true });
  const b = f;
  function _(n) {
    u.value.splice(n, 1);
  }
  function v(n, p) {
    b("edit", p), u.value.splice(n, 1);
  }
  return (n, p) => {
    const l = D, c = w("common-button"), h = w("common-table");
    return d(), m(h, { data: i.tableData, "return-source-data": "", showEmptySymbol: false, border: "" }, { default: o(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "板型" }, { default: o((e) => [a("span", null, r(e.row.serialNumber), 1)]), _: 1 }), t(l, { prop: "basementMembrane", "show-overflow-tooltip": true, align: "center", label: "底膜(mm)" }, { default: o((e) => [a("span", null, r(e.row.basementMembrane), 1)]), _: 1 }), t(l, { prop: "effectiveWidth", "show-overflow-tooltip": true, align: "center", label: "有效宽度" }, { default: o((e) => [a("span", null, r(e.row.effectiveWidth), 1)]), _: 1 }), t(l, { prop: "firstQuarter", "show-overflow-tooltip": true, align: "center", label: "上弦筋(φ)" }, { default: o((e) => [a("span", null, r(e.row.firstQuarter), 1)]), _: 1 }), t(l, { prop: "lastQuarter", "show-overflow-tooltip": true, align: "center", label: "下弦筋(φ)" }, { default: o((e) => [a("span", null, r(e.row.lastQuarter), 1)]), _: 1 }), t(l, { prop: "webMember", "show-overflow-tooltip": true, align: "center", label: "腹杆筋(φ)" }, { default: o((e) => [a("span", null, r(e.row.webMember), 1)]), _: 1 }), t(l, { prop: "vertical", "show-overflow-tooltip": true, align: "center", label: "竖向筋(φ)" }, { default: o((e) => [a("span", null, r(e.row.vertical), 1)]), _: 1 }), t(l, { prop: "level", "show-overflow-tooltip": true, align: "center", label: "水平筋(φ)" }, { default: o((e) => [a("span", null, r(e.row.level), 1)]), _: 1 }), t(l, { prop: "weightMeter", "show-overflow-tooltip": true, align: "center", label: "米重(kg/m)" }, { default: o((e) => [a("span", null, r(e.row.weightMeter), 1)]), _: 1 }), t(l, { prop: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量(m)" }, { default: o((e) => [a("span", null, r(e.row.quantity), 1)]), _: 1 }), i.isShow ? k("", true) : (d(), m(l, { key: 0, label: "操作", align: "center" }, { default: o((e) => [t(c, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (g) => v(e.$index, e.row) }, null, 8, ["onClick"]), t(c, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (g) => _(e.$index) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data"]);
  };
} };
export {
  M as default
};
