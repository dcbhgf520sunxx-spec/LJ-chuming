// Return physical amounts keep g(32,8) precision independently of display metadata.
function returnPhysicalPrecision(unit = "t") {
  return 8 + Math.max(0, Math.ceil(Math.log10(Number(St(1, unit, Ft.WEIGHT, 8)))));
}
function returnPhysicalRound(value, unit = "t") {
  return Be(value, returnPhysicalPrecision(unit));
}
async function returnPhysicalFormat(data, options = {}, fields) {
  const units = await du(), meteFields = fields && fields.mete || ["mete", "frozenMete"];
  const raw = (Array.isArray(data) ? data : [data]).map((row) => {
    const item = options.prefix ? row[options.prefix] : row;
    const unit = item && units.get(options.accountingUnit || item.accountingUnit);
    return { item, unit, values: Object.fromEntries(meteFields.map((field) => [field, item && item[field]])) };
  });
  const result = await Ut(data, options, fields);
  raw.forEach(({ item, unit, values }) => {
    if (!item || !(item.basicClass & ua) || !unit || unit.type !== Ka.WEIGHT.V) return;
    Object.keys(values).forEach((field) => {
      if (!A(values[field]) || !Number.isFinite(Number(values[field]))) return;
      if (options.toSmallest && returnPhysicalRound(Number(values[field]), unit.symbol) !== Number(values[field])) {
        ot.error("退库重量超出原始克8位精度");
        throw new Error("退库重量超出原始克8位精度");
      }
      item[field] = St(values[field], options.toSmallest ? unit.symbol : Ft.WEIGHT, options.toSmallest ? Ft.WEIGHT : unit.symbol, options.toSmallest ? 8 : returnPhysicalPrecision(unit.symbol), { toNum: options.toNum, showUnit: options.showUnit });
    });
  });
  return result;
}
// The existing input's input mode accepts a real manual amount without normalizing
// an initialized physical model to the display precision. Only the idle text rounds.
const ReturnPhysicalWeightInput = { inheritAttrs: false, props: { modelValue: { type: [Number, String, null] }, precision: { type: Number } }, emits: ["update:modelValue", "change", "focus", "blur"], setup(e, { attrs: o, emit: n }) {
  let focused = false;
  const text = (value) => focused || !A(value) ? value : ji(value, e.precision);
  const number = (value) => A(value) && Number.isFinite(Number(value)) ? Number(value) : void 0;
  return () => s(Iye, ii(o, { mode: "input", modelValue: e.modelValue, precision: void 0, formatter: text, parser: (value) => value, "onUpdate:modelValue": (value) => n("update:modelValue", number(value)), onChange: (value, old) => n("change", number(value), old), onFocus: (event) => {
    focused = true, event.target.value = A(e.modelValue) ? String(e.modelValue) : "", n("focus", event);
  }, onBlur: (event) => {
    focused = false, pt(() => { event.target.value = text(e.modelValue); }), n("blur", event);
  } }));
} };
function J4(e) {
  return W({ module: "wms", url: "return/application/other-material", method: "post", data: e });
}
function X4(e) {
  return W({ module: "wms", url: "return/application/gas", method: "post", data: e });
}
function yue(e) {
  return W({ url: "/api/v2/wms/return/application/outsourcingReturnable", method: "post", data: e });
}
function $4(e) {
  return W({ url: "/api/v2/wms/return/application/steel-other", method: "post", data: e });
}
const rn = { __name: "warehouse-set-columns", props: { list: { type: Array, default: () => [] }, returnDestination: { type: Number, default: void 0 }, warehouseSetType: { type: String, default: void 0 }, warehouseWidth: { type: [String, Number], default: 160 } }, setup(e) {
  const o = e, n = Ee(() => o.list);
  function c(S) {
    if (A(o.warehouseSetType)) {
      if (o.returnDestination === kl.RETURN_TO_PUBLIC_LIBRARY.V) return true;
    } else if (o.returnDestination === kl.RETURN_TO_PUBLIC_LIBRARY.V && S !== 0) return true;
    return false;
  }
  const u = Z([]);
  Dt(() => {
    u.value = o.list;
  });
  const { getNotDittoArr: r, initScopeList: E, handleValueChange: y, getRealVal: b } = Rn("workshopId"), V = Ee(() => r());
  Dt(() => E(u.value || []));
  function M(S, h, T) {
    var _;
    y(S, h), S !== -1 ? T.warehouseId = void 0 : Ae(T.warehouseId) && (T.warehouseId = -1), o.returnDestination === kl.RETURN_TO_PUBLIC_LIBRARY.V && ((_ = n.value) == null || _.forEach((f) => {
      A(f.list[0]) && (f.list[0].workshopId = n.value[0].workshopId);
    }));
  }
  function g(S, h, T) {
    var _;
    o.returnDestination === kl.RETURN_TO_PUBLIC_LIBRARY.V && ((_ = n.value) == null || _.forEach((f, m) => {
      A(f.list) && A(f.list[0]) && (f.list[0].warehouseId = n.value[0].warehouseId);
    }));
  }
  return (S, h) => {
    const T = vt;
    return w(), Q(Qe, null, [s(T, { align: "center", label: "仓库", "min-width": e.warehouseWidth, prop: "workshopId", fixed: "right" }, { default: p(({ row: { sourceRow: _ }, $index: f }) => [s(Ul, { modelValue: _.workshopId, "onUpdate:modelValue": (m) => _.workshopId = m, disabled: c(f), "show-extra": f !== 0, "only-one-default": "", placeholder: "选择仓库", onChange: (m) => M(m, f, _) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra", "onChange"])]), _: 1 }, 8, ["min-width"]), s(T, { align: "center", label: "存储位置", "min-width": e.warehouseWidth, prop: "warehouseId", fixed: "right" }, { default: p(({ row: { sourceRow: _ }, $index: f }) => [s(xs, { modelValue: _.warehouseId, "onUpdate:modelValue": (m) => _.warehouseId = m, "basic-class": _.basicClass, disabled: c(f), "show-extra": !V.value.includes(f), "workshop-id": l(b)(f), placeholder: "存储位置", onChange: (m) => g(m, f, _) }, null, 8, ["modelValue", "onUpdate:modelValue", "basic-class", "disabled", "show-extra", "workshop-id", "onChange"])]), _: 1 }, 8, ["min-width"])], 64);
  };
} }, Tue = Object.freeze(Object.defineProperty({ __proto__: null, default: rn }, Symbol.toStringTag, { value: "Module" }));
function _ue(e) {
  return W({ url: `/api/v2/wms/return/returnable/${e.basicClass}`, method: "get", params: e });
}
const bue = { get: _ue }, Vue = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.warehouse);
  if (n.value || o.dispatch("config/fetchWarehouse"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { warehouse: Ee(() => o.state.config.warehouse), loaded: n };
};
const wue = { style: { "overflow-x": "auto", width: "100%" } }, Sue = { class: "customize-option-item" }, vue = { class: "label" }, Rue = { class: "extra-label" }, Mue = { __name: "warehouse-select", props: { modelValue: { type: [Array, Number, String] }, workshopId: { type: [Array, Number] }, showAll: { type: Boolean, default: false }, showForbidden: { type: Boolean, default: false }, basicClass: { type: Number }, viewsDetail: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择仓库位置" } }, emits: ["change", "update:modelValue", "infoChange"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), { loaded: r, warehouse: E } = Vue(), y = Ee(() => {
    let g = E.value;
    return c.showForbidden || (g = g.filter((S) => S.enabled)), A(c.workshopId) ? Array.isArray(c.workshopId) ? g = g.filter((S) => c.workshopId.includes(S.workshopId)) : g = g.filter((S) => c.workshopId === S.workshopId) : g = c.showAll ? g : [], c.basicClass && (g = g.filter((S) => S.materialType & c.basicClass)), g;
  });
  Ce(y, (g) => {
    V();
  }), Ce(() => c.modelValue, (g) => {
    u.value = g, M();
  }, { immediate: true });
  function b(g) {
    let S = g;
    Ae(S) && (S = void 0);
    const h = !el(S, c.modelValue), T = Ae(S) && Ae(c.modelValue);
    if (h && !T) {
      const _ = y.value.find((f) => f.id === S) || {};
      n("update:modelValue", S), n("infoChange", _), n("change", S);
    }
  }
  function V() {
    M();
  }
  function M() {
    if (!(Ae(y.value) || u.value)) {
      if (c.onlyOneDefault && y.value.length === 1) {
        u.value = y.value[0].value, b(u.value);
        return;
      }
      if (c.default) {
        u.value = y.value[0].value, b(u.value);
        return;
      }
      b(u.value);
    }
  }
  return (g, S) => {
    const h = Ve("common-select-v2"), T = _t("parse-enum");
    return w(), U(h, { modelValue: u.value, "onUpdate:modelValue": S[0] || (S[0] = (_) => u.value = _), clearable: e.clearable, "collapse-tags": e.collapseTags, disabled: e.disabled, loading: !l(r), multiple: e.multiple, options: y.value, placeholder: e.placeholder, size: e.size, filterable: "", onChange: b }, { view: p(({ data: _ }) => [C("div", wue, [C("span", Sue, [C("span", vue, K(_.name), 1), C("span", null, [C("span", Rue, [S[1] || (S[1] = C("span", { class: "title" }, "存储类型：", -1)), qe(C("span", null, null, 512), [[T, { e: l(dt), v: _.materialType, bit: true, split: " | " }]])])])])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "loading", "multiple", "options", "placeholder", "size"]);
  };
} }, Aue = ut(Mue, [["__scopeId", "data-v-f6067e91"]]);
const Nue = { __name: "batch-input", props: { edit: { type: Boolean, default: true }, placeholder: { type: String, default: "炉批号" }, query: { type: Object, default: () => ({}) } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({}), r = Z(false), E = Z([]);
  Dt(() => {
    u.value = c.query;
  });
  function y() {
    n("to-query");
  }
  function b() {
    E.value = Tn((u.value.heatNoAndBatchNo || "").split(/[,，]/)), E.value.length < 9 && (E.value.length = 9), r.value = true;
  }
  function V() {
    r.value = false;
  }
  function M() {
    u.value.heatNoAndBatchNo = Tn(E.value.filter((h) => A(h))).join(","), V(), y();
  }
  function g() {
    E.value.length += 9;
  }
  function S() {
    E.value.length > 9 ? E.value.length -= 9 : E.value.length = 0;
  }
  return (h, T) => {
    const _ = Mt, f = ya, m = ml, R = Ve("common-button"), v = Bn, N = Hn, P = Ve("common-dialog");
    return w(), Q("div", { class: Zt(["batch-input", { "batch-input-edit": c.edit }]) }, [s(_, { modelValue: u.value.heatNoAndBatchNo, "onUpdate:modelValue": T[0] || (T[0] = (L) => u.value.heatNoAndBatchNo = L), modelModifiers: { trim: true }, clearable: "", style: { width: "100%" }, size: "default", placeholder: c.placeholder, onKeyup: $i(y, ["enter"]) }, null, 8, ["modelValue", "placeholder"]), c.edit ? (w(), U(m, { key: 0, class: "batch-input-icon", onClick: b }, { default: p(() => [s(f)]), _: 1 })) : H("", true), s(P, { title: `${c.placeholder}批量填写`, modelValue: r.value, "onUpdate:modelValue": T[1] || (T[1] = (L) => r.value = L), width: "70%", "before-close": V, "show-close": true }, { titleRight: p(() => [s(R, { size: "default", type: "primary", onClick: M }, { default: p(() => T[2] || (T[2] = [Te(" 搜 索 ")])), _: 1, __: [2] }), s(R, { size: "default", type: "success", onClick: g }, { default: p(() => T[3] || (T[3] = [Te(" 新 增 ")])), _: 1, __: [3] }), s(R, { size: "default", type: "danger", onClick: S }, { default: p(() => T[4] || (T[4] = [Te(" 删 除 ")])), _: 1, __: [4] })]), default: p(() => [s(N, { gutter: 10, class: "dialog-input-wrap" }, { default: p(() => [(w(true), Q(Qe, null, ki(E.value, (L, O) => (w(), U(v, { span: 8, key: O }, { default: p(() => [s(_, { modelValue: E.value[O], "onUpdate:modelValue": (x) => E.value[O] = x, modelModifiers: { trim: true }, clearable: "", maxlength: 50, style: { width: "100%", "margin-top": "10px" }, size: "default", placeholder: c.placeholder, onKeyup: $i(M, ["enter"]) }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])]), _: 2 }, 1024))), 128))]), _: 1 })]), _: 1 }, 8, ["title", "modelValue"])], 2);
  };
} }, m2 = ut(Nue, [["__scopeId", "data-v-b1045620"]]), Lue = { __name: "steel-plate", props: { basicClass: { type: Number }, query: { type: Object, default: () => ({}) }, spcLabel: { type: String, default: "规格" }, showBrand: { type: Boolean, default: true }, showHeatNoAndBatchNo: { type: Boolean, default: true } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({});
  Dt(() => {
    u.value = c.query;
  });
  function r() {
    n("to-query");
  }
  return (E, y) => {
    const b = Mt, V = Ve("common-input-number");
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.specification, "onUpdate:modelValue": y[0] || (y[0] = (M) => u.value.specification = M), modelModifiers: { trim: true }, placeholder: e.spcLabel, class: "filter-item", clearable: "", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue", "placeholder"]), s(V, { modelValue: u.value.thickness, "onUpdate:modelValue": y[1] || (y[1] = (M) => u.value.thickness = M), class: "filter-item", clearable: "", mode: "input", placeholder: "实际厚度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), s(V, { modelValue: u.value.theoryThickness, "onUpdate:modelValue": y[2] || (y[2] = (M) => u.value.theoryThickness = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "理论厚度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), s(V, { modelValue: u.value.width, "onUpdate:modelValue": y[3] || (y[3] = (M) => u.value.width = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "宽度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), s(V, { modelValue: u.value.length, "onUpdate:modelValue": y[4] || (y[4] = (M) => u.value.length = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "长度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), e.showBrand ? (w(), U(b, { key: 0, modelValue: u.value.brand, "onUpdate:modelValue": y[5] || (y[5] = (M) => u.value.brand = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])) : H("", true), e.showHeatNoAndBatchNo ? (w(), U(m2, { key: 1, query: c.query, class: "filter-item", placeholder: "炉批号", style: { width: "200px" }, onToQuery: r }, null, 8, ["query"])) : H("", true)], 64);
  };
} }, Iue = { __name: "section-steel", props: { basicClass: { type: Number }, query: { type: Object, default: () => ({}) }, spcLabel: { type: String, default: "规格" }, showHeatNoAndBatchNo: { type: Boolean, default: true } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({});
  Dt(() => {
    u.value = c.query;
  });
  function r() {
    n("to-query");
  }
  return (E, y) => {
    const b = Mt, V = Ve("common-input-number");
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.specification, "onUpdate:modelValue": y[0] || (y[0] = (M) => u.value.specification = M), modelModifiers: { trim: true }, placeholder: e.spcLabel, class: "filter-item", clearable: "", size: "default", style: { width: "200px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue", "placeholder"]), s(V, { modelValue: u.value.length, "onUpdate:modelValue": y[1] || (y[1] = (M) => u.value.length = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "长度", size: "default", style: { width: "200px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), s(b, { modelValue: u.value.brand, "onUpdate:modelValue": y[2] || (y[2] = (M) => u.value.brand = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "200px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), e.showHeatNoAndBatchNo ? (w(), U(m2, { key: 0, query: c.query, class: "filter-item", placeholder: "炉批号", style: { width: "200px" }, onToQuery: r }, null, 8, ["query"])) : H("", true)], 64);
  };
} }, Cue = { __name: "steel-coil", props: { basicClass: { type: Number }, query: { type: Object, default: () => ({}) }, spcLabel: { type: String, default: "规格" }, showBrand: { type: Boolean, default: true }, showHeatNoAndBatchNo: { type: Boolean, default: true }, showCoilMinLength: { type: Boolean, default: true }, showCoilMaxLength: { type: Boolean, default: true } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({});
  Dt(() => {
    u.value = c.query;
  });
  function r() {
    n("to-query");
  }
  return (E, y) => {
    const b = Mt, V = Ve("common-input-number");
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.specification, "onUpdate:modelValue": y[0] || (y[0] = (M) => u.value.specification = M), modelModifiers: { trim: true }, placeholder: e.spcLabel, class: "filter-item", clearable: "", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue", "placeholder"]), s(b, { modelValue: u.value.color, "onUpdate:modelValue": y[1] || (y[1] = (M) => u.value.color = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "颜色", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), s(V, { modelValue: u.value.thickness, "onUpdate:modelValue": y[2] || (y[2] = (M) => u.value.thickness = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "厚度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), s(V, { modelValue: u.value.width, "onUpdate:modelValue": y[3] || (y[3] = (M) => u.value.width = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "宽度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), e.showCoilMinLength ? (w(), U(V, { key: 0, modelValue: u.value.minLength, "onUpdate:modelValue": y[4] || (y[4] = (M) => u.value.minLength = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "最小长度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])) : H("", true), e.showCoilMaxLength ? (w(), U(V, { key: 1, modelValue: u.value.maxLength, "onUpdate:modelValue": y[5] || (y[5] = (M) => u.value.maxLength = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", mode: "input", placeholder: "最大长度", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])) : H("", true), e.showBrand ? (w(), U(b, { key: 2, modelValue: u.value.brand, "onUpdate:modelValue": y[6] || (y[6] = (M) => u.value.brand = M), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "130px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])) : H("", true), e.showHeatNoAndBatchNo ? (w(), U(m2, { key: 3, query: c.query, class: "filter-item", placeholder: "卷号", style: { width: "200px" }, onToQuery: r }, null, 8, ["query"])) : H("", true)], 64);
  };
} }, Hb = { __name: "aux-mat", props: { basicClass: { type: Number }, query: { type: Object, default: () => ({}) }, spcLabel: { type: String, default: "规格" }, showBrand: { type: Boolean, default: true } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({});
  Dt(() => {
    u.value = c.query;
  });
  function r() {
    n("to-query");
  }
  return (E, y) => {
    const b = Mt;
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.specification, "onUpdate:modelValue": y[0] || (y[0] = (V) => u.value.specification = V), modelModifiers: { trim: true }, placeholder: e.spcLabel, class: "filter-item", clearable: "", size: "default", style: { width: "230px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue", "placeholder"]), s(b, { modelValue: u.value.color, "onUpdate:modelValue": y[1] || (y[1] = (V) => u.value.color = V), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "颜色", size: "default", style: { width: "150px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), e.showBrand ? (w(), U(b, { key: 0, modelValue: u.value.brand, "onUpdate:modelValue": y[2] || (y[2] = (V) => u.value.brand = V), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "150px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])) : H("", true)], 64);
  };
} }, Pue = { __name: "gas", props: { basicClass: { type: Number }, query: { type: Object, default: () => ({}) }, spcLabel: { type: String, default: "规格" }, showBrand: { type: Boolean, default: true } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({});
  Dt(() => {
    u.value = c.query;
  });
  function r() {
    n("to-query");
  }
  return (E, y) => {
    const b = Mt;
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.specification, "onUpdate:modelValue": y[0] || (y[0] = (V) => u.value.specification = V), modelModifiers: { trim: true }, placeholder: e.spcLabel, class: "filter-item", clearable: "", size: "default", style: { width: "230px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue", "placeholder"]), e.showBrand ? (w(), U(b, { key: 0, modelValue: u.value.brand, "onUpdate:modelValue": y[1] || (y[1] = (V) => u.value.brand = V), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "150px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])) : H("", true)], 64);
  };
} }, qb = { __name: "raw-mat", props: { basicClass: { type: Number }, query: { type: Object, default: () => ({}) }, spcLabel: { type: String, default: "规格" }, showBrand: { type: Boolean, default: true } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({});
  Dt(() => {
    u.value = c.query;
  });
  function r() {
    n("to-query");
  }
  return (E, y) => {
    const b = Mt;
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.specification, "onUpdate:modelValue": y[0] || (y[0] = (V) => u.value.specification = V), modelModifiers: { trim: true }, placeholder: e.spcLabel, class: "filter-item", clearable: "", size: "default", style: { width: "230px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue", "placeholder"]), e.showBrand ? (w(), U(b, { key: 0, modelValue: u.value.brand, "onUpdate:modelValue": y[1] || (y[1] = (V) => u.value.brand = V), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "品牌", size: "default", style: { width: "150px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])) : H("", true)], 64);
  };
} }, Oue = { __name: "manuf-mat", props: { basicClass: { type: Number }, query: { type: Object, default: () => ({}) } }, emits: ["to-query"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({});
  Dt(() => {
    u.value = c.query;
  });
  function r() {
    n("to-query");
  }
  return (E, y) => {
    const b = Mt;
    return w(), Q(Qe, null, [s(b, { modelValue: u.value.specification, "onUpdate:modelValue": y[0] || (y[0] = (V) => u.value.specification = V), modelModifiers: { trim: true }, clearable: "", size: "default", placeholder: "规格", class: "filter-item", style: { width: "250px" }, onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"]), s(b, { modelValue: u.value.length, "onUpdate:modelValue": y[1] || (y[1] = (V) => u.value.length = V), modelModifiers: { trim: true }, clearable: "", style: { width: "150px" }, size: "default", placeholder: "长度", class: "filter-item", onKeyup: $i(r, ["enter"]) }, null, 8, ["modelValue"])], 64);
  };
} }, kue = { class: "first-line flex-rbc" }, Due = { class: "child-mr-6" }, xue = { __name: "index", props: { basicClass: { type: Number }, showBasicClassQuery: { type: Boolean, default: true }, query: { type: Object, default: () => ({}) }, toQuery: { type: Function }, showProjectWarehouseType: { type: Boolean, default: false }, showMaterialIsWhole: { type: Boolean, default: true }, showWarehouse: { type: Boolean, default: true }, multiple: { type: Boolean, default: false }, spcLabel: { type: String, default: "规格" }, mesWorkshop: { type: Boolean, default: false }, showBrand: { type: Boolean, default: true }, showHeatNoAndBatchNo: { type: Boolean, default: true }, showMaterial: { type: Boolean, default: true }, showCoilMinLength: { type: Boolean, default: true }, showCoilMaxLength: { type: Boolean, default: true }, showTypeOptionAll: { type: Boolean, default: false } }, emits: ["to-query", "searchQuery"], setup(e, { emit: o }) {
  const n = o, c = e, u = Ee(() => {
    if (c.basicClass & ho) return Oue;
    if (!c.showBasicClassQuery) return qb;
    switch (c.basicClass) {
      case dt.STEEL_PLATE.V:
        return Lue;
      case dt.SECTION_STEEL.V:
        return Iue;
      case dt.STEEL_COIL.V:
        return Cue;
      case dt.MATERIAL.V:
        return Hb;
      case dt.GAS.V:
        return Pue;
      case Ci.OTHER.V:
        return Hb;
      default:
        return qb;
    }
  }), r = Z({});
  Dt(() => {
    r.value = c.query;
  });
  function E() {
    typeof c.toQuery == "function" && c.toQuery(), n("to-query");
  }
  function y(b) {
    n("searchQuery"), b === Do.PUBLIC.V && (r.value.projectId = void 0), E();
  }
  return (b, V) => {
    const M = Ve("common-radio-button");
    return w(), Q(Qe, null, [C("div", kue, [C("span", Due, [xt(b.$slots, "firstItem"), e.showProjectWarehouseType ? (w(), Q(Qe, { key: 0 }, [s(M, { modelValue: r.value.projectWarehouseType, "onUpdate:modelValue": V[0] || (V[0] = (g) => r.value.projectWarehouseType = g), options: l(Do).ENUM, "show-option-all": e.showTypeOptionAll, default: !e.showTypeOptionAll, class: "filter-item", size: "default", type: "enum", onChange: y }, null, 8, ["modelValue", "options", "show-option-all", "default"]), r.value.projectWarehouseType === l(Do).PROJECT.V ? (w(), U(ca, { key: 0, modelValue: r.value.projectId, "onUpdate:modelValue": V[1] || (V[1] = (g) => r.value.projectId = g), class: "filter-item", clearable: "", isAll: "", placeholder: "所属项目", style: { width: "300px" }, onChange: E }, null, 8, ["modelValue"])) : H("", true)], 64)) : H("", true), xt(b.$slots, "afterProjectWarehouseType"), e.showMaterialIsWhole && [l(dt).STEEL_PLATE.V, l(dt).SECTION_STEEL.V].includes(e.basicClass) && !r.value.boolReturn ? (w(), U(M, { key: 1, modelValue: r.value.materialIsWhole, "onUpdate:modelValue": V[2] || (V[2] = (g) => r.value.materialIsWhole = g), options: l(Dl).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: E }, { prefix: p(({ item: g }) => [xt(b.$slots, "materialIsWholePrefix", { item: g })]), _: 3 }, 8, ["modelValue", "options"])) : H("", true), xt(b.$slots, "beforeWarehouse"), e.showWarehouse ? (w(), U(Aue, { key: 2, modelValue: r.value.warehouseId, "onUpdate:modelValue": V[3] || (V[3] = (g) => r.value.warehouseId = g), "basic-class": c.basicClass, "workshop-id": c.mesWorkshop ? null : r.value.workshopId, class: "filter-item", clearable: "", placeholder: "存储位置", "show-all": "", onChange: E }, null, 8, ["modelValue", "basic-class", "workshop-id"])) : H("", true), xt(b.$slots, "afterWarehouse")]), C("span", null, [xt(b.$slots, "firstLineRight")])]), xt(b.$slots, "secondLineFirstItem", { class: "child-mr-6" }), !(c.basicClass & l(ho)) && e.showMaterial ? (w(), U(Ql, { key: 0, modelValue: r.value.classifyId, "onUpdate:modelValue": V[4] || (V[4] = (g) => r.value.classifyId = g), "basic-class": c.basicClass, multiple: c.multiple, "check-strictly": "", class: "filter-item", clearable: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "300px" }, onChange: E }, null, 8, ["modelValue", "basic-class", "multiple"])) : H("", true), (w(), U(Ri(u.value), { "basic-class": c.basicClass, query: e.query, showBrand: c.showBrand, showCoilMaxLength: c.showCoilMaxLength, showCoilMinLength: c.showCoilMinLength, showHeatNoAndBatchNo: c.showHeatNoAndBatchNo, spcLabel: c.spcLabel, onToQuery: E }, null, 40, ["basic-class", "query", "showBrand", "showCoilMaxLength", "showCoilMinLength", "showHeatNoAndBatchNo", "spcLabel"])), xt(b.$slots, "secondLineLastItem")], 64);
  };
} };
const Uue = { class: "head-container" }, Yue = { key: 0 }, Kue = { __name: "header", emits: ["outboundTypeChange", "returnChange"], setup(e, { emit: o }) {
  const n = Z([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = ft("isComponent"), u = ft("basicClass"), r = o, E = { boolReturn: { value: Qr.N.V, resetAble: false }, createTime: [], outboundTypeSelection: { value: Jt.PRODUCE.V, resetAble: false }, basicClass: { value: u, resetAble: false } }, { crud: y, query: b } = f_(E), V = Z([]);
  async function M() {
    if (b.areaBatchId = void 0, V.value = [], !b.projectId) return;
    const T = await rd({ projectId: b.projectId });
    V.value = T || [], y.toQuery();
  }
  async function g(T) {
    await y.resetQuery(), y.data = [], y.setColumns();
  }
  function S(T) {
    y.toQuery(), r("outboundTypeChange", y.query.outboundTypeSelection);
  }
  async function h() {
    r("returnChange"), y.data = [], y.toQuery();
  }
  return (T, _) => {
    const f = Ve("common-radio-button"), m = wi, R = Ve("common-select-v2"), v = Rl;
    return w(), Q("div", Uue, [l(y).searchToggle ? (w(), Q("div", Yue, [s(f, { modelValue: l(b).outboundTypeSelection, "onUpdate:modelValue": _[0] || (_[0] = (N) => l(b).outboundTypeSelection = N), options: [l(Jt).PRODUCE, l(Jt).CONSTRUCTION_SITE_USE], class: "filter-item", size: "default", type: "enum", onChange: S }, null, 8, ["modelValue", "options"]), s(xue, { "basic-class": l(b).basicClass, query: l(b), "to-query": l(y).toQuery }, { firstItem: p(() => [s(m, { class: "filter-item", effect: "plain", size: "large" }, { default: p(() => _[8] || (_[8] = [Te("出库材料信息")])), _: 1, __: [8] }), l(c) && [l(dt).STEEL_PLATE.V, l(dt).SECTION_STEEL.V].includes(l(b).basicClass) ? (w(), U(f, { key: 0, modelValue: l(b).boolReturn, "onUpdate:modelValue": _[1] || (_[1] = (N) => l(b).boolReturn = N), options: l(Qr).ENUM, class: "filter-item", size: "default", type: "enum", onChange: h }, null, 8, ["modelValue", "options"])) : H("", true)]), materialIsWholePrefix: p(() => _[9] || (_[9] = [C("span", null, "出库", -1)])), afterProjectWarehouseType: p(() => [l(c) ? H("", true) : (w(), U(f, { key: 0, modelValue: l(b).basicClass, "onUpdate:modelValue": _[2] || (_[2] = (N) => l(b).basicClass = N), options: l(dt).ENUM, class: "filter-item", size: "default", type: "enum", onChange: g }, null, 8, ["modelValue", "options"]))]), beforeWarehouse: p(() => [s(l(ca), { modelValue: l(b).projectId, "onUpdate:modelValue": _[3] || (_[3] = (N) => l(b).projectId = N), class: "filter-item", clearable: "", isAll: "", placeholder: "所属项目", style: { width: "260px" }, onChange: M }, null, 8, ["modelValue"]), s(R, { modelValue: l(b).areaBatchId, "onUpdate:modelValue": _[4] || (_[4] = (N) => l(b).areaBatchId = N), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !l(b).projectId, options: V.value, class: "filter-item", clearable: "", collapseTags: "", filterable: "", placeholder: "批次", size: "default", style: { width: "200px" }, onChange: l(y).toQuery }, null, 8, ["modelValue", "disabled", "options", "onChange"])]), afterWarehouse: p(() => [s(v, { modelValue: l(b).createTime, "onUpdate:modelValue": _[5] || (_[5] = (N) => l(b).createTime = N), "default-time": n.value, shortcuts: l(k1), class: "filter-item", "end-placeholder": "出库结束日期", "range-separator": ":", size: "default", "start-placeholder": "出库开始日期", style: { width: "270px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: l(y).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(Ds, { modelValue: l(b).recipientId, "onUpdate:modelValue": _[6] || (_[6] = (N) => l(b).recipientId = N), "collapse-tags": false, class: "filter-item", clearable: "", filterable: "", placeholder: "领用人", style: { width: "200px" }, onChange: l(y).toQuery }, null, 8, ["modelValue", "onChange"]), s(l(pu), { modelValue: l(b).workshopId, "onUpdate:modelValue": _[7] || (_[7] = (N) => l(b).workshopId = N), class: "filter-item", clearable: "", placeholder: "领用车间", style: { width: "200px" }, onChange: l(y).toQuery }, null, 8, ["modelValue", "onChange"])]), secondLineFirstItem: p(() => [s(m, { class: "filter-item", effect: "plain", size: "large", type: "warning" }, { default: p(() => _[10] || (_[10] = [Te("退库材料信息")])), _: 1, __: [10] })]), _: 1 }, 8, ["basic-class", "query", "to-query"]), s(l(b_))])) : H("", true), s(l(vS), null, { optLeft: p(() => _[11] || (_[11] = [C("span", { class: "tip" }, "* 可在上方填写需要退库的材料信息，将匹配与该材料信息相符的退库列表", -1)])), _: 1 })]);
  };
} }, e8 = ut(Kue, [["__scopeId", "data-v-32a89cee"]]), Wue = Object.freeze(Object.defineProperty({ __proto__: null, default: e8 }, Symbol.toStringTag, { value: "Module" })), jue = { key: 0 }, Fue = { key: 1 }, zue = { class: "color-green" }, Bue = { class: "color-green" }, Hue = { class: "color-green" }, que = { class: "color-green" }, Gue = { class: "color-green" }, Que = { key: 1 }, Zue = { class: "color-green" }, Gb = { __name: "raw-mat", props: { basicClass: { type: Number }, showUnitNet: { type: Boolean, default: false }, showUnit: { type: Boolean, default: true }, showMeasureUnit: { type: Boolean, default: true }, showQuantity: { type: Boolean, default: true }, showSteelUnit: { type: Boolean, default: false }, fixed: { type: String }, columns: { type: Object }, singleMeteMode: { type: Boolean, default: false }, meteLabel: { type: String }, labelPrefix: { type: String }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, operableQuantityField: { type: String, default: "operableQuantity" }, operableMeteField: { type: String, default: "operableMete" }, showOperableQuantity: { type: Boolean, default: true }, showOperableMete: { type: Boolean, default: true }, equalDisabled: { type: Boolean, default: false }, rejectTypeMode: { type: Boolean, default: false }, outboundTypeMode: { type: Boolean, default: false }, showNumber: { type: Boolean, default: true }, numberPropField: { type: String, default: "quantity" } }, setup(e) {
  const o = e, { loaded: n, baseUnit: c } = ai(), u = Ee(() => o.basicClass ? n.value ? c.value[o.basicClass] || {} : vi[o.basicClass] || {} : {}), r = Ee(() => {
    let f = "";
    switch (o.meteLabel && (f = o.meteLabel), o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
        f = o.singleMeteMode ? `单重(${u.value.weight.unit})` : `重量(${u.value.weight.unit})`;
        break;
      case dt.STEEL_COIL.V:
        f = `重量(${u.value.weight.unit})`;
        break;
      case ua:
        f = o.singleMeteMode ? `单重(${u.value.weight.unit})` : `重量(${u.value.weight.unit})`;
        break;
      case dt.MATERIAL.V:
      case dt.GAS.V:
      default:
        f = o.singleMeteMode ? "单件量" : "核算量";
        break;
    }
    return o.showOperableMete && A(o.labelPrefix) && (f = o.labelPrefix + " / " + f), f;
  }), E = Ee(() => {
    let f = "";
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
        f = `数量(${u.value.measure.unit})`;
        break;
      case dt.SECTION_STEEL.V:
        f = `数量(${u.value.measure.unit})`;
        break;
      case dt.STEEL_COIL.V:
        f = `长度(${u.value.measure.unit})`;
        break;
      case ua:
        f = "数量";
        break;
      case dt.MATERIAL.V:
      case dt.GAS.V:
      default:
        f = "数量";
        break;
    }
    return o.showOperableQuantity && A(o.labelPrefix) && (f = o.labelPrefix + " / " + f), f;
  }), y = Ee(() => o.basicClass & ua ? o.showSteelUnit && o.showUnit : o.showUnit), b = Ee(() => o.showMeasureUnit && y.value && (Ae(o.columns) || o.columns.visible("measureUnit"))), V = Ee(() => y.value && (Ae(o.columns) || o.columns.visible("accountingUnit"))), M = Ee(() => o.showQuantity && (Ae(o.columns) || o.columns.visible("quantity"))), g = Ee(() => Ae(o.columns) || o.columns.visible("mete")), S = Ee(() => Ae(o.columns) || o.columns.visible("outboundUnit")), h = Ee(() => Ae(o.columns) || o.columns.visible("rejectUnit")), T = Ee(() => o.showNumber && (Ae(o.columns) || o.columns.visible(o.numberPropField))), _ = Ee(() => o.showUnitNet && (Ae(o.columns) || o.columns.visible(o.unitNet)));
  return (f, m) => {
    const R = vt;
    return w(), Q(Qe, null, [_.value ? (w(), U(R, { key: "unitNet", prop: "unitNet", label: "单位净量", align: "center", width: "110px", fixed: e.fixed, "show-overflow-tooltip": "" }, { default: p(({ row: v }) => [v.sourceRow.measureUnit ? (w(), Q("span", jue, K(v.unitNet) + " " + K(v.outboundUnitType === l(hi).MEASURE.V ? `${v.accountingUnit} / ${v.measureUnit}` : `${v.measureUnit} / ${v.accountingUnit}`), 1)) : (w(), Q("span", Fue, "-"))]), _: 1 }, 8, ["fixed"])) : H("", true), e.outboundTypeMode ? (w(), Q(Qe, { key: 1 }, [S.value ? (w(), U(R, { key: "rejectUnit", prop: "rejectUnit", label: "单位", align: "center", width: "70px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), T.value ? (w(), U(R, { key: e.numberPropField, prop: e.numberPropField, label: "可操作数量/数量", align: "right", fixed: e.fixed, "show-overflow-tooltip": "", "min-width": e.equalDisabled ? "70px" : "150px" }, { default: p(({ row: v }) => [v.outboundUnitType === l(hi).MEASURE.V ? (w(), Q(Qe, { key: 0 }, [!e.equalDisabled || v[e.operableQuantityField] != v[e.quantityField] ? (w(), Q(Qe, { key: 0 }, [C("span", zue, K(v[e.operableQuantityField]), 1), m[0] || (m[0] = Te(" / "))], 64)) : H("", true)], 64)) : H("", true), v.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), Q(Qe, { key: 1 }, [!e.equalDisabled || v[e.operableMeteField] != v[e.meteField] ? (w(), Q(Qe, { key: 0 }, [C("span", Bue, K(v[e.operableMeteField]), 1), m[1] || (m[1] = Te(" / "))], 64)) : H("", true)], 64)) : H("", true), C("span", null, K(v.outboundUnitType === l(hi).MEASURE.V ? v[e.quantityField] : v[e.meteField]), 1)]), _: 1 }, 8, ["prop", "fixed", "min-width"])) : H("", true)], 64)) : e.rejectTypeMode ? (w(), Q(Qe, { key: 2 }, [h.value ? (w(), U(R, { key: "rejectUnit", prop: "rejectUnit", label: "单位", align: "center", width: "70px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), T.value ? (w(), U(R, { key: e.numberPropField, prop: e.numberPropField, label: "可操作数量/数量", align: "right", fixed: e.fixed, "show-overflow-tooltip": "", "min-width": e.equalDisabled ? "70px" : "150px" }, { default: p(({ row: v }) => [v.rejectUnitType === l(hi).MEASURE.V ? (w(), Q(Qe, { key: 0 }, [!e.equalDisabled || v[e.operableQuantityField] != v[e.quantityField] ? (w(), Q(Qe, { key: 0 }, [C("span", Hue, K(v[e.operableQuantityField]), 1), m[2] || (m[2] = Te(" / "))], 64)) : H("", true)], 64)) : H("", true), v.rejectUnitType === l(hi).ACCOUNTING.V ? (w(), Q(Qe, { key: 1 }, [!e.equalDisabled || v[e.operableMeteField] != v[e.meteField] ? (w(), Q(Qe, { key: 0 }, [C("span", que, K(v[e.operableMeteField]), 1), m[3] || (m[3] = Te(" / "))], 64)) : H("", true)], 64)) : H("", true), C("span", null, K(v.rejectUnitType === l(hi).MEASURE.V ? v[e.quantityField] : v[e.meteField]), 1)]), _: 1 }, 8, ["prop", "fixed", "min-width"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 3 }, [b.value ? (w(), U(R, { prop: "measureUnit", key: "measureUnit", label: "计量单位", align: "center", width: "70px", "show-overflow-tooltip": "" })) : H("", true), M.value ? (w(), U(R, { key: "quantity", prop: "quantity", label: E.value, "show-overflow-tooltip": "", align: "right", "min-width": e.showOperableQuantity ? "150px" : "70px" }, { default: p(({ row: v }) => {
      var N;
      return [(N = v.sourceRow) != null && N.measureUnit ? (w(), Q(Qe, { key: 0 }, [e.showOperableQuantity && (!e.equalDisabled || v[e.operableQuantityField] != v[e.quantityField]) ? (w(), Q(Qe, { key: 0 }, [C("span", Gue, K(v[e.operableQuantityField]), 1), m[4] || (m[4] = Te(" / "))], 64)) : H("", true), Te(" " + K(v[e.quantityField]), 1)], 64)) : (w(), Q("span", Que, "-"))];
    }), _: 1 }, 8, ["label", "min-width"])) : H("", true), V.value ? (w(), U(R, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "70px", "show-overflow-tooltip": "" })) : H("", true), g.value ? (w(), U(R, { key: "mete", prop: "mete", label: r.value, align: "right", "min-width": "150px", "show-overflow-tooltip": "" }, { default: p(({ row: v }) => [e.showOperableMete && (!e.equalDisabled || v[e.operableMeteField] != v[e.meteField]) ? (w(), Q(Qe, { key: 0 }, [C("span", Zue, K(v[e.operableMeteField]), 1), m[5] || (m[5] = Te(" / "))], 64)) : H("", true), Te(" " + K(v[e.meteField]), 1)]), _: 1 }, 8, ["label"])) : H("", true)], 64))], 64);
  };
} }, Jue = { __name: "index", props: { basicClass: { type: Number }, showUnit: { type: Boolean, default: true }, columns: { type: Object }, singleMeteMode: { type: Boolean, default: false }, meteLabel: { type: String }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, operableQuantityField: { type: String, default: "operableQuantity" }, operableMeteField: { type: String, default: "operableMete" }, showOperableQuantity: { type: Boolean, default: true }, equalDisabled: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return Gb;
      default:
        return Gb;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), ii(c.$attrs, { columns: e.columns, "basic-class": e.basicClass, showUnit: e.showUnit, "mete-field": e.meteField, "quantity-field": e.quantityField, "operable-quantity-field": e.operableQuantityField, "operable-mete-field": e.operableMeteField, "show-operable-quantity": e.showOperableQuantity, "single-mete-mode": e.singleMeteMode, "equal-disabled": e.equalDisabled }), null, 16, ["columns", "basic-class", "showUnit", "mete-field", "quantity-field", "operable-quantity-field", "operable-mete-field", "show-operable-quantity", "single-mete-mode", "equal-disabled"]));
} };
const Xue = { class: "color-green" }, $ue = { __name: "index", props: { edit: { type: Boolean, default: false }, sourceReturnIds: { type: Array, default: () => [] }, basicClass: { type: Number, default: dt.STEEL_PLATE.V }, selectList: { type: Array, default: () => [] }, isComponent: { type: Boolean, default: false }, returnDestination: { type: Number, default: void 0 } }, emits: ["add", "returnChange", "outboundTypeChange"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e;
  yi("isComponent", u.isComponent), yi("basicClass", u.basicClass);
  const r = Ee(() => _.query.boolReturn), E = { batchAdd: false, add: false, edit: false, del: false, download: false }, y = Z([]), b = Z({}), V = Z({}), M = Z({}), g = Z(1), S = Z(), h = [["quantity", ["to-fixed-field", "measurePrecision"]], ["singleMete", ["to-fixed-field", "accountingPrecision"]], ["singleReturnableMete", ["to-fixed-field", "accountingPrecision"]], ["project", ["parse-project", { onlyShortName: true }]], ["createTime", ["parse-time", "{y}-{m}-{d}"]]], { CRUD: T, crud: _, columns: f } = cu({ title: "可退库列表", sort: ["id.desc"], invisibleColumns: ["outboundSN"], permission: { ...VD }, optShow: { ...E }, crudApi: { ...bue } }, S), { maxHeight: m } = Kt(u.isComponent ? { mainBox: ".returnable-list-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], paginate: true } : { paginate: true }), { baseUnit: R } = ai(), v = Ee(() => R.value ? R.value[u.basicClass] : {}), N = Ee(() => _.query ? _.query.basicClass : null);
  Dt(() => L()), T.HOOK.handleRefresh = async (Y, { data: ee }) => {
    const B = u.basicClass & ua ? ["mete", "returnableMete"] : ["mete", "returnableMete", "singleReturnableMete", "singleMete"];
    await Qt(ee.content), ee.content = await returnPhysicalFormat(ee.content, { toSmallest: false, toNum: false }, { unitNetCalcMete: "returnableMete", unitNetCalcQuantity: "quantity", length: ["length", "singleReturnableLength"], mete: B }), await Es(ee.content), ee.content.forEach((q) => {
      var ae, j;
      q.getDataTime = (/* @__PURE__ */ new Date()).getTime(), q.outboundTypeSelection = Y.query.outboundTypeSelection, q.sourceReturnableMete = q.returnableMete, u.basicClass === dt.SECTION_STEEL.V && (q.returnableLength = q.singleReturnableLength * q.quantity, q.totalLength = q.length * q.quantity, q.sourceReturnableLength = q.returnableLength), u.basicClass & ua && (q.singleMete = St(q.singleMete, Ft.WEIGHT, (ae = v.value.weight) == null ? void 0 : ae.unit, returnPhysicalPrecision(v.value.weight.unit)), q.singleReturnableMete = St(q.singleReturnableMete, Ft.WEIGHT, (j = v.value.weight) == null ? void 0 : j.unit, returnPhysicalPrecision(v.value.weight.unit))), r.value && (q.mete = q.singleMete), q.showReviewPending = q.boolReviewPending && (!u.edit || u.edit && !u.sourceReturnIds.includes(q.id));
    });
  };
  function P(Y, ee) {
    const B = u.selectList;
    Y.boolReturns = ee, Y.materialIsReturned = r.value, Y.remnantId = r.value ? Y.id : void 0, Y.list = [], Y.index = g.value;
    const q = Ct({ uid: Tt(), source: JSON.parse(JSON.stringify(Y)), basicClass: Y.basicClass, measureUnit: Y.measureUnit, accountingUnit: Y.accountingUnit, accountingPrecision: Y.accountingPrecision, outboundUnitType: Y.outboundUnitType, outboundTypeSelection: Y.outboundTypeSelection, measurePrecision: Y.measurePrecision, getDataTime: Y.getDataTime, boolReturns: ee, materialIsReturned: r.value, remnantId: r.value ? Y.id : void 0, index: g.value, realTime: (/* @__PURE__ */ new Date()).getTime(), list: [] });
    if ((u.basicClass & dt.STEEL_PLATE.V || u.basicClass & dt.SECTION_STEEL.V) && (q.quantity = 1, ee)) {
      const oe = JSON.parse(JSON.stringify(q));
      delete oe.list;
      const ye = { ...oe, pid: oe.uid, singleQuantity: void 0, singleReturnMete: void 0, quantity: void 0, mete: void 0, width: void 0, length: void 0, uid: Tt() };
      q.list.push({ ...ye });
    }
    Ce(() => B, (oe, ye) => {
      var ce, se, he;
      u.returnDestination === kl.RETURN_TO_PUBLIC_LIBRARY.V && ee && A(oe) && A(ye) && A(oe[0]) && A(q.list[0]) && (q.list[0].factoryId = (ce = oe[0]) == null ? void 0 : ce.factoryId, q.list[0].workshopId = (se = oe[0]) == null ? void 0 : se.workshopId, q.list[0].warehouseId = (he = oe[0]) == null ? void 0 : he.warehouseId);
    }, { deep: true }), B.length > 0 && (q.workshopId = -1, q.warehouseId = -1);
    const ae = B.findLastIndex((oe) => oe.source.id === Y.id);
    ae > -1 ? B.splice(ae + 1, 0, q) : B.push(q);
    const j = Ki(Y), le = `${Y.classifyFullName}${j ? " - " + j : ""} 加入退库列表`;
    ot.success(le), c("add", q), g.value++;
  }
  function L() {
    const Y = {}, ee = {}, B = {}, q = {}, ae = {};
    for (const j of u.selectList) {
      const le = j.source, oe = le ? le.id : void 0;
      ae[oe] = ae[oe] || 0, oe && (j != null && j.materialIsReturned ? B[oe] ? B[oe]++ : B[oe] = 1 : j != null && j.boolReturns ? ee[oe] ? (ee[oe]++, q[oe] += j.mete || 0, ae[oe] += j.quantity || 0) : (ee[oe] = 1, q[oe] = j.mete || 0, ae[oe] += j.quantity || 0) : Y[oe] ? (Y[oe]++, q[oe] += j.mete || 0, ae[oe] += j.quantity || 0) : (Y[oe] = 1, q[oe] = j.mete || 0, ae[oe] += j.quantity || 0));
    }
    _.data.forEach((j) => {
      j.returnableMete = j.sourceReturnableMete - (q[j.id] || 0), j.ableQuantity = j.quantity - (ae[j.id] || 0);
    }), b.value = Y, V.value = ee, M.value = B;
  }
  function O() {
    g.value = 1, _.refresh();
  }
  function x(Y) {
    c("outboundTypeChange", Y);
  }
  function I(Y) {
    c("returnChange");
  }
  return o({ refresh: O }), (Y, ee) => {
    const B = vt, q = Ve("common-button"), ae = zn, j = Ve("common-table"), le = oi;
    return w(), Q("div", { class: Zt([{ container: u.isComponent }, "app-container"]) }, [s(l(e8), { onOutboundTypeChange: x, onReturnChange: I }), qe((w(), U(j, { key: `returnable_list_${N.value}`, ref_key: "tableRef", ref: S, data: l(_).data, "data-format": h, "default-expand-all": false, "expand-row-keys": y.value, "max-height": l(m), "row-key": "id", onSortChange: l(_).handleSortChange }, { default: p(() => [s(fa, { "basic-class": N.value, columns: l(f), sortable: "" }, null, 8, ["basic-class", "columns"]), s(Ba, { "basic-class": N.value, columns: l(f) }, null, 8, ["basic-class", "columns"]), s(Jue, { "basic-class": N.value, columns: l(f), "show-operable-quantity": false, "label-prefix": "可退库", "mete-field": "singleMete", "operable-mete-field": "singleReturnableMete", "single-mete-mode": "" }, null, 8, ["basic-class", "columns"]), l(f).visible("returnableMete") ? (w(), U(B, { key: "returnableMete", "show-overflow-tooltip": true, align: "center", label: "可退库核算量", "min-width": "120", prop: "returnableMete" })) : H("", true), N.value === l(dt).SECTION_STEEL.V && v.value ? (w(), Q(Qe, { key: 1 }, [l(f).visible("singleReturnableLength") ? (w(), U(B, { key: "singleReturnableLength", label: `可退库 / 长(${v.value.length.unit})`, "show-overflow-tooltip": true, align: "right", prop: "singleReturnableLength", width: "150" }, { default: p(({ row: oe }) => [C("span", Xue, K(l(ji)(oe.singleReturnableLength, v.value.length.precision)), 1), Te(" / " + K(l(ji)(oe.length, v.value.length.precision)), 1)]), _: 1 }, 8, ["label"])) : H("", true)], 64)) : H("", true), s(xl, { columns: l(f), "show-area": false, "show-monomer": false, showOutboundWorkshop: false, "show-project": "" }, null, 8, ["columns"]), l(f).visible("outboundSN") ? (w(), U(B, { key: "outboundSN", "show-overflow-tooltip": true, align: "center", label: "出库单号", "min-width": "120", prop: "outboundSN" }, { default: p(({ row: oe }) => [s(l(H_), { receipt: oe.outbound, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : H("", true), l(f).visible("mesWorkshop.name") ? (w(), U(B, { key: "mesWorkshop.name", "show-overflow-tooltip": true, align: "center", label: "领用车间", prop: "mesWorkshop.name", width: "90" })) : H("", true), l(f).visible("recipientName") ? (w(), U(B, { key: "recipientName", "show-overflow-tooltip": true, align: "center", label: "领用人", prop: "recipientName", width: "90" })) : H("", true), l(f).visible("areaBatchName") ? (w(), U(B, { key: "areaBatchName", "show-overflow-tooltip": true, align: "center", label: "领用批次", prop: "areaBatchName", width: "90" })) : H("", true), l(f).visible("createTime") ? (w(), U(B, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "出库日期", prop: "createTime", sortable: "custom", width: "100" })) : H("", true), l(f).visible("outboundDetailRemark") ? (w(), U(B, { key: "outboundDetailRemark", "show-overflow-tooltip": true, align: "center", label: "备注", prop: "outboundDetailRemark", width: "100" })) : H("", true), u.isComponent ? (w(), U(B, { key: 8, align: "center", class: "return-btn-column", fixed: "right", label: "退库", width: "170" }, { default: p(({ row: { sourceRow: oe } }) => [r.value ? H("", true) : (w(), Q(Qe, { key: 0 }, [s(ae, { hidden: b.value[oe.id] === 0, value: b.value[oe.id], class: "badge-item" }, { default: p(() => [s(q, { disabled: oe.showReviewPending || N.value & l(ua) && oe.ableQuantity <= 0 || e.returnDestination === l(kl).RETURN_TO_PUBLIC_LIBRARY.V && oe.boolPartyA, size: "default", type: "warning", onClick: (ye) => P(oe, false) }, { default: p(() => ee[0] || (ee[0] = [Te(" 退整料 ")])), _: 2, __: [0] }, 1032, ["disabled", "onClick"])]), _: 2 }, 1032, ["hidden", "value"]), N.value & l(dt).STEEL_PLATE.V || N.value & l(dt).SECTION_STEEL.V ? (w(), U(ae, { key: 0, hidden: V.value[oe.id] === 0, value: V.value[oe.id], class: "badge-item" }, { default: p(() => [N.value & l(dt).STEEL_PLATE.V || N.value & l(dt).SECTION_STEEL.V ? (w(), U(q, { key: 0, disabled: oe.showReviewPending || oe.ableQuantity <= 0 || e.returnDestination === l(kl).RETURN_TO_PUBLIC_LIBRARY.V && oe.boolPartyA, size: "default", style: { "margin-left": "10px" }, type: "danger", onClick: (ye) => P(oe, true) }, { default: p(() => ee[1] || (ee[1] = [Te(" 退余料 ")])), _: 2, __: [1] }, 1032, ["disabled", "onClick"])) : H("", true)]), _: 2 }, 1032, ["hidden", "value"])) : H("", true)], 64)), (N.value & l(dt).STEEL_PLATE.V || N.value & l(dt).SECTION_STEEL.V) && r.value ? (w(), U(ae, { key: 1, hidden: M.value[oe.id] === 0, value: M.value[oe.id], class: "badge-item" }, { default: p(() => [(N.value & l(dt).STEEL_PLATE.V || N.value & l(dt).SECTION_STEEL.V) && r.value ? (w(), U(q, { key: 0, disabled: oe.showReviewPending || e.returnDestination === l(kl).RETURN_TO_PUBLIC_LIBRARY.V && oe.boolPartyA, size: "default", style: { "margin-left": "10px" }, type: "danger", onClick: (ye) => P(oe, false) }, { default: p(() => ee[2] || (ee[2] = [Te(" 退料 ")])), _: 2, __: [2] }, 1032, ["disabled", "onClick"])) : H("", true)]), _: 2 }, 1032, ["hidden", "value"])) : H("", true), oe.showReviewPending ? (w(), U(g_, { key: 2, color: "#909399", name: "退库中" })) : H("", true)]), _: 1 })) : H("", true)]), _: 1 }, 8, ["data", "expand-row-keys", "max-height", "onSortChange"])), [[le, l(_).loading]]), s(l(td))], 2);
  };
} }, t8 = ut($ue, [["__scopeId", "data-v-c89e484b"]]), ece = Object.freeze(Object.defineProperty({ __proto__: null, default: t8 }, Symbol.toStringTag, { value: "Module" })), i8 = { __name: "index", props: { edit: { type: Boolean, default: false }, sourceReturnIds: { type: Array, default: () => [] }, modelValue: { type: Boolean, require: true }, basicClass: { type: Number }, selectList: { type: Array, default: () => [] }, returnDestination: { type: Number, default: void 0 } }, emits: ["add", "update:modelValue", "outboundTypeChange", "returnChange"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, { visible: r, handleClose: E } = Ta({ emit: c, props: u }), y = Z();
  function b(S) {
    c("add", S);
  }
  function V(S) {
    c("outboundTypeChange", S);
  }
  function M() {
    c("returnChange");
  }
  function g() {
    y.value && y.value.refresh();
  }
  return o({ refresh: g }), (S, h) => {
    const T = Ve("common-drawer");
    return w(), U(T, { ref: "drawerRef", modelValue: l(r), "onUpdate:modelValue": h[0] || (h[0] = (_) => Gt(r) ? r.value = _ : null), "before-close": l(E), "show-close": true, "custom-class": "returnable-list-drawer", direction: "btt", size: "80%", title: "可退库清单" }, { content: p(() => [e.basicClass ? (w(), U(t8, { key: 0, ref_key: "returnableListRef", ref: y, basicClass: e.basicClass, edit: e.edit, "return-destination": e.returnDestination, "select-list": e.selectList, "source-return-ids": e.sourceReturnIds, "is-component": "", onAdd: b, onOutboundTypeChange: V, onReturnChange: M }, null, 8, ["basicClass", "edit", "return-destination", "select-list", "source-return-ids"])) : H("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, tce = Object.freeze(Object.defineProperty({ __proto__: null, default: i8 }, Symbol.toStringTag, { value: "Module" }));
const ice = { class: "head-container" }, ace = { class: "filter-container" }, lce = { class: "filter-left-box" }, oce = { class: "total-info" }, nce = { class: "info-item" }, sce = { class: "info-item" }, rce = { key: 0, class: "info-item" }, uce = { class: "filter-right-box child-mr-7" }, cce = { class: "inventory" }, dce = { class: "left-box" }, mce = { class: "right-box" }, pce = { __name: "common-header", props: { edit: { type: Boolean, default: false }, sourceReturnIds: { type: Array, default: () => [] }, currentSource: { type: Object, default: () => ({}) }, basicClass: { type: Number }, list: { type: Array, default: () => [] }, currentPlateRow: { type: Object, default: () => ({}) } }, emits: ["add", "submit", "reset"], setup(e, { expose: o, emit: n }) {
  const c = Ht(), u = n, { returnCfg: r } = aa(), E = Ee(() => fr()), { cu: y, form: b, FORM: V } = Wi(), M = e, g = jn(), S = Z(), h = Z(), T = Z(), _ = Z(), f = Z(true), m = Z(Jt.PRODUCE.V), R = Z(false), { baseUnit: v } = ai(M.basicClass), N = Z();
  Ce(() => r.value.returnDestination, () => {
    M.edit ? pt(() => {
      N.value = b.returnDestination;
    }) : N.value = A(r.value.returnDestination) ? r.value.returnDestination : void 0;
  }, { immediate: true }), V.HOOK.beforeToCU = async () => {
    f.value = Object.prototype.hasOwnProperty.call(y.props, "boolRealReturn") ? y.props.boolRealReturn : true;
  }, V.HOOK.beforeSubmit = () => {
    b.returnDestination = N.value, b.list.forEach((se) => {
      se.boolRealReturn = f.value, se.returnDestination = N.value;
    });
  }, V.HOOK.afterSubmit = () => {
    M.edit || S.value && S.value.refresh(), c.dispatch("approval_list/fetchApprovalNum"), P();
  }, Ce(() => c.state.approval_list.isRefresh, (se) => {
    se && S.value && S.value.refresh();
  }, { deep: true });
  function P() {
    h.value = 0, T.value = 0, _.value = 0;
  }
  function L(se) {
    u("add", se);
  }
  function O() {
    R.value = true;
  }
  function x(se) {
    y.updateProp("boolRealReturn", se);
  }
  function I() {
    pt(() => {
      h.value = b.list.reduce((se, he) => +ji(se + (he.mete || 0), v.value.weight.precision), 0);
    });
  }
  function Y() {
    T.value = b.list.reduce((se, { quantity: he = 0 }) => se + he, 0);
  }
  function ee() {
    _.value = b.list.reduce((se, he) => +ji(se + (he.totalLength || 0), 2), 0);
  }
  function B() {
    ci.set("ROUTER_PARAMS", { basicClass: M.basicClass }), g.push({ name: "RawMatReturnApplicationRecord" });
  }
  const q = Ee(() => {
    let se;
    if (M.edit) se = m.value === Jt.OUTSOURCE.V ? eO : Nn;
    else if (m.value === Jt.PRODUCE.V || m.value === Jt.CONSTRUCTION_SITE_USE.V) switch (M.basicClass) {
      case Pe.STEEL_PLATE.V:
        se = q4;
        break;
      case Pe.SECTION_STEEL.V:
        se = G4;
        break;
      case Pe.STEEL_COIL.V:
        se = Q4;
        break;
      case Pe.OTHER_STEEL_MATERIALS.V:
        se = $4;
        break;
      case Pe.MATERIAL.V:
        se = Z4;
        break;
      case Pe.OTHER.V:
        se = J4;
        break;
      case Pe.GAS.V:
        se = X4;
        break;
      default:
        se = null;
        break;
    }
    else se = yue;
    return se;
  });
  function ae() {
    y.api = q.value, console.log(q.value, M.basicClass), M.basicClass & dt.STEEL_PLATE.V || M.basicClass & dt.SECTION_STEEL.V ? u("submit") : y.submit();
  }
  function j() {
    y.form.list = [], P();
  }
  function le(se) {
    m.value = se, se === Jt.OUTSOURCE.V && (f.value = true), P(), u("reset");
  }
  function oe(se) {
    var he, be;
    if (se === kl.RETURN_TO_PUBLIC_LIBRARY.V) {
      if (((he = y.form.list) == null ? void 0 : he.findIndex((ge, Le) => ge.source.boolPartyA === true)) !== -1) {
        pt(() => {
          N.value = kl.RETURN_TO_ORIGINAL_LOCATION.V;
        }), ot.error("列表中存在甲供物料，无法切换！");
        return;
      }
      f.value = true, (be = y.form.list) == null || be.forEach((ge, Le) => {
        var Ie;
        Le !== 0 && (ge.workshopId = -1, ge.warehouseId = -1), A(ge.list) && ((Ie = ge.list) == null || Ie.forEach((Se, X) => {
          X === 0 ? (ge.list[0].workshopId = y.form.list[0].workshopId, ge.list[0].warehouseId = y.form.list[0].warehouseId) : (ge.list[X].workshopId = -1, ge.list[X].warehouseId = -1);
        }));
      });
    }
  }
  function ye() {
  }
  function ce() {
    P(), u("reset");
  }
  return o({ calcAllWeight: I, calcAllQuantity: Y, calcAllLength: ee, returnDestination: N }), (se, he) => {
    var k;
    const be = FV, me = ml, ge = Ve("common-radio"), Le = jt, Ie = Fo, Se = Ve("common-button"), X = pa, $ = _t("to-fixed");
    return w(), Q(Qe, null, [C("div", ice, [l(A)(l(b).list) ? (w(), U(gu, { key: 0, "basic-class": e.basicClass, currentPlateRow: e.currentPlateRow, material: e.currentSource, class: "filter-item" }, null, 8, ["basic-class", "currentPlateRow", "material"])) : H("", true), C("div", ace, [C("div", lce, [C("span", oce, [e.basicClass & l(ua) ? (w(), Q(Qe, { key: 0 }, [C("span", nce, [C("span", null, "总数(" + K(l(v).measure.unit) + ")", 1), qe(C("span", null, null, 512), [[$, { val: T.value || 0, dp: ((k = e.currentSource) == null ? void 0 : k.measurePrecision) || l(v).measure.precision }]])]), C("span", sce, [C("span", null, "总重量(" + K(l(v).weight.unit) + ")", 1), qe(C("span", null, null, 512), [[$, { val: h.value || 0, dp: l(v).weight.precision }]])]), e.basicClass === l(dt).SECTION_STEEL.V ? (w(), Q("span", rce, [he[3] || (he[3] = C("span", null, "总长度(m)", -1)), qe(C("span", null, null, 512), [[$, { val: _.value || 0, dp: 3 }]])])) : H("", true)], 64)) : H("", true)])]), C("div", uce, [s(Le, { content: "直退至公共库禁止多仓库多工厂间操作", effect: "light", placement: "bottom" }, { default: p(() => [C("div", cce, [C("div", dce, [he[4] || (he[4] = Te(" 当前退库目的地 ")), s(me, { style: { "margin-left": "4px" } }, { default: p(() => [s(be)]), _: 1 })]), C("div", mce, [s(ge, { modelValue: N.value, "onUpdate:modelValue": he[0] || (he[0] = (J) => N.value = J), options: l(kl).ENUM, size: "default", type: "enum", onChange: oe }, null, 8, ["modelValue", "options"])])])]), _: 1 }), M.edit ? H("", true) : (w(), U(p4, { key: 0, type: "cu", onClear: ye })), s(Le, { content: `1.真实退库：正常退库。
            2.虚拟退库：只对当前物料成本进行退库，库存量不发生改变。
            3.虚拟退库后会在下个月初产生相应的出库记录，库存量不发生改变。`, effect: "light", placement: "bottom" }, { default: p(() => [s(Ie, { modelValue: f.value, "onUpdate:modelValue": he[1] || (he[1] = (J) => f.value = J), disabled: m.value === l(Jt).OUTSOURCE.V || N.value === l(kl).RETURN_TO_PUBLIC_LIBRARY.V, border: "", style: { "margin-right": "6px" }, onChange: x }, { default: p(() => [he[5] || (he[5] = C("span", null, "真实退库", -1)), s(me, { style: { "margin-left": "4px" } }, { default: p(() => [s(be)]), _: 1 })]), _: 1, __: [5] }, 8, ["modelValue", "disabled"])]), _: 1 }), E.value === l(Qn).SELF.V ? (w(), U(X, { key: 1, title: "确认所选择的退库日期正确么?", "confirm-button-text": "确认提交", onConfirm: ae }, { reference: p(() => [s(Se, { loading: l(y).status.edit === l(V).STATUS.PROCESSING, size: "default", type: "primary" }, { default: p(() => he[6] || (he[6] = [Te(" 提 交 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })) : (w(), U(Se, { key: 2, loading: l(y).status.edit === l(V).STATUS.PROCESSING, onClick: ae, size: "default", type: "primary" }, { default: p(() => he[7] || (he[7] = [Te(" 提 交 ")])), _: 1, __: [7] }, 8, ["loading"])), s(Se, { size: "default", type: "success", onClick: O }, { default: p(() => he[8] || (he[8] = [Te("检索可退库材料")])), _: 1, __: [8] }), M.edit ? H("", true) : (w(), U(Se, { key: 3, icon: "el-icon-time", size: "default", type: "info", onClick: B }))])])]), s(i8, { ref_key: "returnableListRef", ref: S, modelValue: R.value, "onUpdate:modelValue": he[2] || (he[2] = (J) => R.value = J), "basic-class": e.basicClass, edit: M.edit, "return-destination": N.value, "select-list": l(b).list, "source-return-ids": e.sourceReturnIds, onAdd: L, onClear: j, onOutboundTypeChange: le, onReturnChange: ce }, null, 8, ["modelValue", "basic-class", "edit", "return-destination", "select-list", "source-return-ids"])], 64);
  };
} }, ls = ut(pce, [["__scopeId", "data-v-d3a6b434"]]), hce = Object.freeze(Object.defineProperty({ __proto__: null, default: ls }, Symbol.toStringTag, { value: "Module" }));
function Ys({ form: e, tableRef: o, delCallback: n }) {
  const c = Z(), u = Z();
  Ce(() => e.list, () => {
    y();
  }, { deep: true });
  function r(b, V, M) {
    u.value = b.uid, c.value = b.source;
  }
  function E(b, V) {
    e.list.splice(V, 1), typeof n == "function" && n(b), (b.uid === u.value || !u.value) && setTimeout(() => {
      if (e.list.length > 0) {
        const M = V < e.list.length ? e.list[V] : e.list[V - 1];
        o.value.setCurrentRow(M), r(M);
      } else u.value = null, c.value = null;
    }, 0);
  }
  function y() {
    if (e.list.length > 0 && !u.value) {
      const b = e.list[0];
      o.value.setCurrentRow(b), r(b);
    }
  }
  return { currentSource: c, currentUid: u, delRow: E, setDefaultCurrent: y, handleRowClick: r };
}
function Ks({ FORM: e, form: o, cu: n, emit: c, isEdit: u, tableRules: r, init: E, setFormCallback: y }) {
  const b = /* @__PURE__ */ new Map([["workshopId", -1], ["warehouseId", -1]]), V = Z([]), { tableValidate: M, wrongCellMask: g, cleanUpData: S } = ui({ rules: r, ditto: b, errorMsg: "请修正【退库清单】中标红的信息" });
  n.submitFormFormat = async (_) => (_.list.map((f) => {
    var m;
    return (f.basicClass & dt.STEEL_PLATE.V || f.basicClass & dt.SECTION_STEEL.V) && ((m = f.list) == null ? void 0 : m.length) > 0 && S(f.list), f;
  }), S(_.list), await Promise.all(_.list.map(async (f) => {
    var m;
    (f.basicClass & dt.STEEL_PLATE.V || f.basicClass & dt.SECTION_STEEL.V) && ((m = f.list) == null ? void 0 : m.length) > 0 && (f.list = await returnPhysicalFormat(f.list, { toSmallest: true, toNum: true }, { mete: ["singleReturnMete"] }));
  })), _.list = await returnPhysicalFormat(_.list, { toSmallest: true, toNum: true }), u ? _ : _.list), e.HOOK.beforeToEdit = async (_, f) => {
    u && (y(f), V.value = Tn(f.list.map((m) => m.source.id)));
  }, e.HOOK.beforeValidateCU = (_, f) => h(), e.HOOK.afterSubmit = () => {
    u && c("success"), E();
  };
  function h() {
    const { validResult: _, dealList: f } = M(o.list);
    return o.list = f, _ ? T() : false;
  }
  function T() {
    const _ = o.list.some((f) => f.overTipColor);
    return _ && ot.error("请修正序号前带“三角形标志”的数据，他们的合计量，超过了可退库的总量"), !_;
  }
  return { wrongCellMask: g, sourceReturnIds: V };
}
function agt() {
  return "#" + (function e(o) {
    return (o += "5678956789defdef"[Math.floor(Math.random() * 16)]) && o.length === 6 ? o : e(o);
  })("");
}
function fce() {
  return "#" + (function e(o) {
    return (o += "0123401234abcabc"[Math.floor(Math.random() * 16)]) && o.length === 6 ? o : e(o);
  })("");
}
function Ws({ cu: e, form: o, basicClass: n, baseUnit: c }) {
  function u(b) {
    n !== dt.STEEL_COIL.V && b.quantity ? b.maxMete = b.source.sourceReturnableMete : b.maxMete = b.source.singleReturnableMete, b.maxQuantity = b.source.quantity;
  }
  function r(b) {
    const V = {};
    b.forEach((M) => {
      V[M.source.id] ? M.source = V[M.source.id] : V[M.source.id] = M.source;
    });
  }
  function E(b) {
    const V = {}, M = {}, g = {}, S = {}, h = {}, T = {};
    o.list.forEach((_) => {
      if (b.source.id === _.source.id) {
        const f = _.source.id;
        T[f] ? _.source = T[f] : T[f] = _.source, _.materialIsReturned ? A(S[f]) ? (h[f] += Number(_.quantity) || 0, S[f] += _.mete || 0) : (h[f] = _.quantity || 0, S[f] = _.mete || 0) : A(V[f]) ? (M[f] += Number(_.quantity) || 0, V[f] += _.boolReturns ? _.detailMete || 0 : _.mete || 0, g[f] += _.length * Number(_.quantity) || 0) : (M[f] = Number(_.quantity) || 0, V[f] = _.boolReturns ? _.detailMete || 0 : _.mete || 0, g[f] = _.length * Number(_.quantity) || 0);
      }
    }), Object.keys(T).forEach((_) => {
      const f = T[_];
      f.materialIsReturned ? (f.returnableMete = f.sourceReturnableMete - (S[f.id] || 0), f.returnContinueQuantity = h[f.id]) : (f.returnableMete = f.sourceReturnableMete - (V[f.id] || 0), f.measureUnit && (f.returnableQuantity = (f.quantity || 0) - (M[f.id] || 0))), n === dt.SECTION_STEEL.V && (f.returnableLength = f.sourceReturnableLength - (g[f.id] || 0));
    });
  }
  function y(b) {
    E(b);
    const V = Be(b.source.returnableMete, b.basicClass & ua ? returnPhysicalPrecision(c && c.value ? c.value.weight.unit : "t") : b.source.accountingPrecision);
    let M = V < 0, g = V >= 0;
    if (b.source.measureUnit && !b.materialIsReturned) {
      const S = Be(b.source.returnableQuantity, b.source.measurePrecision);
      M = M || S < 0, g = g && S >= 0;
    }
    if (b.basicClass === dt.SECTION_STEEL.V) {
      const S = Be(b.source.returnableLength, c.value ? c.value.length.precision : 0);
      M = M || S < 0, g = g && S >= 0;
    }
    if (M = !!(M && !b.overTipColor), g = !!(g && b.overTipColor), M) {
      const S = fce();
      b.overTipColor = S, o.list.forEach((h) => {
        h.source.id === b.source.id && (h.overTipColor = S);
      });
    }
    g && o.list.forEach((S) => {
      S.source.id === b.source.id && (S.overTipColor = void 0);
    });
  }
  return { calcMaxMete: u, extractSource: r, calcReturnInfo: E, checkOverSource: y, initCheckOverMaxWeight: () => {
  } };
}
const gce = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.steelMinLengthConfig);
  if (n.value || o.dispatch("config/fetchSteelMinLengthConfig"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { steelMinLengthConfig: Ee(() => o.state.config.steelMinLengthConfig), loaded: n };
}, Nr = { __name: "closing-time-form", props: { columns: { type: Object }, fixed: { type: String }, showLabel: { type: String, default: "实际时间" }, showSourceRow: { type: Boolean, default: false } }, setup(e) {
  const { loaded: o, lastTime: n } = W3();
  function c(E) {
    return A(n.value) && n.value.endTime ? E.getTime() < Number(n.value.endTime) + 1 * 1e3 || E.getTime() > (/* @__PURE__ */ new Date()).getTime() : E.getTime() > (/* @__PURE__ */ new Date()).getTime();
  }
  const u = e, r = Ee(() => {
    const E = fr();
    return E && E === Qn.SELF.V && (Ae(u.columns) || u.columns.visible("realTime"));
  });
  return (E, y) => {
    const b = Rl, V = vt;
    return r.value ? (w(), Q(Qe, { key: 0 }, [e.showSourceRow ? (w(), U(V, { "show-overflow-tooltip": true, key: "realTimeSourceRow", prop: "realTime", label: e.showLabel, width: "230px", align: "center" }, { default: p(({ row: { sourceRow: M } }) => [s(b, { modelValue: M.realTime, "onUpdate:modelValue": (g) => M.realTime = g, type: "datetime", "value-format": "x", disabled: !l(o), disabledDate: c, placeholder: e.showLabel }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "placeholder"])]), _: 1 }, 8, ["label"])) : (w(), U(V, { "show-overflow-tooltip": true, key: "realTime", prop: "realTime", label: e.showLabel, width: "230px", align: "center" }, { default: p(({ row: M }) => [s(b, { modelValue: M.realTime, "onUpdate:modelValue": (g) => M.realTime = g, type: "datetime", "value-format": "x", disabled: !l(o), disabledDate: c, placeholder: e.showLabel }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "placeholder"])]), _: 1 }, 8, ["label"]))], 64)) : H("", true);
  };
} };
const Ece = { class: "app-container" }, yce = { style: { display: "inline-block" } }, Tce = { key: 1 }, _ce = { style: { display: "inline-block" } }, bce = { key: 1 }, Vce = { key: 1 }, wce = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const n = Ht(), { realTimeValidate: c } = as(), { steelMinLengthConfig: u } = gce(), r = o, E = e, y = { list: [] }, b = Z([]), V = Z(), M = Z(), g = Z(), S = Z([]), h = Z({}), T = Ee(() => {
    var de;
    return (de = V.value) == null ? void 0 : de.returnDestination;
  }), _ = Z([["source.project", ["parse-project", { onlyShortName: true }]]]), { fixMaxHeight: f, maxHeight: m } = Kt({ paginate: false }), R = dt.STEEL_PLATE.V, { baseUnit: v } = ai(R), L = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { validator: (de, pe) => !(!de || u.value.steelPlateShortestSideMinLength && de <= u.value.steelPlateShortestSideMinLength), message: "长度必须大于废料长度", trigger: "blur" }], mete: [{ validator: (de, pe) => de ? pe.boolReturns && !pe.remnantId ? !(!pe.detailMete || pe.detailMete > de) : true : false, message: "请填写重量", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], realTime: [{ validator: c, message: "请选择实际退库时间", trigger: "change" }] }, { cu: O, form: x, FORM: I } = Pa({ title: "钢板退库", formStore: !E.edit, formStoreKey: "WMS_RETURN_APPLICATION_STEEL_PLATE", permission: xS, defaultForm: y, useDraftCallback: ie, clearDraftCallback: he, api: E.edit ? Nn : q4 }, g, E.detail);
  O.updateProp("boolRealReturn", E.detail && Object.prototype.hasOwnProperty.call(E.detail, "boolRealReturn") ? E.detail.boolRealReturn : true);
  const { calcMaxMete: Y, extractSource: ee, checkOverSource: B, initCheckOverMaxWeight: q } = Ws({ cu: O, form: x, basicClass: R }), { currentSource: ae, currentUid: j, delRow: le, handleRowClick: oe } = Ys({ form: x, tableRef: M, delCallback: B }), { sourceReturnIds: ye, wrongCellMask: ce } = Ks({ FORM: I, form: x, cu: O, emit: r, tableRules: L, init: he, setFormCallback: ie, isEdit: E.edit });
  Ce(() => x.list, () => {
    V.value && V.value.calcAllQuantity(), V.value && V.value.calcAllWeight();
  }, { deep: true });
  function se(de) {
    h.value = de, oe(de);
  }
  function he() {
    x.list = [], ae.value = void 0, j.value = void 0, h.value = {}, S.value = [];
  }
  function be(de) {
    var we;
    Ce([() => de.quantity], () => {
      de.boolReturns || Y(de), V.value && V.value.calcAllQuantity();
    }, { immediate: true }), Ce([() => de.length, () => de.width, v], () => {
      X(de);
    }, { immediate: true }), Ce([() => de.singleMete, () => de.quantity], () => {
      G(de), de.boolReturns && $(de), V.value && V.value.calcAllWeight();
    }, { immediate: true }), Ce([() => de.mete, () => de.detailMete], () => {
      B(de);
    }, { immediate: true }), ge(de, de.source);
    const re = (x.list.filter((Ke) => Ke.boolReturns && !Ke.remnantId) || []).map((Ke) => Ke.uid) || [];
    b.value = re, de.boolReturns && ((we = de.list) == null ? void 0 : we.length) > 0 && de.list.map((Ke) => {
      Ke.realTime = de.realTime || (/* @__PURE__ */ new Date()).getTime(), me(Ke);
    });
  }
  function me(de) {
    Ce([() => de.length, () => de.width, v], () => {
      X(de);
    }), Ce([() => de.singleMete, () => de.singleQuantity], () => {
      J(de);
    }), Ce([() => de.singleReturnMete], () => {
      k(de);
    });
  }
  function ge(de, pe) {
    var re, we, Ke;
    de.width = de.width || pe.width, de.length = de.length || pe.length, de.materialIsReturned || (de.quantity = de.quantity || pe.quantity), de.factoryId = de.factoryId || ((re = pe.factory) == null ? void 0 : re.id), de.workshopId = de.workshopId || ((we = pe.workshop) == null ? void 0 : we.id), de.warehouseId = de.warehouseId || ((Ke = pe.warehouse) == null ? void 0 : Ke.id), X(de), setTimeout(() => {
      de.mete = de.mete || pe.mete;
    });
  }
  function Le(de) {
    const pe = JSON.parse(JSON.stringify(de));
    delete pe.list, de.list.length > 0 && (pe.factoryId = -1, pe.workshopId = -1, pe.warehouseId = -1);
    const re = Ct({ ...pe, pid: pe.uid, singleQuantity: void 0, singleReturnMete: void 0, quantity: void 0, mete: void 0, width: void 0, length: void 0, uid: Tt() });
    de.list.push(re), me(re);
  }
  function Ie(de, pe) {
    var we, Ke, Me, Ne, He, ze;
    const re = x.list.find((Oe) => Oe.uid === de.pid) || {};
    A(re.list) && (re.detailMete = Be(re.detailMete - (de.mete || 0), returnPhysicalPrecision(v.value.weight.unit)), re.list.splice(pe, 1), ((Ke = (we = re.list) == null ? void 0 : we[0]) == null ? void 0 : Ke.factoryId) === -1 && (re.list[0].factoryId = void 0), ((Ne = (Me = re.list) == null ? void 0 : Me[0]) == null ? void 0 : Ne.workshopId) === -1 && (re.list[0].workshopId = void 0), ((ze = (He = re.list) == null ? void 0 : He[0]) == null ? void 0 : ze.warehouseId) === -1 && (re.list[0].warehouseId = void 0));
  }
  function Se(de) {
    de.length && de.length <= u.value.steelPlateShortestSideMinLength && (de.length = void 0);
  }
  async function X(de) {
    var pe, re;
    de.length && de.width && ((pe = de.source) != null && pe.classifyFullName) && ((re = de.source) != null && re.thickness) && (de.theoryWeight = await na({ classifyId: de.source.classifyId, name: de.source.classifyFullName, length: de.length, width: de.width, thickness: de.source.thickness }), de.theoryWeight ? de.singleMete = Be(de.theoryWeight / de.source.theoryWeight * de.source.singleMete, returnPhysicalPrecision(v.value.weight.unit)) : de.singleMete = void 0);
  }
  function $(de) {
    const pe = x.list.find((re) => re.uid === de.uid) || {};
    if (A(pe.list)) {
      let re = 0;
      pe.list.forEach((we) => {
        we.singleReturnMete && (re += we.singleReturnMete);
      }), pe.detailMete = re ? Be(re, returnPhysicalPrecision(v.value.weight.unit)) * (pe.quantity || 0) : 0;
    } else pe.detailMete = 0;
  }
  function k(de) {
    const pe = x.list.find((re) => re.uid === de.pid) || {};
    if (A(pe.list)) {
      let re = 0;
      pe.list.forEach((we) => {
        we.singleReturnMete && (re += we.singleReturnMete);
      }), pe.detailMete = re ? Be(re, returnPhysicalPrecision(v.value.weight.unit)) * (pe.quantity || 0) : 0;
    }
  }
  function J(de) {
    A(de.singleMete) && de.singleQuantity ? (de.singleReturnMete = Be(de.singleMete * de.singleQuantity, returnPhysicalPrecision(v.value.weight.unit)), de.singleReturnMete > de.maxMete && de.singleReturnMete > de.singleMete && (de.singleReturnMete = Be(Math.min(de.maxMete, de.singleMete), returnPhysicalPrecision(v.value.weight.unit)))) : de.singleReturnMete = void 0;
  }
  function z(de) {
    let pe = 0;
    return x.list.forEach((re) => {
      de.source.id === re.source.id && (pe += Number(re.quantity) || 0);
    }), de.source.quantity - pe;
  }
  function F(de) {
    let pe = 0;
    return x.list.forEach((re) => {
      de.source.id === re.source.id && (pe += Number(re.mete) || 0);
    }), de.source.sourceReturnableMete - pe;
  }
  function G(de) {
    if (console.log(de, "row"), A(de.singleMete) && de.quantity) {
      de.mete = Be(de.singleMete * de.quantity, returnPhysicalPrecision(v.value.weight.unit));
      const pe = z(de);
      if (!de.pid) {
        const re = Be(Number(de.source.sourceReturnableMete), returnPhysicalPrecision(v.value.weight.unit));
        if (Number(de.quantity) === Number(de.source.quantity)) (!de.materialIsReturned && !de.boolReturns || de.source.sourceReturnableMete < de.mete || de.mete === re) && (de.mete = Number(de.source.sourceReturnableMete));
        else if (pe === 0) {
          const we = F(de);
          let Ke = de.mete;
          Ke += we, de.mete = returnPhysicalRound(Ke, v.value.weight.unit);
        }
      }
    } else de.mete = void 0;
  }
  function ie(de) {
    de.list = de.list.map((re) => Ct(re));
    const pe = Ce([M, V, v], ([re, we, Ke]) => {
      re && we && Ke && (ee(de.list), q(de.list), de.list.forEach((Me) => {
        be(Me), Me.boolReturns && A(Me.list) && Me.list.forEach((Ne) => {
          me(Ne);
        }), B(Me);
      }), pt(() => {
        pe(), V.value.calcAllQuantity(), V.value.calcAllWeight();
      }));
    }, { immediate: true, deep: true });
    f();
  }
  function ue() {
    const de = [];
    S.value = [], x.list.forEach((re) => {
      re.boolReturns && !re.remnantId && (A(re.list) ? re.list.forEach((we) => {
        (!we.length || !we.width || !we.singleQuantity || !we.singleMete || !we.warehouseId) && (de.includes(we.pid) || de.push(we.pid));
      }) : de.includes(re.uid) || de.push(re.uid));
    });
    let pe = true;
    return A(de) && (S.value = de, b.value = de, ot.error("表格展开项红色部分余料退库明细填写不全，请修正"), pe = false), pe;
  }
  function ne() {
    const de = [];
    return S.value = [], x.list.forEach((pe) => {
      pe.boolReturns && !pe.remnantId && pe.detailMete > pe.mete && (de.includes(pe.uid) || de.push(pe.uid));
    }), A(de) ? (S.value = de, b.value = de, ot.error("表格展开项余料总重量不能超过钢板总量，请修正"), false) : true;
  }
  function te() {
    let de = ue();
    de && (de = ne()), de && (x.list.forEach((pe) => {
      pe.remnantId && (pe.boolReturns = true), pe.boolReturns && A(pe.list) && pe.list.forEach((re) => {
        re.realTime = pe.realTime;
      });
    }), O.submit());
  }
  return El(async () => {
    await n.dispatch("wms/fetchSteelDensityCfg");
  }), (de, pe) => {
    const re = vt, we = Ve("common-input-number"), Ke = Ve("common-button"), Me = Ve("common-table"), Ne = Mt, He = jt, ze = Li;
    return w(), Q("div", Ece, [s(ls, { ref_key: "headerRef", ref: V, "basic-class": l(R), "current-source": l(ae), currentPlateRow: h.value, edit: E.edit, list: l(x).list, "source-return-ids": l(ye), onAdd: be, onReset: he, onSubmit: te }, null, 8, ["basic-class", "current-source", "currentPlateRow", "edit", "list", "source-return-ids"]), s(ze, { ref_key: "formRef", ref: g, disabled: l(O).status.edit === l(I).STATUS.PROCESSING, model: l(x) }, { default: p(() => [s(Me, { ref_key: "tableRef", ref: M, "cell-class-name": l(ce), data: l(x).list, "data-format": _.value, "default-expand-all": false, "expand-row-keys": b.value, "max-height": l(m), stripe: false, "highlight-current-row": "", "row-key": "uid", onRowClick: se }, { default: p(() => [s(Ha, { "expand-row-keys": b.value, "onUpdate:expandRowKeys": pe[0] || (pe[0] = (Oe) => b.value = Oe), data: l(x).list, stripe: false, "row-key": "uid", style: { background: "#f4f4f5" } }, { default: p(({ row: { sourceRow: Oe } }) => [C("div", { style: ri(`padding-bottom:10px;background:${S.value.includes(Oe.uid) ? "#ff000021" : l(j) === Oe.uid ? "#f4f4f5" : ""};`) }, [Oe.boolReturns && !Oe.remnantId && (Oe.uid || Oe.id) ? (w(), U(Me, { key: Oe.uid, class: Zt(S.value.includes(Oe.uid) ? "error-table" : l(j) === Oe.uid ? "child-table" : ""), data: Oe.list, stripe: false, style: { "margin-bottom": "10px" } }, { default: p(() => [s(re, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), (w(), U(jo, { key: Oe.uid, "basic-class": l(R), "show-index": false, "show-length": false, "show-project": false, "show-thickness": false, "show-width": false, field: "source", "party-a-position": "project" }, null, 8, ["basic-class"])), s(Wo, { "basic-class": l(R), field: "source" }, null, 8, ["basic-class"]), s(re, { label: `厚 (${l(v).thickness.unit})`, align: "center", prop: "source.thickness", width: "70px" }, null, 8, ["label"]), s(re, { label: `宽 (${l(v).width.unit})`, align: "center", prop: "width", width: "110px" }, { default: p(({ row: { sourceRow: Re } }) => {
      var fe;
      return [s(we, { modelValue: Re.width, "onUpdate:modelValue": (Ue) => Re.width = Ue, controls: false, max: +Re.source.width, min: ((fe = l(u)) == null ? void 0 : fe.steelPlateShortestSideMinLength) + 1 || 0, precision: l(v).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision"])];
    }), _: 2 }, 1032, ["label"]), s(re, { label: `长 (${l(v).length.unit})`, align: "center", prop: "length", width: "110px" }, { default: p(({ row: { sourceRow: Re } }) => {
      var fe;
      return [s(we, { modelValue: Re.length, "onUpdate:modelValue": (Ue) => Re.length = Ue, controls: false, max: +Re.source.length, min: ((fe = l(u)) == null ? void 0 : fe.steelPlateShortestSideMinLength) + 1 || 0, precision: l(v).length.precision, placeholder: "长", size: "default", onBlur: (Ue) => Se(Re) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision", "onBlur"])];
    }), _: 2 }, 1032, ["label"]), s(re, { label: `数量 (${l(v).measure.unit})`, align: "center", prop: "singleQuantity", width: "110px" }, { default: p(({ row: { sourceRow: Re } }) => [s(we, { modelValue: Re.singleQuantity, "onUpdate:modelValue": (fe) => Re.singleQuantity = fe, controls: false, max: 9999999, min: 1, precision: l(v).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 2 }, 1032, ["label"]), s(re, { key: "singleReturnMete", label: `总重 (${l(v).weight.unit})`, align: "center", "min-width": "120px", prop: "singleReturnMete" }, { default: p(({ row: { sourceRow: Re } }) => [s(ReturnPhysicalWeightInput, { modelValue: Re.singleReturnMete, "onUpdate:modelValue": (fe) => Re.singleReturnMete = fe, controls: false, max: 9999999, min: 0, precision: l(v).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 2 }, 1032, ["label"]), s(rn, { list: Oe.list, "return-destination": T.value, warehouseWidth: 110, "warehouse-set-type": "small" }, null, 8, ["list", "return-destination"]), s(re, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: { sourceRow: Re }, $index: fe }) => [s(Ke, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ue) => Ie(Re, fe) }, null, 8, ["onClick"])]), _: 2 }, 1024)]), _: 2 }, 1032, ["class", "data"])) : H("", true), s(Ne, { modelValue: Oe.remark, "onUpdate:modelValue": (Re) => Oe.remark = Re, autosize: { minRows: 2, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "50%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])], 4)]), _: 1 }, 8, ["expand-row-keys", "data"]), (w(), U(jo, { key: l(R), "basic-class": l(R), "show-length": false, "show-thickness": false, "show-width": false, field: "source", "party-a-position": "project", "show-project": "", showTip: "" }, null, 8, ["basic-class"])), s(Wo, { "basic-class": l(R), field: "source" }, null, 8, ["basic-class"]), s(re, { label: `厚 (${l(v).thickness.unit})`, align: "center", prop: "source.thickness", width: "70px" }, null, 8, ["label"]), s(re, { label: `宽 (${l(v).width.unit})`, align: "center", prop: "width", width: "110px" }, { header: p(() => [s(He, { content: "宽度必须大于废料定义宽度", class: "item", effect: "light", placement: "top" }, { default: p(() => [C("div", yce, [C("span", null, "宽 (" + K(l(v).width.unit) + ")", 1), pe[1] || (pe[1] = C("i", { class: "el-icon-info" }, null, -1))])]), _: 1 })]), default: p(({ row: { sourceRow: Oe } }) => [Oe.materialIsReturned ? (w(), U(we, { key: 0, modelValue: Oe.width, "onUpdate:modelValue": (Re) => Oe.width = Re, controls: false, max: +Oe.source.width, min: 0, precision: l(v).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (w(), Q("span", Tce, K(Oe.width), 1))]), _: 1 }, 8, ["label"]), s(re, { label: `长 (${l(v).length.unit})`, align: "center", prop: "length", width: "110px" }, { header: p(() => [s(He, { content: "长度必须大于废料定义长度", class: "item", effect: "light", placement: "top" }, { default: p(() => [C("div", _ce, [C("span", null, "长 (" + K(l(v).length.unit) + ")", 1), pe[2] || (pe[2] = C("i", { class: "el-icon-info" }, null, -1))])]), _: 1 })]), default: p(({ row: { sourceRow: Oe } }) => {
      var Re;
      return [Oe.materialIsReturned ? (w(), U(we, { key: 0, modelValue: Oe.length, "onUpdate:modelValue": (fe) => Oe.length = fe, controls: false, max: +Oe.source.length, min: ((Re = l(u)) == null ? void 0 : Re.steelPlateShortestSideMinLength) || 0, precision: l(v).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min", "precision"])) : (w(), Q("span", bce, K(Oe.length), 1))];
    }), _: 1 }, 8, ["label"]), s(re, { label: `数量 (${l(v).measure.unit})`, align: "center", prop: "quantity", width: "110px" }, { default: p(({ row: { sourceRow: Oe } }) => [s(we, { modelValue: Oe.quantity, "onUpdate:modelValue": (Re) => Oe.quantity = Re, controls: false, max: Oe.materialIsReturned ? 9999999 : +Oe.source.quantity, min: 1, precision: l(v).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])]), _: 1 }, 8, ["label"]), s(re, { key: "detailMete", label: `余料总重(${l(v).weight.unit})`, align: "center", prop: "detailMete", width: "120px" }, { default: p(({ row: { sourceRow: Oe } }) => [C("span", null, K(Oe.boolReturns && Be(Oe.detailMete, l(v).weight.precision) || "-"), 1)]), _: 1 }, 8, ["label"]), s(re, { key: "mete", label: `总重 (${l(v).weight.unit})`, align: "center", prop: "mete", width: "120px" }, { default: p(({ row: { sourceRow: Oe } }) => [Oe.materialIsReturned ? (w(), U(ReturnPhysicalWeightInput, { key: 0, modelValue: Oe.mete, "onUpdate:modelValue": (Re) => Oe.mete = Re, controls: false, max: 999999999, min: 0, precision: l(v).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Vce, K(l(Be)(Oe.mete, l(v).weight.precision)), 1))]), _: 1 }, 8, ["label"]), s(rn, { fixed: "right", list: l(x).list, "return-destination": T.value }, null, 8, ["list", "return-destination"]), s(Nr, { showSourceRow: "", fixed: "right", label: "实际退库时间" }), s(re, { align: "center", fixed: "right", label: "操作", width: "120" }, { default: p(({ row: { sourceRow: Oe }, $index: Re }) => [Oe.boolReturns ? (w(), U(Ke, { key: 0, disabled: Oe.detailMete >= Oe.mete, icon: "el-icon-plus", size: "default", type: "primary", onClick: (fe) => Le(Oe) }, null, 8, ["disabled", "onClick"])) : H("", true), s(Ke, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (fe) => l(le)(Oe, Re) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["disabled", "model"])]);
  };
} }, a8 = ut(wce, [["__scopeId", "data-v-270f494c"]]), Sce = Object.freeze(Object.defineProperty({ __proto__: null, default: a8 }, Symbol.toStringTag, { value: "Module" }));
const vce = { class: "app-container" }, Rce = { key: 1 }, Mce = { key: 1 }, Ace = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const { realTimeValidate: n } = as(), c = o, u = e, r = { list: [] }, E = Z([]), y = Z(), b = Z(), V = Z(), M = Z([]), g = Z({}), { fixMaxHeight: S, maxHeight: h } = Kt({ paginate: false }), T = dt.SECTION_STEEL.V, { baseUnit: _ } = ai(T), f = Z([["source.project", ["parse-project", { onlyShortName: true }]]]), R = { length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: Vi, message: "长度必须大于0", trigger: "blur" }], mete: [{ validator: (ue, ne) => ue ? ne.boolReturns && !ne.remnantId ? !(!ne.detailMete || ne.detailMete > ue) : true : false, message: "请填写重量", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], realTime: [{ validator: n, message: "请选择实际退库时间", trigger: "change" }] }, { cu: v, form: N, FORM: P } = Pa({ title: "型材退库", formStore: !u.edit, formStoreKey: "WMS_RETURN_APPLICATION_SECTION_STEEL", permission: US, defaultForm: r, useDraftCallback: z, clearDraftCallback: oe, api: u.edit ? Nn : G4 }, V, u.detail);
  v.updateProp("boolRealReturn", u.detail && Object.prototype.hasOwnProperty.call(u.detail, "boolRealReturn") ? u.detail.boolRealReturn : true);
  const { calcMaxMete: L, extractSource: O, checkOverSource: x, initCheckOverMaxWeight: I } = Ws({ cu: v, form: N, basicClass: T, baseUnit: _ }), { currentSource: Y, currentUid: ee, delRow: B, handleRowClick: q } = Ys({ form: N, tableRef: b, delCallback: x }), { sourceReturnIds: ae, wrongCellMask: j } = Ks({ FORM: P, form: N, cu: v, emit: c, tableRules: R, init: oe, setFormCallback: z, isEdit: u.edit }), le = Ee(() => {
    var ue;
    return (ue = y.value) == null ? void 0 : ue.returnDestination;
  });
  Ce(() => N.list, () => {
    y.value && y.value.calcAllQuantity(), y.value && y.value.calcAllWeight(), y.value && y.value.calcAllLength();
  }, { deep: true });
  function oe() {
    N.list = [], Y.value = void 0, ee.value = void 0;
  }
  function ye(ue) {
    var de;
    Ce([() => ue.quantity], () => {
      ue.boolReturns || L(ue), y.value && y.value.calcAllQuantity();
    }, { immediate: true }), Ce([() => ue.length, _], () => {
      me(ue);
    }), Ce([() => ue.singleMete, () => ue.quantity], () => {
      k(ue), ue.boolReturns && Ie(ue), y.value && y.value.calcAllWeight();
    }), Ce([() => ue.length, () => ue.quantity], () => {
      J(ue), y.value && y.value.calcAllLength();
    }), Ce(() => ue.mete, () => {
      x(ue);
    }, { immediate: true }), se(ue, ue.source);
    const te = (N.list.filter((pe) => pe.boolReturns && !pe.remnantId) || []).map((pe) => pe.uid) || [];
    E.value = te, ue.boolReturns && ((de = ue.list) == null ? void 0 : de.length) > 0 && ue.list.map((pe) => {
      pe.realTime = ue.realTime || (/* @__PURE__ */ new Date()).getTime(), ce(pe);
    });
  }
  function ce(ue) {
    Ce([() => ue.length, _], () => {
      me(ue);
    }), Ce([() => ue.singleMete, () => ue.singleQuantity], () => {
      $(ue);
    }), Ce([() => ue.singleReturnMete], () => {
      X(ue);
    });
  }
  function se(ue, ne) {
    var te, de;
    ue.length = ue.length || ne.length, ue.quantity = ue.quantity || ne.quantity, ue.workshopId = ue.workshopId || ((te = ne.workshop) == null ? void 0 : te.id), ue.warehouseId = ue.warehouseId || ((de = ne.warehouse) == null ? void 0 : de.id), me(ue), setTimeout(() => {
      ue.mete = ue.mete || ne.mete;
    });
  }
  function he(ue) {
    const ne = JSON.parse(JSON.stringify(ue));
    delete ne.list, ue.list.length > 0 && (ne.workshopId = -1, ne.warehouseId = -1);
    const te = Ct({ ...ne, pid: ne.uid, singleQuantity: void 0, singleReturnMete: void 0, quantity: void 0, mete: void 0, length: void 0, uid: Tt() });
    ue.list.push(te), ce(te);
  }
  function be(ue, ne) {
    const te = N.list.find((de) => de.uid === ue.pid) || {};
    A(te.list) && (te.detailMete = Be(te.detailMete - (ue.mete || 0), returnPhysicalPrecision(_.value.weight.unit)), te.list.splice(ne, 1));
  }
  async function me(ue) {
    ue.theoryWeight = await xa({ length: ue.length, unitWeight: ue.source.unitWeight }), ue.theoryWeight ? ue.singleMete = Be(ue.theoryWeight / ue.source.theoryWeight * ue.source.singleMete, returnPhysicalPrecision(_.value.weight.unit)) : ue.singleMete = void 0;
  }
  function ge(ue) {
    let ne = 0;
    return N.list.forEach((te) => {
      ue.source.id === te.source.id && (ne += Number(te.quantity) || 0);
    }), ue.source.quantity - ne;
  }
  function Le(ue) {
    let ne = 0;
    return N.list.forEach((te) => {
      ue.source.id === te.source.id && (ne += Number(te.mete) || 0);
    }), ue.source.sourceReturnableMete - ne;
  }
  function Ie(ue) {
    const ne = N.list.find((te) => te.uid === ue.uid) || {};
    if (A(ne.list)) {
      let te = 0;
      ne.list.forEach((de) => {
        de.singleReturnMete && (te += de.singleReturnMete);
      }), ne.detailMete = te ? Be(te, returnPhysicalPrecision(_.value.weight.unit)) * (ne.quantity || 0) : 0;
    } else ne.detailMete = 0;
  }
  function Se(ue) {
    g.value = ue, q(ue);
  }
  function X(ue) {
    const ne = N.list.find((te) => te.uid === ue.pid) || {};
    if (A(ne.list)) {
      let te = 0;
      ne.list.forEach((de) => {
        de.singleReturnMete && (te += de.singleReturnMete);
      }), ne.detailMete = te ? Be(te, returnPhysicalPrecision(_.value.weight.unit)) * (ne.quantity || 0) : 0;
    }
  }
  function $(ue) {
    A(ue.singleMete) && ue.singleQuantity ? (ue.singleReturnMete = Be(ue.singleMete * ue.singleQuantity, returnPhysicalPrecision(_.value.weight.unit)), ue.singleReturnMete > ue.maxMete && ue.singleReturnMete > ue.singleMete && (ue.singleReturnMete = Be(Math.min(ue.maxMete, ue.singleMete), returnPhysicalPrecision(_.value.weight.unit)))) : ue.singleReturnMete = void 0;
  }
  function k(ue) {
    if (A(ue.singleMete) && ue.quantity) {
      ue.mete = Be(ue.singleMete * ue.quantity, returnPhysicalPrecision(_.value.weight.unit));
      const ne = ge(ue);
      if (!ue.pid) {
        const te = Be(Number(ue.source.sourceReturnableMete), returnPhysicalPrecision(_.value.weight.unit));
        if (Number(ue.quantity) === Number(ue.source.quantity)) Number(ue.length) === Number(ue.source.length) && (!ue.materialIsReturned && !ue.boolReturns || ue.source.sourceReturnableMete < ue.mete || ue.mete === te) && (ue.mete = Number(ue.source.sourceReturnableMete));
        else if (ne === 0) {
          const de = Le(ue);
          ue.mete = returnPhysicalRound(ue.mete + de, _.value.weight.unit);
        }
      }
    } else ue.mete = void 0;
  }
  function J(ue) {
    A(ue.length) && ue.quantity ? ue.totalLength = Na({ length: ue.length, quantity: ue.quantity }) : ue.totalLength = void 0;
  }
  function z(ue) {
    ue.list = ue.list.map((te) => Ct(te));
    const ne = Ce([b, y, _], ([te, de, pe]) => {
      te && de && pe && (O(ue.list), I(ue.list), ue.list.forEach((re) => {
        ye(re), re.boolReturns && A(re.list) && re.list.forEach((we) => {
          ce(we);
        }), x(re), J(re);
      }), pt(() => {
        ne(), y.value.calcAllQuantity(), y.value.calcAllWeight(), y.value.calcAllLength();
      }));
    }, { immediate: true, deep: true });
    S();
  }
  function F() {
    const ue = [];
    M.value = [], N.list.forEach((te) => {
      te.boolReturns && !te.remnantId && (A(te.list) ? te.list.forEach((de) => {
        (!de.length || !de.singleQuantity || !de.singleMete || !de.warehouseId) && (ue.includes(de.pid) || ue.push(de.pid));
      }) : ue.includes(te.uid) || ue.push(te.uid));
    });
    let ne = true;
    return A(ue) && (M.value = ue, E.value = ue, ot.error("表格展开项红色部分余料退库明细填写不全，请修正"), ne = false), ne;
  }
  function G() {
    const ue = [];
    return M.value = [], N.list.forEach((ne) => {
      ne.boolReturns && !ne.remnantId && ne.detailMete > ne.mete && (ue.includes(ne.uid) || ue.push(ne.uid));
    }), A(ue) ? (M.value = ue, E.value = ue, ot.error("表格展开项余料总重量不能超过钢板总量，请修正"), false) : true;
  }
  function ie() {
    let ue = F();
    ue && (ue = G()), ue && (N.list.forEach((ne) => {
      ne.remnantId && (ne.boolReturns = true);
    }), v.submit());
  }
  return (ue, ne) => {
    const te = vt, de = Ve("common-input-number"), pe = Ve("common-button"), re = Ve("common-table"), we = Mt, Ke = Li;
    return w(), Q("div", vce, [s(ls, { ref_key: "headerRef", ref: y, "basic-class": l(T), "current-source": l(A)(l(N).list) ? l(Y) : {}, currentPlateRow: l(A)(l(N).list) ? g.value : {}, edit: u.edit, list: l(N).list, "source-return-ids": l(ae), onReset: oe, onAdd: ye, onSubmit: ie }, null, 8, ["basic-class", "current-source", "currentPlateRow", "edit", "list", "source-return-ids"]), s(Ke, { ref_key: "formRef", ref: V, disabled: l(v).status.edit === l(P).STATUS.PROCESSING, model: l(N) }, { default: p(() => [s(re, { ref_key: "tableRef", ref: b, "cell-class-name": l(j), data: l(N).list, "data-format": f.value, "default-expand-all": false, "expand-row-keys": E.value, "max-height": l(h), stripe: false, "highlight-current-row": "", "row-key": "uid", onRowClick: Se }, { default: p(() => [s(Ha, { "expand-row-keys": E.value, "onUpdate:expandRowKeys": ne[0] || (ne[0] = (Me) => E.value = Me), data: l(N).list, "row-key": "uid" }, { default: p(({ row: { sourceRow: Me } }) => [C("div", { style: ri(`padding-bottom:10px;background:${M.value.includes(Me.uid) ? "#ff000021" : l(ee) === Me.uid ? "#f4f4f5" : ""};`) }, [Me.boolReturns && !Me.remnantId && (Me.uid || Me.id) ? (w(), U(re, { key: Me.uid, class: Zt(M.value.includes(Me.uid) ? "error-table" : l(ee) === Me.uid ? "child-table" : ""), data: Me.list, stripe: false, style: { "margin-bottom": "10px" } }, { default: p(() => [s(te, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), (w(), U(jo, { key: Me.uid, "basic-class": l(T), "show-index": false, "show-length": false, "show-project": false, "show-thickness": false, "show-width": false, field: "source", "party-a-position": "project" }, null, 8, ["basic-class"])), s(Wo, { "basic-class": l(T), field: "source" }, null, 8, ["basic-class"]), s(te, { label: `定尺长度 (${l(_).length.unit})`, align: "center", prop: "length", width: "135px" }, { default: p(({ row: { sourceRow: Ne } }) => [s(de, { modelValue: Ne.length, "onUpdate:modelValue": (He) => Ne.length = He, controls: false, max: +Ne.source.singleReturnableLength, min: 0, precision: l(_).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])]), _: 2 }, 1032, ["label"]), s(te, { label: `数量 (${l(_).measure.unit})`, align: "center", prop: "singleQuantity", width: "110px" }, { default: p(({ row: { sourceRow: Ne } }) => [s(de, { modelValue: Ne.singleQuantity, "onUpdate:modelValue": (He) => Ne.singleQuantity = He, controls: false, max: 9999999, min: 1, precision: l(_).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 2 }, 1032, ["label"]), s(te, { key: "singleReturnMete", label: `总重 (${l(_).weight.unit})`, align: "center", prop: "singleReturnMete", width: "120px" }, { default: p(({ row: { sourceRow: Ne } }) => [s(ReturnPhysicalWeightInput, { modelValue: Ne.singleReturnMete, "onUpdate:modelValue": (He) => Ne.singleReturnMete = He, controls: false, max: 9999999, min: 0, precision: l(_).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 2 }, 1032, ["label"]), s(rn, { list: Me.list, "return-destination": le.value, "warehouse-set-type": "small", warehouseWidth: 100 }, null, 8, ["list", "return-destination"]), s(te, { align: "center", label: "操作", width: "70", fixed: "right" }, { default: p(({ row: { sourceRow: Ne }, $index: He }) => [s(pe, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ze) => be(Ne, He) }, null, 8, ["onClick"])]), _: 2 }, 1024)]), _: 2 }, 1032, ["class", "data"])) : H("", true), s(we, { modelValue: Me.remark, "onUpdate:modelValue": (Ne) => Me.remark = Ne, autosize: { minRows: 2, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "50%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])], 4)]), _: 1 }, 8, ["expand-row-keys", "data"]), s(jo, { "basic-class": l(T), "show-length": false, field: "source", "party-a-position": "project", "show-project": "" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": l(T), field: "source" }, null, 8, ["basic-class"]), s(te, { label: `定尺长度 (${l(_).length.unit})`, align: "center", prop: "length", width: "110px" }, { default: p(({ row: { sourceRow: Me } }) => [Me.materialIsReturned ? (w(), U(de, { key: 0, modelValue: Me.length, "onUpdate:modelValue": (Ne) => Me.length = Ne, controls: false, max: +Me.source.singleReturnableLength, min: 0, precision: l(_).length.precision, size: "default", placeholder: "长" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (w(), Q("span", Rce, K(Me.length), 1))]), _: 1 }, 8, ["label"]), s(te, { label: `数量 (${l(_).measure.unit})`, align: "center", prop: "quantity", width: "110px" }, { default: p(({ row: { sourceRow: Me } }) => [s(de, { modelValue: Me.quantity, "onUpdate:modelValue": (Ne) => Me.quantity = Ne, controls: false, max: Me.materialIsReturned ? 9999999 : +Me.source.quantity, min: 1, precision: l(_).measure.precision, size: "default", step: 1, "controls-position": "right", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])]), _: 1 }, 8, ["label"]), s(te, { key: "detailMete", label: `余料总重(${l(_).weight.unit})`, align: "center", prop: "detailMete", width: "120px" }, { default: p(({ row: { sourceRow: Me } }) => [C("span", null, K(Me.boolReturns && Be(Me.detailMete, l(_).weight.precision) || "-"), 1)]), _: 1 }, 8, ["label"]), s(te, { key: "mete", label: `总重 (${l(_).weight.unit})`, align: "center", prop: "mete", width: "120px" }, { default: p(({ row: { sourceRow: Me } }) => [Me.materialIsReturned ? (w(), U(ReturnPhysicalWeightInput, { key: 0, modelValue: Me.mete, "onUpdate:modelValue": (Ne) => Me.mete = Ne, controls: false, max: +Me.source.mete, min: 0, precision: l(_).weight.precision, size: "default", "controls-position": "right", placeholder: "重量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])) : (w(), Q("span", Mce, K(Be(Me.mete, l(_).weight.precision)), 1))]), _: 1 }, 8, ["label"]), s(rn, { list: l(N).list, "return-destination": le.value }, null, 8, ["list", "return-destination"]), s(Nr, { showSourceRow: "", label: "实际退库时间" }), s(te, { align: "center", fixed: "right", label: "操作", width: "120" }, { default: p(({ row: { sourceRow: Me }, $index: Ne }) => [Me.boolReturns ? (w(), U(pe, { key: 0, disabled: Me.detailMete >= Me.mete, icon: "el-icon-plus", size: "default", type: "primary", onClick: (He) => he(Me) }, null, 8, ["disabled", "onClick"])) : H("", true), s(pe, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (He) => l(B)(Me, Ne) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["disabled", "model"])]);
  };
} }, l8 = ut(Ace, [["__scopeId", "data-v-2f2b5df3"]]), Nce = Object.freeze(Object.defineProperty({ __proto__: null, default: l8 }, Symbol.toStringTag, { value: "Module" }));
const Lce = { class: "app-container" }, Ice = { class: "mtb-10" }, Cce = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const { realTimeValidate: n } = as(), c = Ht(), u = o, r = e, E = { list: [] }, y = Z([]), b = Z(), V = Z(), M = Z(), g = Z([["source.project", ["parse-project", { onlyShortName: true }]]]), { fixMaxHeight: S, maxHeight: h } = Kt({ paginate: false }), T = dt.STEEL_COIL.V, { baseUnit: _ } = ai(T), f = { mete: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], realTime: [{ validator: n, message: "请选择实际退库时间", trigger: "change" }] }, { cu: m, form: R, FORM: v } = Pa({ title: "钢卷退库", formStore: !r.edit, formStoreKey: "WMS_RETURN_APPLICATION_STEEL_COIL", permission: YS, defaultForm: E, useDraftCallback: ye, clearDraftCallback: ae, api: r.edit ? Nn : Q4 }, M, r.detail);
  m.updateProp("boolRealReturn", r.detail && Object.prototype.hasOwnProperty.call(r.detail, "boolRealReturn") ? r.detail.boolRealReturn : true);
  const { extractSource: N, checkOverSource: P, initCheckOverMaxWeight: L } = Ws({ cu: m, form: R, basicClass: T }), { currentSource: O, currentUid: x, delRow: I, handleRowClick: Y } = Ys({ form: R, tableRef: V, delCallback: P }), { sourceReturnIds: ee, wrongCellMask: B } = Ks({ FORM: v, form: R, cu: m, emit: u, tableRules: f, init: ae, setFormCallback: ye, isEdit: r.edit }), q = Ee(() => {
    var ce;
    return (ce = b.value) == null ? void 0 : ce.returnDestination;
  });
  Ce(() => R.list, () => {
    b.value && b.value.calcAllQuantity(), b.value && b.value.calcAllWeight();
  }, { deep: true });
  function ae() {
    R.list = [], O.value = void 0, x.value = void 0;
  }
  function j(ce) {
    le(ce, ce.source), Ce([() => ce.quantity], () => {
      b.value && b.value.calcAllQuantity();
    }), Ce([() => ce.mete, _], () => {
      oe(ce), b.value && b.value.calcAllWeight();
    }), Ce(() => ce.mete, () => {
      P(ce);
    }, { immediate: true });
  }
  function le(ce, se) {
    var he, be;
    ce.mete = ce.mete || se.mete, ce.quantity = ce.quantity || se.quantity, ce.workshopId = ce.workshopId || ((he = se.workshop) == null ? void 0 : he.id), ce.warehouseId = ce.warehouseId || ((be = se.warehouse) == null ? void 0 : be.id);
  }
  async function oe(ce) {
    ce.mete ? ce.singleLength = +ji(ce.mete / ce.source.singleReturnableMete * ce.source.quantity, _.value.length.precision) : ce.singleLength = void 0, ce.quantity = ce.singleLength;
  }
  function ye(ce) {
    ce.list = ce.list.map((he) => Ct(he));
    const se = Ce([V, b, _], ([he, be, me]) => {
      he && be && me && (N(ce.list), L(ce.list), ce.list.forEach((ge) => {
        j(ge), P(ge);
      }), pt(() => {
        se(), b.value.calcAllQuantity(), b.value.calcAllWeight();
      }));
    }, { immediate: true, deep: true });
    S();
  }
  return El(async () => {
    await c.dispatch("wms/fetchSteelDensityCfg");
  }), (ce, se) => {
    const he = Mt, be = Ve("common-input-number"), me = vt, ge = Ve("common-button"), Le = Ve("common-table"), Ie = Li;
    return w(), Q("div", Lce, [s(ls, { ref_key: "headerRef", ref: b, "basic-class": l(T), "current-source": l(O), edit: r.edit, list: l(R).list, "source-return-ids": l(ee), onAdd: j, onReset: ae }, null, 8, ["basic-class", "current-source", "edit", "list", "source-return-ids"]), s(Ie, { ref_key: "formRef", ref: M, disabled: l(m).status.edit === l(v).STATUS.PROCESSING, model: l(R) }, { default: p(() => [s(Le, { ref_key: "tableRef", ref: V, "cell-class-name": l(B), data: l(R).list, "data-format": g.value, "default-expand-all": false, "expand-row-keys": y.value, "max-height": l(h), stripe: false, "highlight-current-row": "", "row-key": "uid", onRowClick: l(Y) }, { default: p(() => [s(Ha, { "expand-row-keys": y.value, "onUpdate:expandRowKeys": se[0] || (se[0] = (Se) => y.value = Se), data: l(R).list, "row-key": "uid" }, { default: p(({ row: { sourceRow: Se } }) => [C("div", Ice, [s(he, { modelValue: Se.remark, "onUpdate:modelValue": (X) => Se.remark = X, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(jo, { "basic-class": l(T), field: "source", "party-a-position": "project", "show-project": "" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": l(T), field: "source" }, null, 8, ["basic-class"]), s(me, { key: "mete", label: `重量 (${l(_).weight.unit})`, align: "center", prop: "mete", width: "120px" }, { default: p(({ row: { sourceRow: Se } }) => [s(ReturnPhysicalWeightInput, { modelValue: Se.mete, "onUpdate:modelValue": (X) => Se.mete = X, controls: false, max: +Se.source.singleReturnableMete, min: 0, precision: l(_).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"])]), _: 1 }, 8, ["label"]), s(rn, { list: l(R).list, "return-destination": q.value }, null, 8, ["list", "return-destination"]), s(Nr, { showSourceRow: "", label: "实际退库时间" }), s(me, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: { sourceRow: Se }, $index: X }) => [s(ge, { icon: "el-icon-delete", size: "default", type: "danger", onClick: ($) => l(I)(Se, X) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height", "onRowClick"])]), _: 1 }, 8, ["disabled", "model"])]);
  };
} }, o8 = ut(Cce, [["__scopeId", "data-v-066e90d9"]]), Pce = Object.freeze(Object.defineProperty({ __proto__: null, default: o8 }, Symbol.toStringTag, { value: "Module" }));
const Oce = { class: "app-container" }, kce = { class: "mtb-10" }, Dce = { key: 1 }, xce = { key: 1 }, Uce = { key: 1 }, Yce = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const n = o, c = e, u = { list: [] }, r = Z([]), E = Z(), y = Z(), b = Z(), V = Z([["source.project", ["parse-project", { onlyShortName: true }]]]), { fixMaxHeight: M, maxHeight: g } = Kt({ paginate: false }), S = Ci.OTHER_STEEL_MATERIALS.V, T = { mete: [{ required: true, message: "请填写核算量" }, { pattern: Vi, message: "核算量必须大于0" }], quantity: [{ validator: (ye, ce) => ce.measureUnit ? !!ye : true, message: "有计量单位，数量必须大于0" }], workshopId: [{ required: true, message: "请选择车间" }], warehouseId: [{ required: true, message: "请选择存储位置" }] }, { cu: _, form: f, FORM: m } = Pa({ title: "其它钢材退库", formStore: !c.edit, formStoreKey: "WMS_RETURN_APPLICATION_OTHER_STEEL", permission: _D, defaultForm: u, useDraftCallback: oe, clearDraftCallback: B, api: c.edit ? Nn : $4 }, b, c.detail);
  _.updateProp("boolRealReturn", c.detail && Object.prototype.hasOwnProperty.call(c.detail, "boolRealReturn") ? c.detail.boolRealReturn : true);
  const { calcMaxMete: R, extractSource: v, checkOverSource: N, initCheckOverMaxWeight: P } = Ws({ cu: _, form: f, basicClass: S }), { currentSource: L, currentUid: O, delRow: x, handleRowClick: I } = Ys({ form: f, tableRef: y, delCallback: N }), { sourceReturnIds: Y, wrongCellMask: ee } = Ks({ FORM: m, form: f, cu: _, emit: n, tableRules: T, init: B, setFormCallback: oe, isEdit: c.edit });
  function B() {
    f.list = [], L.value = void 0, O.value = void 0, _.props.abnormalList = void 0;
  }
  function q(ye) {
    ae(ye, ye.source), Ce([() => ye.quantity], () => {
      R(ye);
    }), Ce(() => ye.mete, () => {
      N(ye);
    }, { immediate: true });
  }
  function ae(ye, ce) {
    var se, he;
    ye.mete = ye.mete || ce.mete, ye.quantity = ye.quantity || ce.quantity, ye.workshopId = ye.workshopId || ((se = ce.workshop) == null ? void 0 : se.id), ye.warehouseId = ye.warehouseId || ((he = ce.warehouse) == null ? void 0 : he.id);
  }
  function j(ye, ce) {
    A(ce) ? ye.mete = Be(ce / +ye.source.quantity * ye.source.sourceReturnableMete, ye.accountingPrecision) : ye.mete = void 0;
  }
  function le(ye, ce) {
    ye.measureUnit && A(ce) ? ye.quantity = Be(ce / +ye.source.sourceReturnableMete * ye.source.quantity, ye.measurePrecision) : ye.quantity = void 0;
  }
  function oe(ye) {
    ye.list = ye.list.map((se) => Ct(se));
    const ce = Ce([y, E], ([se, he]) => {
      se && he && (v(ye.list), P(ye.list), ye.list.forEach((be) => {
        q(be), N(be);
      }), pt(() => {
        ce();
      }));
    }, { immediate: true, deep: true });
    M();
  }
  return (ye, ce) => {
    const se = Mt, he = vt, be = Ve("common-input-number"), me = Ve("common-button"), ge = Ve("common-table"), Le = Li;
    return w(), Q("div", Oce, [s(ls, { ref_key: "headerRef", ref: E, edit: c.edit, "basic-class": l(S), list: l(f).list, "current-source": l(L), "source-return-ids": l(Y), onAdd: q }, null, 8, ["edit", "basic-class", "list", "current-source", "source-return-ids"]), s(Le, { ref_key: "formRef", ref: b, model: l(f), disabled: l(_).status.edit === l(m).STATUS.PROCESSING }, { default: p(() => [s(ge, { ref_key: "tableRef", ref: y, data: l(f).list, "data-format": V.value, "max-height": l(g), "default-expand-all": false, stripe: false, "cell-class-name": l(ee), "expand-row-keys": r.value, "row-key": "uid", "highlight-current-row": "", onRowClick: l(I) }, { default: p(() => [s(Ha, { data: l(f).list, "expand-row-keys": r.value, "onUpdate:expandRowKeys": ce[0] || (ce[0] = (Ie) => r.value = Ie), "row-key": "uid", fixed: "left" }, { default: p(({ row: { sourceRow: Ie } }) => [C("div", kce, [s(se, { modelValue: Ie.remark, "onUpdate:modelValue": (Se) => Ie.remark = Se, rows: 1, autosize: { minRows: 1, maxRows: 1 }, type: "textarea", placeholder: "备注", maxlength: "200", "show-word-limit": "", style: { width: "400px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(jo, { "basic-class": l(S), field: "source", fixed: "left", "show-project": "", "party-a-position": "project" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": l(S), field: "source", fixed: "left" }, null, 8, ["basic-class"]), s(he, { prop: "measureUnit", label: "计量单位", align: "center", "min-width": "70px" }), s(he, { prop: "quantity", label: "数量", align: "center", "min-width": "120px" }, { default: p(({ row: { sourceRow: Ie } }) => [Ie.measureUnit ? (w(), Q(Qe, { key: 0 }, [Ie.outboundUnitType === l(hi).MEASURE.V ? (w(), U(be, { key: 0, modelValue: Ie.quantity, "onUpdate:modelValue": (Se) => Ie.quantity = Se, min: 0, max: +Ie.source.quantity, controls: false, step: 1, precision: +Ie.measurePrecision, size: "default", placeholder: "数量", onChange: (Se) => j(Ie, Se) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", Dce, K(Ie.quantity || 0), 1))], 64)) : (w(), Q("span", xce, "-"))]), _: 1 }), s(he, { prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }), s(he, { prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: p(({ row: { sourceRow: Ie } }) => [Ie.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(be, { key: 0, modelValue: Ie.mete, "onUpdate:modelValue": (Se) => Ie.mete = Se, min: 0, max: +Ie.source.sourceReturnableMete, controls: false, step: 1, precision: Ie.accountingPrecision, size: "default", placeholder: "核算量", onChange: (Se) => le(Ie, Se) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", Uce, K(Ie.mete || 0), 1))]), _: 1 }), s(rn, { list: l(f).list }, null, 8, ["list"]), s(he, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: p(({ row: { sourceRow: Ie }, $index: Se }) => [s(me, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (X) => l(x)(Ie, Se) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "cell-class-name", "expand-row-keys", "onRowClick"])]), _: 1 }, 8, ["model", "disabled"])]);
  };
} }, n8 = ut(Yce, [["__scopeId", "data-v-6ad9a4d8"]]), Kce = Object.freeze(Object.defineProperty({ __proto__: null, default: n8 }, Symbol.toStringTag, { value: "Module" }));
const Wce = { class: "app-container" }, jce = { class: "mtb-10" }, Fce = { key: 1 }, zce = { key: 1 }, Bce = { key: 1 }, Hce = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const { realTimeValidate: n } = as(), c = o, u = e, r = { list: [] }, E = Z([]), y = Z(), b = Z(), V = Z(), M = Z([["source.project", ["parse-project", { onlyShortName: true }]]]), { fixMaxHeight: g, maxHeight: S } = Kt({ paginate: false }), h = dt.MATERIAL.V, _ = { mete: [{ required: true, message: "请填写核算量" }, { pattern: Vi, message: "核算量必须大于0" }], quantity: [{ validator: (se, he) => he.measureUnit ? !!se : true, message: "有计量单位，数量必须大于0" }], workshopId: [{ required: true, message: "请选择车间" }], warehouseId: [{ required: true, message: "请选择存储位置" }], realTime: [{ validator: n, message: "请选择实际退库时间", trigger: "change" }] }, { cu: f, form: m, FORM: R } = Pa({ title: "辅材退库", formStore: !u.edit, formStoreKey: "WMS_RETURN_APPLICATION_AUX_MATERIAL", permission: KS, defaultForm: r, useDraftCallback: ce, clearDraftCallback: ae, api: u.edit ? Nn : Z4 }, V, u.detail);
  f.updateProp("boolRealReturn", u.detail && Object.prototype.hasOwnProperty.call(u.detail, "boolRealReturn") ? u.detail.boolRealReturn : true);
  const { calcMaxMete: v, extractSource: N, checkOverSource: P, initCheckOverMaxWeight: L } = Ws({ cu: f, form: m, basicClass: h }), { currentSource: O, currentUid: x, delRow: I, handleRowClick: Y } = Ys({ form: m, tableRef: b, delCallback: P }), { sourceReturnIds: ee, wrongCellMask: B } = Ks({ FORM: R, form: m, cu: f, emit: c, tableRules: _, init: ae, setFormCallback: ce, isEdit: u.edit }), q = Ee(() => {
    var se;
    return (se = y.value) == null ? void 0 : se.returnDestination;
  });
  function ae() {
    m.list = [], O.value = void 0, x.value = void 0, f.props.abnormalList = void 0;
  }
  function j(se) {
    le(se, se.source), Ce([() => se.quantity], () => {
      v(se);
    }), Ce(() => se.mete, () => {
      P(se);
    }, { immediate: true });
  }
  function le(se, he) {
    var be, me;
    se.mete = se.mete || se.returnableMete || he.returnableMete, se.quantity = se.quantity || he.quantity, se.workshopId = se.workshopId || ((be = he.workshop) == null ? void 0 : be.id), se.warehouseId = se.warehouseId || ((me = he.warehouse) == null ? void 0 : me.id);
  }
  function oe(se, he) {
    A(he) ? se.mete = Be(he / +se.source.quantity * se.source.sourceReturnableMete, se.accountingPrecision) : se.mete = void 0;
  }
  function ye(se, he) {
    se.measureUnit && A(he) ? se.quantity = Be(he / +se.source.sourceReturnableMete * se.source.quantity, se.measurePrecision) : se.quantity = void 0;
  }
  function ce(se) {
    se.list = se.list.map((be) => Ct(be));
    const he = Ce([b, y], ([be, me]) => {
      be && me && (N(se.list), L(se.list), se.list.forEach((ge) => {
        j(ge), P(ge);
      }), pt(() => {
        he();
      }));
    }, { immediate: true, deep: true });
    g();
  }
  return (se, he) => {
    const be = Mt, me = vt, ge = Ve("common-input-number"), Le = Ve("common-button"), Ie = Ve("common-table"), Se = Li;
    return w(), Q("div", Wce, [s(ls, { ref_key: "headerRef", ref: y, edit: u.edit, "basic-class": l(h), list: l(m).list, "current-source": l(O), "source-return-ids": l(ee), onReset: ae, onAdd: j }, null, 8, ["edit", "basic-class", "list", "current-source", "source-return-ids"]), s(Se, { ref_key: "formRef", ref: V, model: l(m), disabled: l(f).status.edit === l(R).STATUS.PROCESSING }, { default: p(() => [s(Ie, { ref_key: "tableRef", ref: b, data: l(m).list, "data-format": M.value, "max-height": l(S), "default-expand-all": false, stripe: false, "cell-class-name": l(B), "expand-row-keys": E.value, "row-key": "uid", "highlight-current-row": "", onRowClick: l(Y) }, { default: p(() => [s(Ha, { data: l(m).list, "expand-row-keys": E.value, "onUpdate:expandRowKeys": he[0] || (he[0] = (X) => E.value = X), "row-key": "uid", fixed: "left" }, { default: p(({ row: { sourceRow: X } }) => [C("div", jce, [s(be, { modelValue: X.remark, "onUpdate:modelValue": ($) => X.remark = $, rows: 1, autosize: { minRows: 1, maxRows: 1 }, type: "textarea", placeholder: "备注", maxlength: "200", "show-word-limit": "", style: { width: "400px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(jo, { "basic-class": l(h), field: "source", "party-a-position": "project", "show-project": "" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": l(h), field: "source" }, null, 8, ["basic-class"]), s(me, { align: "center", label: "计量单位", "min-width": "70px", prop: "measureUnit" }), s(me, { align: "center", label: "数量", "min-width": "120px", prop: "quantity" }, { default: p(({ row: { sourceRow: X } }) => [X.measureUnit ? (w(), Q(Qe, { key: 0 }, [X.outboundUnitType === l(hi).MEASURE.V ? (w(), U(ge, { key: 0, modelValue: X.quantity, "onUpdate:modelValue": ($) => X.quantity = $, min: 0, max: +X.source.quantity, controls: false, step: 1, precision: +X.measurePrecision, size: "default", placeholder: "数量", onChange: ($) => oe(X, $) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", Fce, K(X.quantity || 0), 1))], 64)) : (w(), Q("span", zce, "-"))]), _: 1 }), s(me, { prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }), s(me, { prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: p(({ row: { sourceRow: X } }) => [X.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(ge, { key: 0, modelValue: X.mete, "onUpdate:modelValue": ($) => X.mete = $, min: 0, max: +X.source.sourceReturnableMete, controls: false, step: 1, precision: X.accountingPrecision, size: "default", placeholder: "核算量", onChange: ($) => ye(X, $) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", Bce, K(X.mete || 0), 1))]), _: 1 }), s(rn, { list: l(m).list, "return-destination": q.value }, null, 8, ["list", "return-destination"]), s(Nr, { showSourceRow: "", label: "实际退库时间" }), s(me, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: p(({ row: { sourceRow: X }, $index: $ }) => [s(Le, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (k) => l(I)(X, $) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "cell-class-name", "expand-row-keys", "onRowClick"])]), _: 1 }, 8, ["model", "disabled"])]);
  };
} }, s8 = ut(Hce, [["__scopeId", "data-v-bdd8b1b5"]]), qce = Object.freeze(Object.defineProperty({ __proto__: null, default: s8 }, Symbol.toStringTag, { value: "Module" }));
const Gce = { class: "app-container" }, Qce = { class: "mtb-10" }, Zce = { key: 1 }, Jce = { key: 1 }, Xce = { key: 1 }, $ce = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const { realTimeValidate: n } = as(), c = o, u = e, r = { list: [] }, E = Z([]), y = Z(), b = Z(), V = Z(), M = Z([["source.project", ["parse-project", { onlyShortName: true }]]]), { fixMaxHeight: g, maxHeight: S } = Kt({ paginate: false }), h = dt.GAS.V, _ = { mete: [{ required: true, message: "请填写核算量" }, { pattern: Vi, message: "核算量必须大于0" }], quantity: [{ validator: (se, he) => he.measureUnit ? !!se : true, message: "有计量单位，数量必须大于0" }], workshopId: [{ required: true, message: "请选择车间" }], warehouseId: [{ required: true, message: "请选择存储位置" }], realTime: [{ validator: n, message: "请选择实际退库时间", trigger: "change" }] }, { cu: f, form: m, FORM: R } = Pa({ title: "气体退库", formStore: !u.edit, formStoreKey: "WMS_RETURN_APPLICATION_GAS", permission: WS, defaultForm: r, useDraftCallback: ce, clearDraftCallback: ae, api: u.edit ? Nn : X4 }, V, u.detail);
  f.updateProp("boolRealReturn", u.detail && Object.prototype.hasOwnProperty.call(u.detail, "boolRealReturn") ? u.detail.boolRealReturn : true);
  const { calcMaxMete: v, extractSource: N, checkOverSource: P, initCheckOverMaxWeight: L } = Ws({ cu: f, form: m, basicClass: h }), { currentSource: O, currentUid: x, delRow: I, handleRowClick: Y } = Ys({ form: m, tableRef: b, delCallback: P }), { sourceReturnIds: ee, wrongCellMask: B } = Ks({ FORM: R, form: m, cu: f, emit: c, tableRules: _, init: ae, setFormCallback: ce, isEdit: u.edit }), q = Ee(() => {
    var se;
    return (se = y.value) == null ? void 0 : se.returnDestination;
  });
  function ae() {
    m.list = [], O.value = void 0, x.value = void 0;
  }
  function j(se) {
    le(se, se.source), Ce([() => se.quantity], () => {
      v(se);
    }), Ce(() => se.mete, () => {
      P(se);
    }, { immediate: true });
  }
  function le(se, he) {
    var be, me;
    se.mete = se.mete || se.returnableMete || he.returnableMete, se.quantity = se.quantity || he.quantity, se.workshopId = se.workshopId || ((be = he.workshop) == null ? void 0 : be.id), se.warehouseId = se.warehouseId || ((me = he.warehouse) == null ? void 0 : me.id);
  }
  function oe(se, he) {
    A(he) ? se.mete = Be(he / +se.source.quantity * se.source.sourceReturnableMete, se.accountingPrecision) : se.mete = void 0;
  }
  function ye(se, he) {
    se.measureUnit && A(he) ? se.quantity = Be(he / +se.source.sourceReturnableMete * se.source.quantity, se.measurePrecision) : se.quantity = void 0;
  }
  function ce(se) {
    se.list = se.list.map((be) => Ct(be));
    const he = Ce([b, y], ([be, me]) => {
      be && me && (N(se.list), L(se.list), se.list.forEach((ge) => {
        j(ge), P(ge);
      }), pt(() => {
        he();
      }));
    }, { immediate: true, deep: true });
    g();
  }
  return (se, he) => {
    const be = Mt, me = vt, ge = Ve("common-input-number"), Le = Ve("common-button"), Ie = Ve("common-table"), Se = Li;
    return w(), Q("div", Gce, [s(ls, { ref_key: "headerRef", ref: y, edit: u.edit, "basic-class": l(h), list: l(m).list, "current-source": l(O), "source-return-ids": l(ee), onReset: ae, onAdd: j }, null, 8, ["edit", "basic-class", "list", "current-source", "source-return-ids"]), s(Se, { ref_key: "formRef", ref: V, model: l(m), disabled: l(f).status.edit === l(R).STATUS.PROCESSING }, { default: p(() => [s(Ie, { ref_key: "tableRef", ref: b, data: l(m).list, "data-format": M.value, "max-height": l(S), "default-expand-all": false, stripe: false, "cell-class-name": l(B), "expand-row-keys": E.value, "row-key": "uid", "highlight-current-row": "", onRowClick: l(Y) }, { default: p(() => [s(Ha, { data: l(m).list, "expand-row-keys": E.value, "onUpdate:expandRowKeys": he[0] || (he[0] = (X) => E.value = X), "row-key": "uid", fixed: "left" }, { default: p(({ row: { sourceRow: X } }) => [C("div", Qce, [s(be, { modelValue: X.remark, "onUpdate:modelValue": ($) => X.remark = $, rows: 1, autosize: { minRows: 1, maxRows: 1 }, type: "textarea", placeholder: "备注", maxlength: "200", "show-word-limit": "", style: { width: "400px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(jo, { "basic-class": l(h), field: "source", "party-a-position": "project", "show-project": "" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": l(h), field: "source" }, null, 8, ["basic-class"]), s(me, { align: "center", label: "计量单位", "min-width": "70px", prop: "source.measureUnit" }), s(me, { align: "center", label: "数量", "min-width": "120px", prop: "quantity" }, { default: p(({ row: { sourceRow: X } }) => [X.measureUnit ? (w(), Q(Qe, { key: 0 }, [X.outboundUnitType === l(hi).MEASURE.V ? (w(), U(ge, { key: 0, modelValue: X.quantity, "onUpdate:modelValue": ($) => X.quantity = $, min: 0, max: +X.source.quantity, controls: false, step: 1, precision: +X.measurePrecision, size: "default", placeholder: "数量", onChange: ($) => oe(X, $) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", Zce, K(X.quantity || 0), 1))], 64)) : (w(), Q("span", Jce, "-"))]), _: 1 }), s(me, { prop: "source.accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }), s(me, { prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: p(({ row: { sourceRow: X } }) => [X.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(ge, { key: 0, modelValue: X.mete, "onUpdate:modelValue": ($) => X.mete = $, min: 0, max: +X.source.sourceReturnableMete, controls: false, step: 1, precision: X.accountingPrecision, size: "default", placeholder: "核算量", onChange: ($) => ye(X, $) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", Xce, K(X.mete || 0), 1))]), _: 1 }), s(rn, { list: l(m).list, "return-destination": q.value }, null, 8, ["list", "return-destination"]), s(Nr, { showSourceRow: "", label: "实际退库时间" }), s(me, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: { sourceRow: X }, $index: $ }) => [s(Le, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (k) => l(I)(X, $) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "cell-class-name", "expand-row-keys", "onRowClick"])]), _: 1 }, 8, ["model", "disabled"])]);
  };
} }, r8 = ut($ce, [["__scopeId", "data-v-668a3971"]]), ede = Object.freeze(Object.defineProperty({ __proto__: null, default: r8 }, Symbol.toStringTag, { value: "Module" }));
const tde = { class: "app-container" }, ide = { class: "mtb-10" }, ade = { key: 1 }, lde = { key: 1 }, ode = { key: 1 }, nde = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const { realTimeValidate: n } = as(), c = o, u = e, r = { list: [] }, E = Z([]), y = Z(), b = Z(), V = Z(), M = Z([["source.project", ["parse-project", { onlyShortName: true }]]]), { fixMaxHeight: g, maxHeight: S } = Kt({ paginate: false }), h = dt.OTHER.V, _ = { mete: [{ required: true, message: "请填写核算量" }, { pattern: Vi, message: "核算量必须大于0" }], quantity: [{ validator: (se, he) => he.measureUnit ? !!se : true, message: "有计量单位，数量必须大于0" }], workshopId: [{ required: true, message: "请选择车间" }], warehouseId: [{ required: true, message: "请选择存储位置" }], realTime: [{ validator: n, message: "请选择实际退库时间", trigger: "change" }] }, { cu: f, form: m, FORM: R } = Pa({ title: "其它退库", formStore: !u.edit, formStoreKey: "WMS_RETURN_APPLICATION_OTHER_MATERIAL", permission: bD, defaultForm: r, useDraftCallback: ce, clearDraftCallback: ae, api: u.edit ? Nn : J4 }, V, u.detail);
  f.updateProp("boolRealReturn", u.detail && Object.prototype.hasOwnProperty.call(u.detail, "boolRealReturn") ? u.detail.boolRealReturn : true);
  const { calcMaxMete: v, extractSource: N, checkOverSource: P, initCheckOverMaxWeight: L } = Ws({ cu: f, form: m, basicClass: h }), { currentSource: O, currentUid: x, delRow: I, handleRowClick: Y } = Ys({ form: m, tableRef: b, delCallback: P }), { sourceReturnIds: ee, wrongCellMask: B } = Ks({ FORM: R, form: m, cu: f, emit: c, tableRules: _, init: ae, setFormCallback: ce, isEdit: u.edit }), q = Ee(() => {
    var se;
    return (se = y.value) == null ? void 0 : se.returnDestination;
  });
  function ae() {
    m.list = [], O.value = void 0, x.value = void 0, f.props.abnormalList = void 0;
  }
  function j(se) {
    le(se, se.source), Ce([() => se.quantity], () => {
      v(se);
    }), Ce(() => se.mete, () => {
      P(se);
    }, { immediate: true });
  }
  function le(se, he) {
    var be, me;
    se.mete = se.mete || se.returnableMete || he.returnableMete, se.quantity = se.quantity || he.quantity, se.workshopId = se.workshopId || ((be = he.workshop) == null ? void 0 : be.id), se.warehouseId = se.warehouseId || ((me = he.warehouse) == null ? void 0 : me.id);
  }
  function oe(se, he) {
    A(he) ? se.mete = Be(he / +se.source.quantity * se.source.sourceReturnableMete, se.accountingPrecision) : se.mete = void 0;
  }
  function ye(se, he) {
    se.measureUnit && A(he) ? se.quantity = Be(he / +se.source.sourceReturnableMete * se.source.quantity, se.measurePrecision) : se.quantity = void 0;
  }
  function ce(se) {
    se.list = se.list.map((be) => Ct(be));
    const he = Ce([b, y], ([be, me]) => {
      be && me && (N(se.list), L(se.list), se.list.forEach((ge) => {
        j(ge), P(ge);
      }), pt(() => {
        he();
      }));
    }, { immediate: true, deep: true });
    g();
  }
  return (se, he) => {
    const be = Mt, me = vt, ge = Ve("common-input-number"), Le = Ve("common-button"), Ie = Ve("common-table"), Se = Li;
    return w(), Q("div", tde, [s(ls, { ref_key: "headerRef", ref: y, "basic-class": l(h), "current-source": l(O), edit: u.edit, list: l(m).list, "source-return-ids": l(ee), onReset: ae, onAdd: j }, null, 8, ["basic-class", "current-source", "edit", "list", "source-return-ids"]), s(Se, { ref_key: "formRef", ref: V, disabled: l(f).status.edit === l(R).STATUS.PROCESSING, model: l(m) }, { default: p(() => [s(Ie, { ref_key: "tableRef", ref: b, "cell-class-name": l(B), data: l(m).list, "data-format": M.value, "default-expand-all": false, "expand-row-keys": E.value, "max-height": l(S), stripe: false, "highlight-current-row": "", "row-key": "uid", onRowClick: l(Y) }, { default: p(() => [s(Ha, { "expand-row-keys": E.value, "onUpdate:expandRowKeys": he[0] || (he[0] = (X) => E.value = X), data: l(m).list, fixed: "left", "row-key": "uid" }, { default: p(({ row: { sourceRow: X } }) => [C("div", ide, [s(be, { modelValue: X.remark, "onUpdate:modelValue": ($) => X.remark = $, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(jo, { "basic-class": l(h), field: "source", "party-a-position": "project", "show-project": "" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": l(h), field: "source" }, null, 8, ["basic-class"]), s(me, { align: "center", label: "计量单位", "min-width": "70px", prop: "measureUnit" }), s(me, { align: "center", label: "数量", "min-width": "120px", prop: "quantity" }, { default: p(({ row: { sourceRow: X } }) => [X.measureUnit ? (w(), Q(Qe, { key: 0 }, [X.outboundUnitType === l(hi).MEASURE.V ? (w(), U(ge, { key: 0, modelValue: X.quantity, "onUpdate:modelValue": ($) => X.quantity = $, controls: false, max: +X.source.quantity, min: 0, precision: +X.measurePrecision, size: "default", step: 1, placeholder: "数量", onChange: ($) => oe(X, $) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", ade, K(X.quantity || 0), 1))], 64)) : (w(), Q("span", lde, "-"))]), _: 1 }), s(me, { align: "center", label: "核算单位", "min-width": "70px", prop: "accountingUnit" }), s(me, { align: "center", label: "核算量", "min-width": "120px", prop: "mete" }, { default: p(({ row: { sourceRow: X } }) => [X.outboundUnitType === l(hi).ACCOUNTING.V ? (w(), U(ge, { key: 0, modelValue: X.mete, "onUpdate:modelValue": ($) => X.mete = $, controls: false, max: +X.source.sourceReturnableMete, min: 0, precision: X.accountingPrecision, size: "default", step: 1, placeholder: "核算量", onChange: ($) => ye(X, $) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : (w(), Q("span", ode, K(X.mete || 0), 1))]), _: 1 }), s(rn, { list: l(m).list, "return-destination": q.value }, null, 8, ["list", "return-destination"]), s(Nr, { showSourceRow: "", label: "实际退库时间" }), s(me, { align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: { sourceRow: X }, $index: $ }) => [s(Le, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (k) => l(I)(X, $) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height", "onRowClick"])]), _: 1 }, 8, ["disabled", "model"])]);
  };
} }, u8 = ut(nde, [["__scopeId", "data-v-2d8a9a31"]]), sde = Object.freeze(Object.defineProperty({ __proto__: null, default: u8 }, Symbol.toStringTag, { value: "Module" }));
const rde = { __name: "form", setup(e) {
  const { CRUD: o, crud: n, form: c } = An(), u = Ee(() => {
    switch (c.basicClass) {
      case Pe.STEEL_PLATE.V:
        return a8;
      case Pe.SECTION_STEEL.V:
        return l8;
      case Pe.STEEL_COIL.V:
        return o8;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return n8;
      case Pe.MATERIAL.V:
        return s8;
      case Pe.OTHER.V:
        return u8;
      case Pe.GAS.V:
        return r8;
      default:
        return;
    }
  });
  o.HOOK.beforeEditDetailLoaded = async (E, y) => {
    const physicalBaseUnits = await _a();
    E.updateProp("boolRealReturn", y.boolRealReturn || true);
    const b = [], V = [];
    y.list.forEach((g) => {
      g.getDataTime = (/* @__PURE__ */ new Date()).getTime();
    }), (y.basicClass === dt.STEEL_PLATE.V || y.basicClass & dt.SECTION_STEEL.V) && await Promise.all(y.list.map(async (g) => {
      if (g.boolReturns && A(g.list)) {
        g.list.forEach((_) => {
          _.getDataTime = g.getDataTime;
        }), await Qt(g.list);
        const S = await returnPhysicalFormat(g.list, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] });
        await Es(g.list);
        const h = g.list.map((_) => _.source);
        await Qt(h);
        const T = await returnPhysicalFormat(h, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] });
        await Es(h), b.push(S), V.push(T);
      }
    })), await Promise.all(V), await Promise.all(b), await Qt(y.list), await returnPhysicalFormat(y.list, { toNum: true }), await Es(y.list);
    const M = y.list.map((g) => g.source);
    await Qt(M), await returnPhysicalFormat(M, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete"] }), await Es(M), M.forEach((g) => {
      g.sourceReturnableMete = g.returnableMete, c.basicClass === dt.SECTION_STEEL.V && (g.returnableLength = g.singleReturnableLength * g.quantity, g.totalLength = g.length * g.quantity, g.sourceReturnableLength = g.returnableLength);
    }), y.list.forEach((g) => {
      g.warehouseId = g.warehouse ? g.warehouse.id : g.warehouseId, g.workshopId = g.workshop ? g.workshop.id : g.workshopId, g.singleMete = +ji(g.theoryWeight / g.source.theoryWeight * g.source.singleMete, g.basicClass & ua ? returnPhysicalPrecision(physicalBaseUnits[g.basicClass].weight.unit) : void 0);
    }), (y.basicClass === dt.STEEL_PLATE.V || y.basicClass === dt.SECTION_STEEL.V) && await Promise.all(y.list.map(async (g) => {
      g.uid = g.id, g.boolReturns && A(g.list) && g.list.forEach((S) => {
        S.pid = g.id, S.uid = S.id, S.workshopId = S.workshop ? S.workshop.id : S.workshopId, S.warehouseId = S.warehouse ? S.warehouse.id : S.warehouseId, S.factoryId = S.factory ? S.factory.id : S.factoryId, S.singleMete = +ji(S.theoryWeight / S.source.theoryWeight * S.source.singleMete, S.basicClass & ua ? returnPhysicalPrecision(physicalBaseUnits[S.basicClass].weight.unit) : void 0);
      });
    }));
  };
  function r() {
    n.cancelCU(), n.refresh();
  }
  return (E, y) => {
    const b = wi, V = Ve("common-drawer");
    return w(), U(V, { ref: "drawerRef", "before-close": l(n).cancelCU, "content-loading": l(n).editDetailLoading, "show-close": true, title: l(n).status.title, visible: l(n).status.cu > l(o).STATUS.NORMAL, "custom-class": "raw-mat-inbound-application-record-form", size: "100%" }, { titleAfter: p(() => [s(b, { effect: "plain", type: "warning" }, { default: p(() => [Te("退库类型：" + K(l(Jt).VL[l(c).outboundTypeSelection]), 1)]), _: 1 })]), content: p(() => [(w(), U(Ri(u.value), { detail: l(c), edit: "", onSuccess: r }, null, 40, ["detail"]))]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, c8 = ut(rde, [["__scopeId", "data-v-4154ee67"]]), ude = Object.freeze(Object.defineProperty({ __proto__: null, default: c8 }, Symbol.toStringTag, { value: "Module" }));
const cde = { key: 0, class: "invoice-type-info" }, dde = { key: 0 }, mde = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, pde = { key: 1, class: "footer" }, hde = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, fde = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, { decimalPrecision: u } = Ln(), r = Z(), E = Z([]), y = Z(false), b = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"]]), { CRUD: V, crud: M, detail: g } = qi(), { maxHeight: S } = Kt({ mainBox: ".raw-mat-transfer-application-review-detail", extraBox: [".el-drawer__header", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !M.detailLoading)), h = Ee(() => M.detailLoading ? "移库单：" : `移库单：${g.serialNumber || ""}`), T = Z(false), _ = Z();
  function f(N) {
    var O;
    const P = (O = N.sourceWorkshop) == null ? void 0 : O.name, L = N.sourceWarehouse ? N.sourceWarehouse.name : N.sourceWarehouseName;
    return P ? P + "【" + L + "】" : L;
  }
  V.HOOK.beforeDetailLoaded = async (N, P) => {
    _.value = void 0, await Qt(P.detailList), P.detailList = await Ut(P.detailList, { toSmallest: false, toNum: false });
  };
  function m(N) {
    return Hi(N, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN], ["amountExcludingVAT", Ze.YUAN], ["inputVAT", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  async function R(N) {
    N.loading = true;
    try {
      Ae(N.wmsApproveRecordFlowDTO) && (N.wmsApproveRecordFlowDTO = await Jn(N.journalId));
    } catch (P) {
      console.log(P, "获取失败");
    } finally {
      N.loading = false;
    }
  }
  async function v(N) {
    try {
      if (T.value = true, N === Lt.REFUSE.V && !A(_.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const P = { approveRecordId: g.approveRecordId, decision: N, opinion: _.value };
      await qU(P), N === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), n("auditSuccess");
    } catch (P) {
      console.log("出库(审批流)审核提交", P);
    } finally {
      T.value = false;
    }
  }
  return (N, P) => {
    const L = Ve("common-button"), O = La, x = pa, I = vt, Y = jt, ee = Ve("common-table"), B = Mt, q = Ve("common-drawer"), ae = _t("parse-enum"), j = oi;
    return w(), U(q, { ref_key: "drawerRef", ref: r, "before-close": l(M).cancelDetail, "content-loading": l(M).detailLoading, "show-close": true, title: h.value, visible: l(M).detailVisible, "custom-class": "raw-mat-transfer-application-review-detail", size: "100%" }, { titleAfter: p(() => [s(U_, { detail: l(g) }, null, 8, ["detail"])]), titleRight: p(() => [y.value && l(A)(l(g).invoiceType) ? (w(), Q("span", cde, [qe(C("span", null, null, 512), [[ae, { e: l(fi), v: l(g).invoiceType }]]), l(g).invoiceType !== l(fi).RECEIPT.V ? (w(), Q("span", dde, "（" + K(l(g).taxRate) + "%）", 1)) : H("", true)])) : H("", true), s(O, { width: 400, placement: "top", trigger: "click", onShow: P[0] || (P[0] = (le) => R(l(g))) }, { reference: p(() => [s(L, { size: "default" }, { default: p(() => P[4] || (P[4] = [Te("查看审批记录")])), _: 1, __: [4] })]), default: p(() => [qe((w(), Q("div", mde, [s(tl, { data: l(g).wmsApproveRecordFlowDTO }, null, 8, ["data"])])), [[j, l(g).loading]])]), _: 1 }), c.ApprovalFlag ? (w(), Q("div", pde, [s(x, { title: "确认通过", onConfirm: P[1] || (P[1] = (le) => v(l(Lt).PASS.V)) }, { reference: p(() => [s(L, { loading: T.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => P[5] || (P[5] = [Te(" 通过 ")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 }), s(x, { title: "确认驳回", onConfirm: P[2] || (P[2] = (le) => v(l(Lt).REFUSE.V)) }, { reference: p(() => [s(L, { loading: T.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => P[6] || (P[6] = [Te(" 驳回 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : H("", true)]), content: p(() => [l(g).boolHasUnfreeze ? (w(), U(fu, { key: 0, "basic-class": l(g).basicClass, list: l(g).unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : H("", true), s(ee, { data: l(g).detailList, "data-format": b.value, "expand-row-keys": E.value, "max-height": l(S), "summary-method": m, "row-key": "id", "show-summary": "" }, { default: p(() => [s(fa, { "basic-class": l(g).basicClass, "spec-merge": false, "classify-name-alias": "名称", "reject-detail-viewable": "", "show-classification": "", "show-reject-status": "", sortable: "", "spec-only": "" }, { afterMaterialSn: p(() => [s(I, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(I, { key: "measureUnit", "show-overflow-tooltip": true, align: "center", label: "计量单位", "min-width": "90", prop: "measureUnit" }, { default: p(({ row: le }) => [C("span", null, K(le.measureUnit || "-"), 1)]), _: 1 }), s(I, { key: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量", "min-width": "100", prop: "quantity" }, { default: p(({ row: le }) => [C("span", null, K(le.quantity || "-"), 1)]), _: 1 }), s(I, { key: "accountingUnit", "show-overflow-tooltip": true, align: "center", label: "核算单位", "min-width": "90", prop: "accountingUnit" }, { default: p(({ row: le }) => [C("span", null, K(le.accountingUnit || "-"), 1)]), _: 1 }), s(I, { key: "mete", "show-overflow-tooltip": true, align: "center", label: "核算量", "min-width": "100", prop: "mete" }, { default: p(({ row: le }) => [C("span", null, K(le.mete || "-"), 1)]), _: 1 }), s(I, { key: "project", "show-overflow-tooltip": true, align: "center", label: "关联项目", "min-width": "170", prop: "projectFullName" }, { default: p(({ row: le }) => [C("span", null, K(le.projectFullName || "-"), 1)]), _: 1 }), s(I, { key: "sourceWarehouse", align: "center", label: "所属仓库", "min-width": "170", prop: "sourceWarehouse" }, { default: p(({ row: le }) => [C("div", hde, [s(Os, { id: le.sourceWorkshop ? le.sourceWorkshop.id : le.sourceWorkshopId }, null, 8, ["id"]), s(Y, { content: f(le), class: "item", effect: "dark", placement: "top-start" }, { default: p(() => [C("span", null, K(le.sourceWarehouse ? le.sourceWarehouse.name : le.sourceWarehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 }), s(I, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "170", prop: "remark" }, { default: p(({ row: le }) => [C("span", null, K(le.remark || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), c.ApprovalFlag ? (w(), U(B, { key: 1, modelValue: _.value, "onUpdate:modelValue": P[3] || (P[3] = (le) => _.value = le), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, d8 = ut(fde, [["__scopeId", "data-v-9e4a5b6d"]]), gde = Object.freeze(Object.defineProperty({ __proto__: null, default: d8 }, Symbol.toStringTag, { value: "Module" }));
function Ede(e) {
  return W({ module: "wms_v2", url: "convert/convert", method: "get", params: e });
}
function m8(e) {
  return W({ module: "wms", url: `convert/convertDetail/${e}`, method: "get", cancelKey: false });
}
function lgt(e) {
  return W({ module: "wms", url: `convert/convertDetail/${e}`, method: "get", cancelKey: false });
}
function ogt(e) {
  return W({ module: "wms", url: `convert/convertReturn/${e}`, method: "get" });
}
function ngt(e) {
  return W({ module: "wms", url: `convert/passed/${e}`, method: "get" });
}
function sgt(e) {
  return W({ module: "wms", url: "convert/reviewedNum", method: "get" });
}
function yde(e) {
  return W({ url: `/api/v2/wms/convert/revocation/${e.id}`, method: "post" });
}
function Tde(e) {
  return W({ url: "/api/v2/wms/convert/review", method: "put", params: e });
}
const rgt = { get: Ede, detail: m8 };
const _de = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, bde = { key: 0, class: "footer" }, Vde = { key: 0 }, wde = { key: 1 }, Sde = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z([["project", "parse-project"], ["quantity", ["to-fixed-field", "measurePrecision"]], ["mete", ["to-fixed-field", "accountingPrecision"]], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["boolOutbound", ["parse-enum", ea]]]), { CRUD: E, crud: y, detail: b } = qi(), { maxHeight: V } = Kt({ mainBox: ".convert-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, u), M = Z(), g = Z(false);
  async function S(_) {
    try {
      if (g.value = true, _ === Lt.REFUSE.V && !A(M.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const f = { approveRecordId: b.approveRecordId, decision: _, opinion: M.value };
      await Tde(f), _ === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), n("auditSuccess");
    } catch (f) {
      console.log("出库(审批流)审核提交", f);
    } finally {
      g.value = false;
    }
  }
  async function h(_) {
    _.loading = true;
    try {
      Ae(_.wmsApproveRecordFlowDTO) && (_.wmsApproveRecordFlowDTO = await Jn(_.journalId));
    } catch (f) {
      console.log(f, "获取失败");
    } finally {
      _.loading = false;
    }
  }
  E.HOOK.beforeDetailLoaded = async (_, f) => {
    M.value = void 0, f.widthThick = f.thickness || f.width ? (f.thickness || "-") + "*" + (f.width || "-") : "-", await Qt(f.convertDetailDTOList), f.convertDetailDTOList = await Ut(f.convertDetailDTOList, { toSmallest: false, toNum: true });
  };
  function T(_) {
    return Hi(_, { props: ["quantity", ["mete", ei.weight.precision]] });
  }
  return (_, f) => {
    const m = wi, R = Ve("common-button"), v = La, N = pa, P = qa, L = Ga, O = Ml, x = vt, I = Ve("table-cell-tag"), Y = Ve("common-table"), ee = Mt, B = Ve("common-drawer"), q = oi;
    return w(), U(B, { ref_key: "drawerRef", ref: u, "before-close": l(y).cancelDetail, "content-loading": l(y).detailLoading, "show-close": true, title: "详情", visible: l(y).detailVisible, "custom-class": "convert-detail", size: "85%" }, { titleAfter: p(() => [s(m, { type: "success" }, { default: p(() => [Te("条板转换单：" + K(l(b).receiptSerialNumber), 1)]), _: 1 }), l(b).status === l(po).PASS.V ? (w(), U(m, { key: 0, type: "info" }, { default: p(() => [Te("出库单：" + K(l(b).outSerialNumber), 1)]), _: 1 })) : H("", true), l(b).boolPartyA ? (w(), U(m, { key: 1, type: "danger" }, { default: p(() => f[4] || (f[4] = [Te("甲供")])), _: 1, __: [4] })) : H("", true)]), titleRight: p(() => [s(v, { width: 400, placement: "top", trigger: "click", onShow: f[0] || (f[0] = (ae) => h(l(b))) }, { reference: p(() => [s(R, { size: "default" }, { default: p(() => f[5] || (f[5] = [Te("查看审批记录")])), _: 1, __: [5] })]), default: p(() => [qe((w(), Q("div", _de, [s(tl, { data: l(b).wmsApproveRecordFlowDTO }, null, 8, ["data"])])), [[q, l(b).loading]])]), _: 1 }), c.ApprovalFlag ? (w(), Q("div", bde, [s(N, { title: "确认通过", onConfirm: f[1] || (f[1] = (ae) => S(l(Lt).PASS.V)) }, { reference: p(() => [s(R, { loading: g.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => f[6] || (f[6] = [Te(" 通过 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 }), s(N, { title: "确认驳回", onConfirm: f[2] || (f[2] = (ae) => S(l(Lt).REFUSE.V)) }, { reference: p(() => [s(R, { loading: g.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => f[7] || (f[7] = [Te(" 驳回 ")])), _: 1, __: [7] }, 8, ["loading"])]), _: 1 })])) : H("", true), s(ia, { fn: l(rv), params: { id: l(b).id }, size: "default" }, { default: p(() => f[8] || (f[8] = [Te("转换单详情下载")])), _: 1, __: [8] }, 8, ["fn", "params"])]), content: p(() => [s(m, { effect: "plain" }, { default: p(() => f[9] || (f[9] = [Te("原物料信息")])), _: 1, __: [9] }), s(L, { column: 3, border: "", style: { margin: "10px 0" } }, { default: p(() => [s(P, { label: "物料名称", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).classifyName || "-"), 1)]), _: 1 }), s(P, { label: "物料编号", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).serialNumber || "-"), 1)]), _: 1 }), s(P, { label: "规格", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).specification || "-"), 1)]), _: 1 }), s(P, { label: "厚(mm)*宽(mm)", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).widthThick || "-"), 1)]), _: 1 }), s(P, { label: "品牌", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).brand || "-"), 1)]), _: 1 }), s(P, { label: "颜色", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).color || "-"), 1)]), _: 1 }), s(P, { label: "卷号", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).heatNoAndBatchNo || "-"), 1)]), _: 1 }), s(P, { label: "项目", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).project ? l(di)(l(b).project) : "-"), 1)]), _: 1 }), s(P, { label: "车间", "label-class-name": "contractLabel" }, { default: p(() => {
      var ae;
      return [Te(K(((ae = l(b).warehouse) == null ? void 0 : ae.name) || "-"), 1)];
    }), _: 1 }), s(P, { label: "备注", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(b).remark || "-"), 1)]), _: 1 })]), _: 1 }), s(O, null, { default: p(() => f[10] || (f[10] = [C("span", { class: "title" }, "转换后物料信息", -1)])), _: 1, __: [10] }), qe((w(), U(Y, { data: l(b).convertDetailDTOList, "data-format": r.value, "max-height": l(V) - 220, "summary-method": T, "show-summary": "" }, { default: p(() => [s(x, { align: "center", label: "序号", type: "index", width: "60" }, { default: p(({ row: { sourceRow: ae }, $index: j }) => [ae.boolSurplus ? (w(), Q("span", Vde, "余料")) : (w(), Q("span", wde, K(j + 1), 1))]), _: 1 }), s(x, { key: "serialNumber", align: "center", label: "物料编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(x, { key: "classifyName", align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }), s(x, { key: "length", align: "center", label: "长(mm)", prop: "length", "show-overflow-tooltip": "" }), s(x, { key: "width", align: "center", label: "宽(mm)", prop: "width", "show-overflow-tooltip": "" }), s(x, { key: "thickness", align: "center", label: "厚(mm)", prop: "thickness", "show-overflow-tooltip": "" }), s(x, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }), s(x, { key: "quantity", align: "center", label: "数量（张）", prop: "quantity", "show-overflow-tooltip": "" }), s(x, { key: "mete", align: "center", label: "重量（kg）", prop: "mete", "show-overflow-tooltip": "" }), s(x, { key: "project", align: "center", label: "所属项目", "min-width": "150", prop: "project", "show-overflow-tooltip": "" }), s(x, { key: "workshopName", align: "center", label: "车间", prop: "workshopName", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: ae } }) => [C("span", null, K(ae.boolOutbound ? ae.workshopName : "-"), 1)]), _: 1 }), s(x, { key: "warehouse.name", align: "center", label: "存储位置", prop: "warehouse.name", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: ae } }) => [s(I, { name: ae.workshopName, offset: 15, show: !ae.boolOutbound && ae.workshopName, color: "#e64242" }, null, 8, ["name", "show"]), C("span", null, K(ae.warehouse.name), 1)]), _: 1 }), s(x, { key: "recipientName", align: "center", label: "领用人", prop: "recipientName", "show-overflow-tooltip": "" }), s(x, { key: "outboundTime", align: "center", label: "出库时间", prop: "outboundTime", "show-overflow-tooltip": "", width: "150" }), s(x, { key: "boolOutbound", align: "center", label: "是否出库", prop: "boolOutbound", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[q, _.loading]]), c.ApprovalFlag ? (w(), U(ee, { key: 0, modelValue: M.value, "onUpdate:modelValue": f[3] || (f[3] = (ae) => M.value = ae), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, p8 = ut(Sde, [["__scopeId", "data-v-7e957297"]]), vde = Object.freeze(Object.defineProperty({ __proto__: null, default: p8 }, Symbol.toStringTag, { value: "Module" }));
const Rde = { key: 0 }, Mde = { class: "head-container" }, Ade = { key: 0, class: "imgs-box" }, Nde = { key: 1 }, Lde = { key: 0 }, Ide = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} }, ApprovalFlag: { type: Boolean, default: false }, permission: { type: Object, default: () => {
} } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = Z(false), c = Z(false), { CRUD: u, crud: r, detail: E } = qi(), y = o, b = e, V = Z({}), M = Z(), g = Z(false);
  u.HOOK.beforeDetailLoaded = async (T, _) => {
    var f, m, R, v;
    V.value = _, V.value.imgUrls = (m = (f = V.value) == null ? void 0 : f.attachments) == null ? void 0 : m.map((N) => N.imageUrl), V.value.wmsApproveRecordFlowDTOS && ((R = V.value.wmsApproveRecordFlowDTOS) == null ? void 0 : R.length) > 0 && ((v = V.value.wmsApproveRecordFlowDTOS[0].wmsApproveFlowDTOS) == null || v.forEach((N) => {
      var P;
      switch ((P = N == null ? void 0 : N.wmsApproveRecordDetailDTOS) == null || P.forEach((L) => {
        L.approveTime = Qi(L.approveTime);
      }), N == null ? void 0 : N.reviewStatus) {
        case nl.REJECT.V:
          N.iconSvg = "reject";
          break;
        case nl.APPROVED.V:
          N.iconSvg = "pass";
          break;
        case (nl.PENDING_REVIEW.V || nl.NOT_STARTED_YET.V):
          N.iconSvg = "auditing";
          break;
        case nl.NOT_STARTED_YET.V:
          N.type === Pn.CC.V ? N.iconSvg = "cc" : N.iconSvg = "auditing";
          break;
        case nl.REVOKE.V:
          N.iconSvg = "revoke_1";
          break;
      }
    }));
  };
  async function S() {
    var T, _;
    try {
      c.value = true, await zi.confirm("您将选择审核通过操作，是否确定？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await B2({ approveProcessTypeName: (_ = (T = V.value) == null ? void 0 : T.rowDetail) == null ? void 0 : _.approveProcessTypeName, approveRecordId: E == null ? void 0 : E.approveRecordIdNow, dataId: E == null ? void 0 : E.id, decision: nl.APPROVED.V }), r.cancelDetail(), y("auditSuccess");
    } catch (f) {
      console.log(f, "审批失败");
    } finally {
      c.value = false;
    }
  }
  async function h() {
    var T, _;
    try {
      n.value = true, await zi.confirm("您将选择审核驳回操作，是否确定？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await B2({ approveProcessTypeName: (_ = (T = V.value) == null ? void 0 : T.rowDetail) == null ? void 0 : _.approveProcessTypeName, approveRecordId: E == null ? void 0 : E.approveRecordIdNow, dataId: E == null ? void 0 : E.id, decision: nl.REJECT.V }), r.cancelDetail(), y("auditSuccess");
    } catch (f) {
      console.log(f, "审批失败");
    } finally {
      n.value = false;
    }
  }
  return (T, _) => {
    const f = Ve("common-button"), m = qa, R = Um, v = Ga, N = Ml, P = Ve("common-drawer"), L = oi;
    return w(), U(P, { ref_key: "drawerRef", ref: M, title: "签证详情", "close-on-click-modal": false, "before-close": l(r).cancelDetail, "content-loading": l(r).detailLoading, "show-close": true, visible: l(r).detailVisible, "custom-class": "visa-detail", size: "50%" }, { titleRight: p(() => {
      var O, x, I, Y;
      return [b.ApprovalFlag ? (w(), Q("div", Rde, [l(Ai)((O = e.permission) == null ? void 0 : O.pass) ? (w(), U(f, { key: 0, loading: c.value, class: "filter-item", size: "default", type: "success", onClick: Pi(S, ["stop"]) }, { default: p(() => _[0] || (_[0] = [Te(" 通 过 ")])), _: 1, __: [0] }, 8, ["loading"])) : H("", true), l(Ai)((x = e.permission) == null ? void 0 : x.reject) ? (w(), U(f, { key: 1, loading: n.value, class: "filter-item", size: "default", type: "danger", onClick: Pi(h, ["stop"]) }, { default: p(() => _[1] || (_[1] = [Te(" 驳 回 ")])), _: 1, __: [1] }, 8, ["loading"])) : H("", true)])) : H("", true), l(Ai)((I = e.permission) == null ? void 0 : I.export) ? (w(), U(ia, { key: 1, type: "warning", params: (Y = l(E)) == null ? void 0 : Y.id, fn: l(iO) }, { default: p(() => _[2] || (_[2] = [Te("下载")])), _: 1, __: [2] }, 8, ["params", "fn"])) : H("", true)];
    }), content: p(() => {
      var O, x, I, Y, ee;
      return [C("div", Mde, [qe((w(), U(v, { column: 2, border: "" }, { default: p(() => [s(m, { align: "center", "label-align": "center", label: "创建人" }, { default: p(() => {
        var B;
        return [Te(K((B = V.value) == null ? void 0 : B.userName), 1)];
      }), _: 1 }), s(m, { align: "center", "label-align": "center", label: "日期" }, { default: p(() => {
        var B, q;
        return [Te(K((B = V.value) != null && B.visaDate ? l(Qi)((q = V.value) == null ? void 0 : q.visaDate, "{y}-{m}-{d}") : "-"), 1)];
      }), _: 1 }), s(m, { align: "center", "label-align": "center", label: "类别" }, { default: p(() => [Te(K(l($c).VL[V.value.mode] || "-"), 1)]), _: 1 }), s(m, { align: "center", "label-align": "center", label: "项目" }, { default: p(() => [Te(K(V.value.project ? l(di)(V.value.project) : "-"), 1)]), _: 1 }), s(m, { align: "center", "label-align": "center", label: "签证对象" }, { default: p(() => [Te(K(V.value.recipients), 1)]), _: 1 }), s(m, { align: "center", "label-align": "center", label: "事由" }, { default: p(() => [Te(K(V.value.reasonName), 1)]), _: 1 }), s(m, { align: "center", "label-align": "center", label: "费用" }, { default: p(() => [Te(K(V.value.visaAmount), 1)]), _: 1 }), s(m, { align: "center", "label-align": "center", label: "备注" }, { default: p(() => [Te(K(V.value.remark), 1)]), _: 1 }), s(m, { "label-align": "center", label: "图片" }, { default: p(() => {
        var B, q;
        return [((q = (B = V.value) == null ? void 0 : B.attachments) == null ? void 0 : q.length) > 0 ? (w(), Q("div", Ade, [(w(true), Q(Qe, null, ki(V.value.attachments, (ae) => (w(), U(R, { "preview-src-list": V.value.imgUrls, "initial-index": 1, key: ae.id, src: ae.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]))), 128))])) : (w(), Q("div", Nde))];
      }), _: 1 })]), _: 1 })), [[L, g.value]])]), s(N, { class: "divider" }), (O = V.value) != null && O.wmsApproveRecordFlowDTOS && ((I = (x = V.value) == null ? void 0 : x.wmsApproveRecordFlowDTOS) == null ? void 0 : I.length) > 0 ? (w(), Q("div", Lde, [_[3] || (_[3] = C("div", { style: { "font-weight": "700", "margin-bottom": "8px" } }, "审批状态", -1)), s(RS, { data: (ee = (Y = V.value) == null ? void 0 : Y.wmsApproveRecordFlowDTOS[0]) == null ? void 0 : ee.wmsApproveFlowDTOS }, null, 8, ["data"])])) : H("", true)];
    }), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, h8 = ut(Ide, [["__scopeId", "data-v-f61d2b19"]]), Cde = Object.freeze(Object.defineProperty({ __proto__: null, default: h8 }, Symbol.toStringTag, { value: "Module" }));
const Pde = { class: "dialog-form" }, Ode = { __name: "reject-dialog", props: { modelValue: { type: Boolean, default: void 0 } }, emits: ["update:modelValue", "rejectSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, u = Z(), { visible: r, handleClose: E } = Ta({ emit: c, props: n, showHook: y });
  function y() {
    u.value = void 0;
  }
  function b() {
    c("rejectSuccess", u.value), E();
  }
  return (V, M) => {
    const g = Ve("common-button"), S = Mt, h = Ve("common-dialog");
    return w(), U(h, { title: "驳回申请二次确认", "destroy-on-close": "", modelValue: l(r), "onUpdate:modelValue": M[1] || (M[1] = (T) => Gt(r) ? r.value = T : null), "close-on-click-modal": false, "before-close": l(E), width: "600px" }, { titleRight: p(() => [s(g, { type: "primary", size: "default", onClick: b }, { default: p(() => M[2] || (M[2] = [Te("确认")])), _: 1, __: [2] })]), default: p(() => [C("div", Pde, [M[3] || (M[3] = C("span", null, "驳回说明:", -1)), s(S, { modelValue: u.value, "onUpdate:modelValue": M[0] || (M[0] = (T) => u.value = T), type: "textarea", autosize: { minRows: 2, maxRows: 5 }, maxlength: "50", placeholder: "请填写驳回说明", style: { width: "300px" } }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, js = ut(Ode, [["__scopeId", "data-v-07287c93"]]), kde = Object.freeze(Object.defineProperty({ __proto__: null, default: js }, Symbol.toStringTag, { value: "Module" }));
const Dde = { class: "dialog-form" }, xde = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: void 0 } }, emits: ["update:modelValue", "confirmSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { visible: u, handleClose: r } = Ta({ emit: c, props: n, showHook: y }), E = Z();
  function y() {
    E.value = void 0;
  }
  function b() {
    c("confirmSuccess", E.value), r();
  }
  return (V, M) => {
    const g = Ve("common-button"), S = Mt, h = Ve("common-dialog");
    return w(), U(h, { title: "通过申请二次确认", "destroy-on-close": "", modelValue: l(u), "onUpdate:modelValue": M[1] || (M[1] = (T) => Gt(u) ? u.value = T : null), "close-on-click-modal": false, "before-close": l(r), width: "600px" }, { titleRight: p(() => [s(g, { type: "primary", size: "default", onClick: b }, { default: p(() => M[2] || (M[2] = [Te("确认")])), _: 1, __: [2] })]), default: p(() => [C("div", Dde, [M[3] || (M[3] = C("span", null, "通过说明:", -1)), s(S, { modelValue: E.value, "onUpdate:modelValue": M[0] || (M[0] = (T) => E.value = T), type: "textarea", autosize: { minRows: 2, maxRows: 5 }, maxlength: "50", placeholder: "请填写通过说明", style: { width: "300px" } }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Fs = ut(xde, [["__scopeId", "data-v-41d7117e"]]), Ude = Object.freeze(Object.defineProperty({ __proto__: null, default: Fs }, Symbol.toStringTag, { value: "Module" }));
const Yde = { key: 0 }, Kde = { __name: "check-follow-up", props: { componentName: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { crud: u, detail: r } = qi(), E = Z(false), y = Z(false);
  function b() {
    y.value = true;
  }
  async function V(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.BE_IN_STORAGE.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await q2(h), ot.success("审批通过"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  function M() {
    E.value = true;
  }
  async function g(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.NOT_PASS.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await q2(h), ot.success("驳回成功"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = qa, f = Ga, m = Ve("common-drawer");
    return w(), U(m, { visible: l(u).detailVisible, "before-close": l(u).cancelDetail, "close-on-click-modal": false, title: "项目跟进", size: "70%" }, { titleRight: p(() => [e.ApprovalFlag ? (w(), Q("div", Yde, [s(T, { type: "success", size: "default", onClick: b }, { default: p(() => h[3] || (h[3] = [Te("通过")])), _: 1, __: [3] }), s(T, { type: "danger", size: "default", onClick: M }, { default: p(() => h[4] || (h[4] = [Te("驳回")])), _: 1, __: [4] })])) : H("", true)]), content: p(() => [s(f, { title: "审批信息", border: "", column: 3 }, { default: p(() => [s(_, { label: "备案名称" }, { default: p(() => [Te(K(l(r).crmProjectInformationWarehousingName), 1)]), _: 1 }), s(_, { label: "创建人" }, { default: p(() => [Te(K(l(r).createUserName), 1)]), _: 1 }), s(_, { label: "跟进日期" }, { default: p(() => {
      var R;
      return [Te(K((R = l(r)) != null && R.followUpDate ? l($a)(l(r).followUpDate).format("YYYY-MM-DD") : "-"), 1)];
    }), _: 1 }), s(_, { label: "跟进方式" }, { default: p(() => [Te(K(l(r).followUpMethodsName), 1)]), _: 1 }), s(_, { label: "备注" }, { default: p(() => [Te(K(l(r).remark), 1)]), _: 1 })]), _: 1 }), s(dl, { showView: "", "show-download": "", files: l(r).followUpAttachment, "onUpdate:files": h[0] || (h[0] = (R) => l(r).followUpAttachment = R), "file-classify": l(cl).RECORD_ATT.V, disabled: true, "del-disabled": true, style: { "margin-top": "20px" } }, null, 8, ["files", "file-classify"]), s(js, { modelValue: E.value, "onUpdate:modelValue": h[1] || (h[1] = (R) => E.value = R), onRejectSuccess: g }, null, 8, ["modelValue"]), s(Fs, { modelValue: y.value, "onUpdate:modelValue": h[2] || (h[2] = (R) => y.value = R), onConfirmSuccess: V }, null, 8, ["modelValue"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, f8 = ut(Kde, [["__scopeId", "data-v-8eeb3ced"]]), Wde = Object.freeze(Object.defineProperty({ __proto__: null, default: f8 }, Symbol.toStringTag, { value: "Module" }));
const jde = { key: 0 }, Fde = { __name: "check-give-up", props: { componentName: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { crud: u, detail: r } = qi(), E = Z(false), y = Z(false);
  function b() {
    y.value = true;
  }
  async function V(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.BE_IN_STORAGE.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await Z2(h), ot.success("审批通过"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  function M() {
    E.value = true;
  }
  async function g(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.NOT_PASS.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await Z2(h), ot.success("驳回成功"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = qa, f = Ga, m = Ve("common-drawer");
    return w(), U(m, { visible: l(u).detailVisible, "before-close": l(u).cancelDetail, "close-on-click-modal": false, title: "项目放弃", size: "70%" }, { titleRight: p(() => [e.ApprovalFlag ? (w(), Q("div", jde, [s(T, { type: "success", size: "default", onClick: b }, { default: p(() => h[3] || (h[3] = [Te("通过")])), _: 1, __: [3] }), s(T, { type: "danger", size: "default", onClick: M }, { default: p(() => h[4] || (h[4] = [Te("驳回")])), _: 1, __: [4] })])) : H("", true)]), content: p(() => [s(f, { title: "审批信息", border: "", column: 3 }, { default: p(() => [s(_, { label: "备案名称" }, { default: p(() => [Te(K(l(r).crmProjectInformationWarehousingName), 1)]), _: 1 }), s(_, { label: "放弃日期" }, { default: p(() => {
      var R;
      return [Te(K((R = l(r)) != null && R.abandonDate ? l($a)(l(r).abandonDate).format("YYYY-MM-DD") : "-"), 1)];
    }), _: 1 }), s(_, { label: "备注" }, { default: p(() => [Te(K(l(r).remark), 1)]), _: 1 })]), _: 1 }), s(dl, { showView: "", "show-download": "", files: l(r).abandonAttachment, "onUpdate:files": h[0] || (h[0] = (R) => l(r).abandonAttachment = R), "file-classify": l(cl).RECORD_ATT.V, disabled: true, "del-disabled": true, style: { "margin-top": "20px" } }, null, 8, ["files", "file-classify"]), s(js, { modelValue: E.value, "onUpdate:modelValue": h[1] || (h[1] = (R) => E.value = R), onRejectSuccess: g }, null, 8, ["modelValue"]), s(Fs, { modelValue: y.value, "onUpdate:modelValue": h[2] || (h[2] = (R) => y.value = R), onConfirmSuccess: V }, null, 8, ["modelValue"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, g8 = ut(Fde, [["__scopeId", "data-v-2831cf0e"]]), zde = Object.freeze(Object.defineProperty({ __proto__: null, default: g8 }, Symbol.toStringTag, { value: "Module" }));
const Bde = { key: 0 }, Hde = { __name: "check-antecedent-trial", props: { componentName: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { crud: u, detail: r } = qi(), E = Z(false), y = Z(false);
  function b() {
    y.value = true;
  }
  async function V(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.BE_IN_STORAGE.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await G2(h), ot.success("审批通过"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  function M() {
    E.value = true;
  }
  async function g(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.NOT_PASS.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await G2(h), ot.success("驳回成功"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = qa, f = Ga, m = Ve("common-drawer");
    return w(), U(m, { visible: l(u).detailVisible, "before-close": l(u).cancelDetail, "close-on-click-modal": false, title: "资格预审", size: "70%" }, { titleRight: p(() => [e.ApprovalFlag ? (w(), Q("div", Bde, [s(T, { type: "success", size: "default", onClick: b }, { default: p(() => h[3] || (h[3] = [Te("通过")])), _: 1, __: [3] }), s(T, { type: "danger", size: "default", onClick: M }, { default: p(() => h[4] || (h[4] = [Te("驳回")])), _: 1, __: [4] })])) : H("", true)]), content: p(() => [s(f, { title: "审批信息", border: "", column: 3 }, { default: p(() => [s(_, { label: "备案名称" }, { default: p(() => [Te(K(l(r).crmProjectInformationWarehousingName), 1)]), _: 1 }), s(_, { label: "创建人" }, { default: p(() => [Te(K(l(r).createUserName), 1)]), _: 1 }), s(_, { label: "预审费用" }, { default: p(() => [Te(K(l(r).cost), 1)]), _: 1 }), s(_, { label: "文件受理地点	" }, { default: p(() => [Te(K(l(r).address), 1)]), _: 1 }), s(_, { label: "文件受理截止日	" }, { default: p(() => {
      var R;
      return [Te(K((R = l(r)) != null && R.deadlineForAcceptanceTime ? l($a)(l(r).deadlineForAcceptanceTime).format("YYYY-MM-DD") : "-"), 1)];
    }), _: 1 }), s(_, { label: "邮箱" }, { default: p(() => [Te(K(l(r).email), 1)]), _: 1 }), s(_, { label: "备注" }, { default: p(() => [Te(K(l(r).remark), 1)]), _: 1 })]), _: 1 }), s(dl, { showView: "", "show-download": "", files: l(r).attachmentList, "onUpdate:files": h[0] || (h[0] = (R) => l(r).attachmentList = R), "file-classify": l(cl).RECORD_ATT.V, disabled: true, "del-disabled": true, style: { "margin-top": "20px" } }, null, 8, ["files", "file-classify"]), s(js, { modelValue: E.value, "onUpdate:modelValue": h[1] || (h[1] = (R) => E.value = R), onRejectSuccess: g }, null, 8, ["modelValue"]), s(Fs, { modelValue: y.value, "onUpdate:modelValue": h[2] || (h[2] = (R) => y.value = R), onConfirmSuccess: V }, null, 8, ["modelValue"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, E8 = ut(Hde, [["__scopeId", "data-v-e6a55bbb"]]), qde = Object.freeze(Object.defineProperty({ __proto__: null, default: E8 }, Symbol.toStringTag, { value: "Module" }));
const Gde = { key: 0 }, Qde = { __name: "check-tender", props: { componentName: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { crud: u, detail: r } = qi(), E = Z(false), y = Z(false);
  function b() {
    y.value = true;
  }
  async function V(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.BE_IN_STORAGE.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await Q2(h), ot.success("审批通过"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  function M() {
    E.value = true;
  }
  async function g(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.NOT_PASS.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await Q2(h), ot.success("驳回成功"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = qa, f = Ga, m = Ve("common-drawer");
    return w(), U(m, { visible: l(u).detailVisible, "before-close": l(u).cancelDetail, "close-on-click-modal": false, title: "投标申请", size: "70%" }, { titleRight: p(() => [e.ApprovalFlag ? (w(), Q("div", Gde, [s(T, { type: "success", size: "default", onClick: b }, { default: p(() => h[3] || (h[3] = [Te("通过")])), _: 1, __: [3] }), s(T, { type: "danger", size: "default", onClick: M }, { default: p(() => h[4] || (h[4] = [Te("驳回")])), _: 1, __: [4] })])) : H("", true)]), content: p(() => [s(f, { title: "审批信息", border: "", column: 3 }, { default: p(() => [s(_, { label: "备案企业名称" }, { default: p(() => [Te(K(l(r).crmEnterpriseWarehousingName), 1)]), _: 1 }), s(_, { label: "项目名称" }, { default: p(() => [Te(K(l(r).projectName), 1)]), _: 1 }), s(_, { label: "项目编号" }, { default: p(() => [Te(K(l(r).projectSerialNumber), 1)]), _: 1 }), s(_, { label: "企业名称" }, { default: p(() => [Te(K(l(r).companyName), 1)]), _: 1 }), s(_, { label: "创建人" }, { default: p(() => [Te(K(l(r).createUserName), 1)]), _: 1 }), s(_, { label: "填报人" }, { default: p(() => [Te(K(l(r).informantUserName), 1)]), _: 1 }), s(_, { label: "计划完工日期" }, { default: p(() => [Te(K(l(r).endDate ? l($a)(l(r).endDate).format("YYYY-MM-DD") : "-"), 1)]), _: 1 }), s(_, { label: "投标保证金截止日" }, { default: p(() => [Te(K(l(r).tenderBondDeadline ? l($a)(l(r).tenderBondDeadline).format("YYYY-MM-DD") : "-"), 1)]), _: 1 }), s(_, { label: "填报日期" }, { default: p(() => [Te(K(l(r).informantDateTime ? l($a)(l(r).informantDateTime).format("YYYY-MM-DD") : "-"), 1)]), _: 1 }), s(_, { label: "招标方式" }, { default: p(() => [Te(K(l(r).biddingMethodName), 1)]), _: 1 }), s(_, { label: "评标方式	" }, { default: p(() => [Te(K(l(r).bidEvaluationMethodName), 1)]), _: 1 }), s(_, { label: "履约保证金金额" }, { default: p(() => [Te(K(l(r).cashDeposit), 1)]), _: 1 }), s(_, { label: "招标控制价" }, { default: p(() => [Te(K(l(r).controlledBiddingPrice), 1)]), _: 1 }), s(_, { label: "所属部门" }, { default: p(() => [Te(K(l(r).departmentName), 1)]), _: 1 }), s(_, { label: "开户行" }, { default: p(() => [Te(K(l(r).depositBank), 1)]), _: 1 }), s(_, { label: "材料调差" }, { default: p(() => [Te(K(l(r).materialAdjustment), 1)]), _: 1 }), s(_, { label: "备注" }, { default: p(() => [Te(K(l(r).materialBrandRegulations), 1)]), _: 1 }), s(_, { label: "材料品牌规定" }, { default: p(() => [Te(K(l(r).materialBrandRegulations), 1)]), _: 1 }), s(_, { label: "样品" }, { default: p(() => [Te(K(l(r).offerSample), 1)]), _: 1 }), s(_, { label: "付款方式" }, { default: p(() => [Te(K(l(r).paymentMethod), 1)]), _: 1 }), s(_, { label: "结算方式" }, { default: p(() => [Te(K(l(r).settlementMethodName), 1)]), _: 1 }), s(_, { label: "标书提交方式" }, { default: p(() => [Te(K(l(r).tenderSubmissionMethodName), 1)]), _: 1 }), s(_, { label: "履约保证金类型" }, { default: p(() => [Te(K(l(r).typeOfPerformanceBondName), 1)]), _: 1 }), s(_, { label: "标书需求" }, { default: p(() => [Te(K(l(r).tenderRequirement), 1)]), _: 1 }), s(_, { label: "保修期限" }, { default: p(() => [Te(K(l(r).warrantyDate), 1)]), _: 1 }), s(_, { label: "保修比例" }, { default: p(() => [Te(K(l(r).warrantyRatio), 1)]), _: 1 }), s(_, { label: "备注" }, { default: p(() => [Te(K(l(r).remark), 1)]), _: 1 })]), _: 1 }), s(dl, { showView: "", "show-download": "", files: l(r).attachmentDTOList, "onUpdate:files": h[0] || (h[0] = (R) => l(r).attachmentDTOList = R), "file-classify": l(cl).RECORD_ATT.V, disabled: true, "del-disabled": true, style: { "margin-top": "20px" } }, null, 8, ["files", "file-classify"]), s(js, { modelValue: E.value, "onUpdate:modelValue": h[1] || (h[1] = (R) => E.value = R), onRejectSuccess: g }, null, 8, ["modelValue"]), s(Fs, { modelValue: y.value, "onUpdate:modelValue": h[2] || (h[2] = (R) => y.value = R), onConfirmSuccess: V }, null, 8, ["modelValue"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, y8 = ut(Qde, [["__scopeId", "data-v-c817ab48"]]), Zde = Object.freeze(Object.defineProperty({ __proto__: null, default: y8 }, Symbol.toStringTag, { value: "Module" })), Jde = (e) => {
  const o = Ht(), n = o.state.config.dict, c = e.filter((u) => n[u] === void 0);
  return c.length > 0 && o.dispatch("config/fetchDict", c), Ee(() => o.state.config.dict);
};
const Xde = { key: 0 }, $de = { __name: "check-record", props: { componentName: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = Jde(["info_source"]), u = o, { crud: r, detail: E } = qi(), y = Z(false), b = Z(false);
  function V() {
    b.value = true;
  }
  async function M(h) {
    try {
      const T = { opinion: h, dataId: E.id, decision: jl.BE_IN_STORAGE.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await J2(T), ot.success("审批通过"), r.cancelDetail(), u("auditSuccess");
    } catch (T) {
      console.log(T);
    }
  }
  function g() {
    y.value = true;
  }
  async function S(h) {
    try {
      const T = { opinion: h, dataId: E.id, decision: jl.NOT_PASS.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await J2(T), ot.success("驳回成功"), r.cancelDetail(), u("auditSuccess");
    } catch (T) {
      console.log(T);
    }
  }
  return (h, T) => {
    const _ = Ve("common-button"), f = qa, m = Ga, R = Ve("common-drawer");
    return w(), U(R, { visible: l(r).detailVisible, "before-close": l(r).cancelDetail, "close-on-click-modal": false, title: "项目备案", size: "70%" }, { titleRight: p(() => [e.ApprovalFlag ? (w(), Q("div", Xde, [s(_, { type: "success", size: "default", onClick: V }, { default: p(() => T[3] || (T[3] = [Te("通过")])), _: 1, __: [3] }), s(_, { type: "danger", size: "default", onClick: g }, { default: p(() => T[4] || (T[4] = [Te("驳回")])), _: 1, __: [4] })])) : H("", true)]), content: p(() => [s(m, { title: "审批信息", border: "", column: 3 }, { default: p(() => [s(f, { label: "备案名称" }, { default: p(() => [Te(K(l(E).crmEnterpriseWarehousingName), 1)]), _: 1 }), s(f, { label: "备案号" }, { default: p(() => [Te(K(l(E).serialNumber), 1)]), _: 1 }), s(f, { label: "项目名称" }, { default: p(() => [Te(K(l(E).projectName), 1)]), _: 1 }), s(f, { label: "项目编号" }, { default: p(() => [Te(K(l(E).projectSerialNumber), 1)]), _: 1 }), s(f, { label: "项目概况" }, { default: p(() => [Te(K(l(E).projectOverview), 1)]), _: 1 }), s(f, { label: "项目类别" }, { default: p(() => [Te(K(l(E).itemCategoryName), 1)]), _: 1 }), s(f, { label: "重点项目" }, { default: p(() => [Te(K(l(E).keyProjectName), 1)]), _: 1 }), s(f, { label: "创建人" }, { default: p(() => [Te(K(l(E).createUserName), 1)]), _: 1 }), s(f, { label: "填报人" }, { default: p(() => [Te(K(l(E).informantUserName), 1)]), _: 1 }), s(f, { label: "项目信息来源" }, { default: p(() => {
      var v, N, P;
      return [Te(K((P = (N = (v = l(c)) == null ? void 0 : v.label) == null ? void 0 : N.info_source) == null ? void 0 : P[l(E).infoSource]), 1)];
    }), _: 1 }), s(f, { label: "是否项目经理配合" }, { default: p(() => [Te(K(l(ea).VL[l(E).isProjectManagerCoordinate]), 1)]), _: 1 }), s(f, { label: "项目经理" }, { default: p(() => [Te(K(l(E).projectManagerName || "-"), 1)]), _: 1 }), s(f, { label: "国省市区" }, { default: p(() => [Te(K(l(E).countryName + l(E).provinceName + l(E).cityName + l(E).regionName), 1)]), _: 1 }), s(f, { label: "详细地址" }, { default: p(() => [Te(K(l(E).address), 1)]), _: 1 }), s(f, { label: "填报日期" }, { default: p(() => [Te(K(l(E).informantDateTime ? l($a)(l(E).informantDateTime).format("YYYY-MM-DD") : "-"), 1)]), _: 1 }), s(f, { label: "招标方式" }, { default: p(() => [Te(K(l(E).biddingMethodName), 1)]), _: 1 }), s(f, { label: "结构类型" }, { default: p(() => [Te(K(l(E).structureTypeConfigurationName), 1)]), _: 1 }), s(f, { label: "承建类别" }, { default: p(() => [Te(K(l(E).typeOfContractorName), 1)]), _: 1 }), s(f, { label: "所属行业" }, { default: p(() => [Te(K(l(E).industryConfigurationName), 1)]), _: 1 }), s(f, { label: "建筑形式" }, { default: p(() => [Te(K(l(E).configurationOfArchitecturalFormName), 1)]), _: 1 }), s(f, { label: "建筑面积" }, { default: p(() => [Te(K(l(E).areaOfStructure), 1)]), _: 1 }), s(f, { label: "预估造价" }, { default: p(() => [Te(K(l(E).estimatedCost + "万元"), 1)]), _: 1 }), s(f, { label: "预估工程量" }, { default: p(() => [Te(K(l(E).estimatedWorks), 1)]), _: 1 }), s(f, { label: "备注" }, { default: p(() => [Te(K(l(E).remark), 1)]), _: 1 })]), _: 1 }), s(m, { title: "跟踪线", border: "", column: 4, style: { "margin-top": "15px" } }, { default: p(() => [s(f, { label: "建设单位" }, { default: p(() => [Te(K(l(E).aUnitClassConfigurationName), 1)]), _: 1 }), s(f, { label: "联系人名称" }, { default: p(() => [Te(K(l(E).aUnitClassConfigurationContactName), 1)]), _: 1 }), s(f, { label: "联系人职务" }, { default: p(() => [Te(K(l(E).aUnitClassConfigurationOffice), 1)]), _: 1 }), s(f, { label: "联系人电话" }, { default: p(() => [Te(K(l(E).aUnitClassConfigurationPhone), 1)]), _: 1 }), s(f, { label: "代建单位" }, { default: p(() => [Te(K(l(E).bUnitClassConfigurationName), 1)]), _: 1 }), s(f, { label: "联系人名称" }, { default: p(() => [Te(K(l(E).bUnitClassConfigurationContactName), 1)]), _: 1 }), s(f, { label: "联系人职务" }, { default: p(() => [Te(K(l(E).bUnitClassConfigurationOffice), 1)]), _: 1 }), s(f, { label: "联系人电话" }, { default: p(() => [Te(K(l(E).bUnitClassConfigurationPhone), 1)]), _: 1 }), s(f, { label: "EPC单位" }, { default: p(() => [Te(K(l(E).cUnitClassConfigurationName), 1)]), _: 1 }), s(f, { label: "联系人名称" }, { default: p(() => [Te(K(l(E).cUnitClassConfigurationContactName), 1)]), _: 1 }), s(f, { label: "联系人职务" }, { default: p(() => [Te(K(l(E).cUnitClassConfigurationOffice), 1)]), _: 1 }), s(f, { label: "联系人电话" }, { default: p(() => [Te(K(l(E).cUnitClassConfigurationPhone), 1)]), _: 1 }), s(f, { label: "设计单位" }, { default: p(() => [Te(K(l(E).dUnitClassConfigurationName), 1)]), _: 1 }), s(f, { label: "联系人名称" }, { default: p(() => [Te(K(l(E).dUnitClassConfigurationContactName), 1)]), _: 1 }), s(f, { label: "联系人职务" }, { default: p(() => [Te(K(l(E).dUnitClassConfigurationOffice), 1)]), _: 1 }), s(f, { label: "联系人电话" }, { default: p(() => [Te(K(l(E).dUnitClassConfigurationPhone), 1)]), _: 1 }), s(f, { label: "总包单位" }, { default: p(() => [Te(K(l(E).eUnitClassConfigurationName), 1)]), _: 1 }), s(f, { label: "联系人名称" }, { default: p(() => [Te(K(l(E).eUnitClassConfigurationContactName), 1)]), _: 1 }), s(f, { label: "联系人职务" }, { default: p(() => [Te(K(l(E).eUnitClassConfigurationOffice), 1)]), _: 1 }), s(f, { label: "联系人电话" }, { default: p(() => [Te(K(l(E).eUnitClassConfigurationPhone), 1)]), _: 1 })]), _: 1 }), s(dl, { showView: "", "show-download": "", files: l(E).projectAttachmentList, "onUpdate:files": T[0] || (T[0] = (v) => l(E).projectAttachmentList = v), "file-classify": l(cl).RECORD_ATT.V, disabled: true, "del-disabled": true, style: { "margin-top": "20px" } }, null, 8, ["files", "file-classify"]), s(js, { modelValue: y.value, "onUpdate:modelValue": T[1] || (T[1] = (v) => y.value = v), onRejectSuccess: S }, null, 8, ["modelValue"]), s(Fs, { modelValue: b.value, "onUpdate:modelValue": T[2] || (T[2] = (v) => b.value = v), onConfirmSuccess: M }, null, 8, ["modelValue"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, T8 = ut($de, [["__scopeId", "data-v-ed3592ca"]]), eme = Object.freeze(Object.defineProperty({ __proto__: null, default: T8 }, Symbol.toStringTag, { value: "Module" }));
const tme = { key: 0 }, ime = { __name: "check-direct-detail", props: { componentName: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 }, ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = e, c = o, { crud: u, detail: r } = qi(), E = Z(false), y = Z(false);
  function b() {
    y.value = true;
  }
  async function V(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.BE_IN_STORAGE.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await X2(h), ot.success("审批通过"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  function M() {
    E.value = true;
  }
  async function g(S) {
    try {
      const h = { opinion: S, dataId: r.id, decision: jl.NOT_PASS.V, approveRecordId: n.journalId, approveProcessTypeName: n.componentName };
      await X2(h), ot.success("驳回成功"), u.cancelDetail(), c("auditSuccess");
    } catch (h) {
      console.log(h);
    }
  }
  return (S, h) => {
    const T = Ve("common-button"), _ = qa, f = Ga, m = Ve("common-drawer");
    return w(), U(m, { visible: l(u).detailVisible, "before-close": l(u).cancelDetail, "close-on-click-modal": false, title: e.componentName === "CRMTechnologyFirectBidding" ? "直营业务" : "非直营业务", size: "70%" }, { titleRight: p(() => [e.ApprovalFlag ? (w(), Q("div", tme, [s(T, { type: "success", size: "default", onClick: b }, { default: p(() => h[2] || (h[2] = [Te("通过")])), _: 1, __: [2] }), s(T, { type: "danger", size: "default", onClick: M }, { default: p(() => h[3] || (h[3] = [Te("驳回")])), _: 1, __: [3] })])) : H("", true)]), content: p(() => [s(f, { title: "审批信息", border: "", column: 2 }, { default: p(() => [s(_, { label: "备案号" }, { default: p(() => [Te(K(l(r).serialNumber), 1)]), _: 1 }), s(_, { label: "填报日期" }, { default: p(() => [Te(K(l(Qi)(l(r).informantDateTime, "{y}-{m}-{d}")), 1)]), _: 1 }), s(_, { label: "项目名称" }, { default: p(() => [Te(K(l(r).projectName), 1)]), _: 1 }), s(_, { label: "所属部门" }, { default: p(() => [Te(K(l(r).departmentName), 1)]), _: 1 }), s(_, { label: "企业备案" }, { default: p(() => [Te(K(l(r).crmEnterpriseWarehousingName), 1)]), _: 1 }), s(_, { label: "省市区" }, { default: p(() => [Te(K(l(r).regionNames), 1)]), _: 1 }), s(_, { label: "结构类型" }, { default: p(() => [Te(K(l(r).structureTypeConfigurationName), 1)]), _: 1 }), s(_, { label: "预估造价(万元)" }, { default: p(() => [Te(K(l(r).estimatedCost), 1)]), _: 1 }), s(_, { label: "填报人" }, { default: p(() => [Te(K(l(r).informantUserName), 1)]), _: 1 }), s(_, { label: "结算业务类型" }, { default: p(() => [Te(K(l(Zc).VL[l(r).crmSettlementBusinessTypeEnum] || "-"), 1)]), _: 1 }), s(_, { label: "专项提报类型" }, { default: p(() => [Te(K(l(Qc).VL[l(r).crmSpecialBubmissionStatusEnum] || "-"), 1)]), _: 1 }), s(_, { label: "业务要点" }, { default: p(() => [Te(K(l(r).businessEssentials), 1)]), _: 1 })]), _: 1 }), s(js, { modelValue: E.value, "onUpdate:modelValue": h[0] || (h[0] = (R) => E.value = R), onRejectSuccess: g }, null, 8, ["modelValue"]), s(Fs, { modelValue: y.value, "onUpdate:modelValue": h[1] || (h[1] = (R) => y.value = R), onConfirmSuccess: V }, null, 8, ["modelValue"])]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} }, _8 = ut(ime, [["__scopeId", "data-v-f0cb9cfe"]]), ame = Object.freeze(Object.defineProperty({ __proto__: null, default: _8 }, Symbol.toStringTag, { value: "Module" }));
const lme = { key: 1, class: "footer" }, ome = { key: 0 }, nme = { key: 1 }, sme = { key: 0 }, rme = { key: 1 }, ume = { key: 0 }, cme = { key: 1 }, dme = { key: 0 }, mme = { key: 1 }, pme = { key: 0 }, hme = { key: 1 }, fme = { key: 0 }, gme = { key: 1 }, Eme = { key: 0 }, yme = { key: 1 }, Tme = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const { CRUD: n, crud: c, detail: u } = qi(), r = o, E = e, y = Z(), b = Z(false);
  async function V(M) {
    try {
      b.value = true;
      const g = { wageAdjustId: u.id, approvalResult: M, remark: y.value };
      await nO(g), r("auditSuccess");
    } catch (g) {
      console.log("退库(审批流)审核提交", g);
    } finally {
      b.value = false;
    }
  }
  return (M, g) => {
    const S = Ve("common-button"), h = La, T = pa, _ = qa, f = Ga, m = vt, R = Ve("common-table"), v = Mt, N = Ve("common-drawer"), P = oi;
    return w(), Q("div", null, [s(N, { ref: "drawerRef", "before-close": l(c).cancelDetail, "content-loading": l(c).detailLoading, "show-close": true, title: "工价修改", visible: l(c).detailVisible, size: "70%" }, { titleRight: p(() => {
      var L, O;
      return [((O = (L = l(u)) == null ? void 0 : L.approveRecord) == null ? void 0 : O.length) !== 0 ? (w(), U(h, { key: 0, width: 400, placement: "bottom", trigger: "click" }, { reference: p(() => [s(S, { size: "default" }, { default: p(() => g[3] || (g[3] = [Te("查看审批记录")])), _: 1, __: [3] })]), default: p(() => {
        var x;
        return [s(tl, { data: ((x = l(u)) == null ? void 0 : x.approveRecord) || [] }, null, 8, ["data"])];
      }), _: 1 })) : H("", true), E.ApprovalFlag ? (w(), Q("div", lme, [s(T, { title: "确认通过", onConfirm: g[0] || (g[0] = (x) => V(l(Lt).PASS.V)) }, { reference: p(() => [s(S, { loading: b.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => g[4] || (g[4] = [Te("通过")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 }), s(T, { title: "确认驳回", onConfirm: g[1] || (g[1] = (x) => V(l(Lt).REFUSE.V)) }, { reference: p(() => [s(S, { loading: b.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => g[5] || (g[5] = [Te(" 驳回")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 })])) : H("", true)];
    }), content: p(() => [s(f, { class: "descriptions-style", data: M.detailData, column: 2, size: "large", border: "" }, { default: p(() => [s(_, { align: "center", label: "项目" }, { default: p(() => {
      var L, O, x, I;
      return [C("span", null, K(((O = (L = l(u)) == null ? void 0 : L.project) == null ? void 0 : O.serialNumber) || "-") + " - " + K(((I = (x = l(u)) == null ? void 0 : x.project) == null ? void 0 : I.shortName) || "-"), 1)];
    }), _: 1 }), s(_, { align: "center", label: "单体" }, { default: p(() => {
      var L, O;
      return [C("span", null, K(((O = (L = l(u)) == null ? void 0 : L.monomer) == null ? void 0 : O.name) || "-"), 1)];
    }), _: 1 }), s(_, { align: "center", label: "数量" }, { default: p(() => {
      var L;
      return [C("span", null, K(((L = l(u)) == null ? void 0 : L.totalQuantity) || "-"), 1)];
    }), _: 1 }), s(_, { align: "center", label: "重量" }, { default: p(() => {
      var L;
      return [C("span", null, K(((L = l(u)) == null ? void 0 : L.totalWeight) || "-") + " kg", 1)];
    }), _: 1 }), s(_, { align: "center", label: "工序" }, { default: p(() => {
      var L, O;
      return [C("span", null, K(((O = (L = l(u)) == null ? void 0 : L.process) == null ? void 0 : O.name) || "-"), 1)];
    }), _: 1 }), s(_, { align: "center", label: "车间" }, { default: p(() => {
      var L, O;
      return [C("span", null, K(((O = (L = l(u)) == null ? void 0 : L.workshop) == null ? void 0 : O.name) || "-"), 1)];
    }), _: 1 }), s(_, { align: "center", label: "班组", span: 1 }, { default: p(() => {
      var L, O, x, I;
      return [(O = (L = l(u)) == null ? void 0 : L.teamList) != null && O.length ? (w(), Q("span", ome, K((I = (x = l(u)) == null ? void 0 : x.teamList) == null ? void 0 : I.map((Y) => {
        var ee, B;
        return Y.name + "-" + ((B = (ee = l(u)) == null ? void 0 : ee.process) == null ? void 0 : B.name);
      }).join("、 ")), 1)) : (w(), Q("span", nme, "全部班组"))];
    }), _: 1 }), s(_, { align: "center", label: "" })]), _: 1 }, 8, ["data"]), qe((w(), U(R, { ref: "tableRef", data: l(u).productList, "empty-text": l(c).emptyText, "max-height": M.maxHeight, style: { width: "100%" } }, { default: p(() => [s(m, { label: "序号", type: "index", align: "center", width: "60" }), s(m, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", "min-width": "120" }, { default: p((L) => {
      var O;
      return [C("span", null, K(((O = L.row.product) == null ? void 0 : O.serialNumber) || "-"), 1)];
    }), _: 1 }), s(m, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "120" }, { default: p((L) => {
      var O;
      return [C("span", null, K(((O = L.row.product) == null ? void 0 : O.specification) || "-"), 1)];
    }), _: 1 }), s(m, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center", width: "80" }, { default: p((L) => {
      var O;
      return [C("span", null, K(((O = L.row.product) == null ? void 0 : O.quantity) || "-"), 1)];
    }), _: 1 }), s(m, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": "", label: "执行定额", align: "center" }, { default: p((L) => [C("span", null, K(L.row.quotaNumber || "-"), 1)]), _: 1 }), s(m, { key: "organizationInsidePrice", prop: "organizationInsidePrice", "show-overflow-tooltip": "", label: "编制内定额工价", align: "center" }, { default: p((L) => [L.row.organizationInsidePrice || L.row.organizationInsidePrice === 0 ? (w(), Q("span", sme, K(l(Mi)(L.row.organizationInsidePrice, 2)) + " 元/" + K(L.row.unit || "?"), 1)) : (w(), Q("span", rme, "-"))]), _: 1 }), s(m, { key: "organizationOutsidePrice", prop: "organizationOutsidePrice", "show-overflow-tooltip": "", label: "编制外定额工价", align: "center" }, { default: p((L) => [L.row.organizationOutsidePrice || L.row.organizationOutsidePrice === 0 ? (w(), Q("span", ume, K(l(Mi)(L.row.organizationOutsidePrice, 2)) + " 元/" + K(L.row.unit || "?"), 1)) : (w(), Q("span", cme, "-"))]), _: 1 }), s(m, { key: "newOrganizationInsidePrice", prop: "newOrganizationInsidePrice", "show-overflow-tooltip": "", label: "编制内新工价", align: "center" }, { default: p((L) => [L.row.newOrganizationInsidePrice || L.row.newOrganizationInsidePrice === 0 ? (w(), Q("span", dme, K(l(Mi)(L.row.newOrganizationInsidePrice, 2)) + " 元/" + K(L.row.unit || "?"), 1)) : (w(), Q("span", mme, "-"))]), _: 1 }), s(m, { key: "newOrganizationOutsidePrice", prop: "newOrganizationOutsidePrice", "show-overflow-tooltip": "", label: "编制外新工价", align: "center" }, { default: p((L) => [L.row.newOrganizationOutsidePrice || L.row.newOrganizationOutsidePrice === 0 ? (w(), Q("span", pme, K(l(Mi)(L.row.newOrganizationOutsidePrice, 2)) + " 元/" + K(L.row.unit || "?"), 1)) : (w(), Q("span", hme, "-"))]), _: 1 }), s(m, { key: "float", prop: "float", "show-overflow-tooltip": "", label: "编制内浮动", align: "center" }, { default: p((L) => [L.row.newOrganizationInsidePrice && L.row.organizationInsidePrice ? (w(), Q("span", fme, K(l(Mi)(L.row.newOrganizationInsidePrice - L.row.organizationInsidePrice, 2)) + " 元/" + K(L.row.unit || "?"), 1)) : (w(), Q("span", gme, "-"))]), _: 1 }), s(m, { key: "float", prop: "float", "show-overflow-tooltip": "", label: "编制外浮动", align: "center" }, { default: p((L) => [L.row.newOrganizationOutsidePrice && L.row.organizationOutsidePrice ? (w(), Q("span", Eme, K(l(Mi)(L.row.newOrganizationOutsidePrice - L.row.organizationOutsidePrice, 2)) + " 元/" + K(L.row.unit || "?"), 1)) : (w(), Q("span", yme, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[P, l(c).loading]]), E.ApprovalFlag ? (w(), U(v, { key: 0, modelValue: y.value, "onUpdate:modelValue": g[2] || (g[2] = (L) => y.value = L), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "visible"])]);
  };
} }, b8 = ut(Tme, [["__scopeId", "data-v-8fb3979f"]]), _me = Object.freeze(Object.defineProperty({ __proto__: null, default: b8 }, Symbol.toStringTag, { value: "Module" })), ugt = { get: ["my_project:get"], statistics: ["my_project:statistics"], print: ["my_project:print"] }, cgt = { get: ["mes_change_list:get"], save: ["mes_change_list:save"], detail: ["mes_change_list:detail"] }, dgt = { get: ["mes_change_record:get"], audit: ["mes_change_record:audit"] }, mgt = { get: ["mes_surplus_list:get"], secondUse: ["mes_surplus_list:secondUse"], scrap: ["mes_surplus_list:scrap"] }, pgt = { download: ["mes_finished_product_change:download"] }, hgt = { get: ["artifact_change_log:get"], detail: ["artifact_change_log:detail"], audit: ["artifact_change_log:audit"] }, fgt = { get: ["mes_scheduling_artifact:get"], taskAchieved: ["mes_scheduling_artifact:taskAchieved"], save: ["mes_scheduling_artifact:save"], import: ["mes_scheduling_artifact:import"], recordGet: ["mes_scheduling_artifact_record:get"], recordEdit: ["mes_scheduling_artifact_record:edit"], recordDel: ["mes_scheduling_artifact_record:del"], assembleGet: ["mes_scheduling_assemble:get"], assembleSave: ["mes_scheduling_assemble:save"] }, ggt = { get: ["mes_scheduling_machine_part:get"], noNestingSave: ["mes_scheduling_machine_part:noNestingSave"], nestingSave: ["mes_scheduling_machine_part:nestingSave"], unProductDel: ["mes_scheduling_machine_part:unProductDel"], unProductDelRecord: ["mes_scheduling_machine_part:unProductDelRecord"], downFile: ["mes_scheduling_machine_part:downFile"] }, Egt = { get: ["mes_scheduling_section_machine_part:get"], noNestingSave: ["mes_scheduling_section_machine_part:noNestingSave"], downFile: ["mes_scheduling_section_machine_part:downFile"], unProductDel: ["mes_scheduling_machine_part:unProductDel"], unProductDelRecord: ["mes_scheduling_machine_part:unProductDelRecord"] }, ygt = { get: ["scheduling_data:get"], statistics: ["scheduling_data:statistics"], print: ["scheduling_data:print"] }, Tgt = { get: ["mes_scheduling_machine_part_record:get"], del: ["mes_scheduling_machine_part_record:del"], detail: ["mes_scheduling_machine_part_record:detail"], save: ["mes_scheduling_machine_part_record:save"] }, _gt = { get: ["mes_scheduling_machine_part_nesting_result:get"], del: ["mes_scheduling_machine_part_nesting_result:del"], document: ["mes_scheduling_machine_part_nesting_result:document"], downloadZip: ["mes_scheduling_machine_part_nesting_result:downloadZip"], scheduling: ["mes_scheduling_machine_part_nesting_result:scheduling"], revocation: ["mes_scheduling_machine_part_nesting_result:revocation"], batchDownloadReportForm: ["mes_scheduling_machine_part_nesting_result:batchDownloadReportForm"] }, bgt = { get: ["mes_cloud_cutting_assistant:get"], createProject: ["mes_cloud_cutting_assistant:createProject"], createOrder: ["mes_cloud_cutting_assistant:createOrder"], del: ["mes_cloud_cutting_assistant:del"], import: ["mes_cloud_cutting_assistant:import"], allot: ["mes_cloud_cutting_assistant:allot"], batchAllot: ["mes_cloud_cutting_assistant:batchAllot"], taskDel: ["mes_cloud_cutting_assistant:taskDel"] }, Vgt = { get: ["mes_production-monitoring-kanban:get"], statistics: ["mes_production-monitoring-kanban:statistics"], status: ["mes_production-monitoring-kanban:status"], print: ["mes_production-monitoring-kanban:print"] }, wgt = { get: ["mes_work_order_artifact:get"], detail: ["mes_work_order_artifact:detail"], print: ["mes_work_order_artifact:print"], edit: ["mes_work_order_artifact:edit"], cancelEdit: ["mes_work_order_artifact:cancelEdit"], revoke: ["mes_work_order_artifact:revoke"], batchRevoke: ["mes_work_order_artifact:batchRevoke"], allRevoke: ["mes_work_order_artifact:allRevoke"] }, Sgt = { get: ["mes_work_order_machine_part:get"], detail: ["mes_work_order_machine_part:detail"], print: ["mes_work_order_machine_part:print"] }, vgt = { get: ["mes_work_order_drill:get"], detail: ["mes_work_order_drill:detail"], print: ["mes_work_order_drill:print"] }, Rgt = { get: ["mes_production_machine_part_report:get"], print: ["mes_production_machine_part_report:print"] }, Mgt = { get: ["mes_production_assemble_report:get"], print: ["mes_production_assemble_report:print"] }, Agt = { get: ["mes_production_artifact_report:get"], print: ["mes_production_artifact_report:print"] }, Ngt = { get: ["mes_production_enclosure_report:get"], print: ["mes_production_enclosure_report:print"] }, Lgt = { get: ["mes_production_statistics:get"], detail: ["mes_production_statistics:detail"], print: ["mes_production_statistics:print"], printDetail: ["mes_production_statistics:printDetail"] }, Igt = { get: ["mes_production_analysis_delay_report:get"], detail: ["mes_production_analysis_delay_report:detail"], printDetail: ["mes_production_analysis_delay_report:printDetail"] }, Cgt = { get: ["mes_yield_confirm_unaudited_list:get"], detail: ["mes_yield_confirm_unaudited_list:detail"], pass: ["mes_yield_confirm_unaudited_list:pass"] }, Pgt = { get: ["mes_yield_confirm_audited_list:get"], detail: ["mes_yield_confirm_audited_list:detail"], print: ["mes_yield_confirm_audited_list:print"] }, Ogt = { get: ["mes_yield_confirm_apportion_report:get"], print: ["mes_yield_confirm_apportion_report:print"] }, kgt = { get: ["mes_wage_statistics_year:get"] }, Dgt = { get: ["mes_wage_statistics_month:get"], detail: ["mes_wage_statistics_month:detail"], downloadSummary: ["mes_wage_statistics_month:downloadSummary"], downloadDetail: ["mes_wage_statistics_month:downloadDetail"] }, xgt = { get: ["mes_project_dashboard_product:get"], shipGet: ["mes_project_dashboard_product_ship:get"], qcGet: ["mes_project_dashboard_product_qc:get"] }, Ugt = { get: ["mes_main_material_track:get"], print: ["mes_main_material_track:print"], useRecordGet: ["mes_main_material_track_use_record:get"], useRecordPrint: ["mes_main_material_track_use_record:print"], stockGet: ["mes_main_material_track_stock:get"], stockPrint: ["mes_main_material_track_stock:print"] }, Ygt = { get: ["mes_artifact_production_dashboard:get"] }, Kgt = { get: ["mes_enclosure_production_dashboard:get"] }, Wgt = { get: ["mes_project_report:get"], print: ["mes_project_report:print"] }, jgt = { get: ["mes_assembly_match:get"], print: ["mes_assembly_match:print"], printDetail: ["mes_assembly_match:printDetail"] }, Fgt = { get: ["mes_painting:get"], edit: ["mes_painting:edit"], editArea: ["mes_painting:editArea"], print: ["mes_painting:print"] }, zgt = { getTotal: ["mes_project_production_total_list:get"], getProduciton: ["mes_project_production_pt_list:get"], getTeamGroup: ["mes_project_production_team_group_list:get"], getPickList: ["mes_project_production_pick_list:get"], printProduciton: ["mes_project_production_pt_list:print"], printTeamGroup: ["mes_project_production_team_group_list:print"], printPickList: ["mes_project_production_pick_list:print"] }, Bgt = { get: ["mes_project_panel:get"], getFormList: ["mes_project_panel_form_list:get"], detailGouJian: ["mes_project_panel_form_goujian:detail"], detailTask: ["mes_project_panel_form_detail_task:detail"], printTask: ["mes_project_panel_form_print_task:print"], download: ["mes_project_production_panel:download"], getCardList: ["mes_project_panel_card_list:get"], detailLingBuJian: ["mes_project_panel_card_lingbujian:detail"], detailProcess: ["mes_project_panel_card_process:detail"] }, Hgt = { get: ["mes_team_report_artifact:get"], print: ["mes_team_report_artifact:print"], detail: ["mes_team_report_artifact:detail"], processDetail: ["mes_team_report_artifact_process:detail"], printDetail: ["mes_team_report_artifact_process:printDetail"] }, qgt = { get: ["mes_team_report_enclosure:get"], print: ["mes_team_report_enclosure:print"], detail: ["mes_team_report_enclosure:detail"] }, Ggt = { get: ["mes_team_wage_artifact:get"], print: ["mes_team_wage_artifact:print"], detail: ["mes_team_wage_artifact:detail"], printDetail: ["mes_team_wage_artifact:printDetail"] }, Qgt = { get: ["mes_in_staff_wages_adjust:get"], edit: ["mes_in_staff_wages_adjust:edit"], audit: ["mes_in_staff_wages_adjust:audit"] }, Zgt = { get: ["mes_off_staff_wages_adjust:get"], edit: ["mes_off_staff_wages_adjust:edit"], audit: ["mes_off_staff_wages_adjust:audit"] }, Jgt = { get: ["mes_quality_inspection_report:get"], detail: ["mes_quality_inspection_report:detail"] }, Xgt = { get: ["mes_production_line_report:get"], detail: ["mes_production_line_report:detail"], print: ["mes_production_line_report:print"] }, $gt = { get: ["mes_qhse_disclosure:get"], export: ["mes_qhse_disclosure:export"] }, e1t = { get: ["safety_and_quality_statistics:get"], detail: ["safety_and_quality_statistics:detail"], export: ["safety_and_quality_statistics:export"] }, t1t = { get: ["safety_quality_inspection_manage:get"], detail: ["safety_quality_inspection_manage:detail"], settingGet: ["safety_quality_inspection_manage:settingGet"], settingEdit: ["safety_quality_inspection_manage:settingEdit"], setting: ["safety_quality_inspection_manage:setting"], pointHistory: ["safety_quality_inspection_manage:pointHistory"], del: ["safety_quality_inspection_manage:del"], audit: ["safety_quality_inspection_manage:audit"], passAudit: ["safety_quality_inspection_manage:passAudit"], rejectAudit: ["safety_quality_inspection_manage:rejectAudit"] }, i1t = { get: ["inspect-realtime:get"], detail: ["inspect-realtime:detail"], export: ["inspect-realtime:export"] }, a1t = { get: ["quality-problem-statistics:get"], detail: ["quality-problem-statistics:detail"], export: ["quality-problem-statistics:export"] }, l1t = { get: ["inspect-statistics:get"], detail: ["inspect-statistics:detail"], export: ["inspect-statistics:export"] }, o1t = { get: ["random-inspection-statistics:get"], detail: ["random-inspection-statistics:detail"], export: ["random-inspection-statistics:export"], detailExport: ["random-inspection-statistics:detailExport"] }, n1t = { get: ["paint_film_record:get"], detail: ["paint_film_record:detail"] }, s1t = { get: ["mes_label_artifact:get"], printSetting: ["mes_label_artifact:printSetting"], traceabilitySetting: { get: ["mes_label_artifact:traceabilitySettingGet"], edit: ["mes_label_artifact:traceabilitySettingEdit"] }, batchPrint: ["mes_label_artifact:batchPrint"], print: ["mes_label_artifact:print"], preview: ["mes_label_artifact:preview"], record: ["mes_label_artifact:record"] }, r1t = { get: ["mes_label_return_repair:get"] }, u1t = { get: ["mes_label_part:get"] }, c1t = { get: ["mes_label_auxiliary_material:get"], printSetting: ["mes_label_auxiliary_material:printSetting"], batchPrint: ["mes_label_auxiliary_material:batchPrint"], print: ["mes_label_auxiliary_material:print"], preview: ["mes_label_auxiliary_material:preview"], record: ["mes_label_auxiliary_material:record"] }, d1t = { get: ["mes_state_artifact_inbound_dashboard:get"] }, m1t = { get: ["mes_state_enclosure_inbound_dashboard:get"] }, p1t = { get: ["mes_state_artifact_outbound_dashboard:get"] }, h1t = { get: ["mes_state_enclosure_outbound_dashboard:get"] }, f1t = { get: ["mes_state_artifact_warehouse:get"], print: ["mes_state_artifact_warehouse:print"] }, g1t = { get: ["mes_state_enclosure_warehouse:get"], print: ["mes_state_enclosure_warehouse:print"] }, E1t = { get: ["mes_state_report_warehouse:get"], print: ["mes_state_report_warehouse:print"], detail: ["mes_state_report_warehouse:detail"] }, y1t = { get: ["artifact-specification-revise:get"], edit: ["artifact-specification-revise:edit"] }, T1t = { get: ["mes_extrusion_nesting:get"], detail: ["mes_extrusion_nesting:detail"], import: ["mes_extrusion_nesting:detail"] }, _1t = { get: ["mes_nesting_setting:get"], extrusionNestingDetail: ["mes_nesting_setting:extrusionNestingDetail"], noNesting: ["mes_nesting_setting:noNesting"], noNestingDetail: ["mes_nesting_setting:noNestingDetail"], moveOutNoNestingList: ["mes_nesting_setting:moveOutNoNestingList"], extrusionNesting: ["mes_nesting_setting:extrusionNesting"], downloadResult: ["mes_nesting_setting:downloadResult"], saveNestingResult: ["mes_nesting_setting:saveNestingResult"], delNestingResult: ["mes_nesting_setting:delNestingResult"] }, b1t = { get: ["mes_nesting_result:get"], detail: ["mes_nesting_result:detail"], issued: ["mes_nesting_result:issued"], downloadZip: ["mes_nesting_result:downloadZip"], del: ["mes_nesting_result:del"], downloadList: ["mes_nesting_result:downloadList"], closed: ["mes_nesting_result:closed"] }, V1t = { get: ["mes_production_order:get"], detail: ["mes_production_order:detail"], edit: ["mes_production_order:edit"], detailList: ["mes_production_order:detailList"] }, w1t = { get: ["mes_schedule_detail:get"], print: ["mes_schedule_detail:print"] }, S1t = { get: ["mes_ship_summary:get"], print: ["mes_ship_summary:print"] }, p2 = { pack: ["mes_manual_pack:pack"] }, v1t = { get: ["mes_manual_pack_artifact:get"], pack: p2.pack };
p2.pack;
const R1t = { get: ["mes_pack:get"], detail: ["mes_pack:detail"], edit: p2.pack, del: ["mes_pack:del"], print: ["mes_pack:print"], printRecords: ["mes_pack:printRecords"], printPackList: ["mes_pack:printPackList"] }, M1t = { get: ["mes_ship:get"], detail: ["mes_ship:detail"], print: ["mes_ship:print"], detailPrint: ["mes_ship:detailPrint"] }, A1t = { get: ["mes_receipt_status:get"], detail: ["mes_receipt_status:detail"], print: ["mes_receipt_status:print"], detailPrint: ["mes_receipt_status:detailPrint"], cancelDelivery: ["mes_receipt_status:cancelDelivery"], confirmDelivery: ["mes_receipt_status:confirmDelivery"] }, N1t = { get: ["mes_logistics:get"], edit: ["mes_logistics:edit"], print: ["mes_logistics:print"] }, L1t = { get: ["mes_ship_audit:get"], detail: ["mes_ship_audit:detail"], print: ["mes_ship_audit:print"], download: ["mes_ship_audit:download"], audit: ["mes_ship_audit:audit"] }, I1t = { get: ["mes_product-send-receive-storage:get"], print: ["mes_product-send-receive-storage:print"], detail: ["mes_product-send-receive-storage:detail"], detailPrint: ["mes_product-send-receive-storage:detailPrint"] }, C1t = { get: ["mes_work_order_tracking:get"], orderDetail: ["mes_work_order_tracking:orderDetail"], processDetail: ["mes_work_order_tracking:processDetail"], print: ["mes_work_order_tracking:print"], detail: ["mes_work_order_tracking:detail"] }, P1t = { get: ["mes_monthly_task_tracking:get"], print: ["mes_monthly_task_tracking:print"] }, O1t = { get: ["mes_workshop_task_status:get"], statistics: ["mes_workshop_task_status:statistics"], groupStatus: ["mes_workshop_task_status:groupStatus"], print: ["mes_workshop_task_status:print"] }, k1t = { get: ["mes_production_line_tracking:get"], detail: ["mes_production_line_tracking:detail"], print: ["mes_production_line_tracking:print"] }, D1t = { get: ["mes_process_sluggish:get"], print: ["mes_process_sluggish:print"] }, x1t = { get: ["mes_production_line_assistance:get"], save: ["mes_production_line_assistance:save"], record: ["mes_production_line_assistance:record"] }, U1t = { get: ["mes_process_assistance:get"], save: ["mes_process_assistance:save"], del: ["mes_process_assistance:del"] }, Y1t = { get: ["mes_wip_statistics:get"], print: ["mes_wip_statistics:print"] }, K1t = { get: ["mes_semi_finished:get"], print: ["mes_semi_finished:print"] }, W1t = { get: ["mes_project_overview:get"], detail: ["mes_project_overview:detail"], print: ["mes_project_overview:print"] }, j1t = { get: ["mes_project_material:get"], print: ["mes_project_material:print"] }, F1t = { get: ["mes_production_tracking:get"] }, z1t = { get: ["mes_install_attendance_report:get"], settingStand: ["mes_install_attendance_report:settingStand"], detail: ["mes_install_attendance_report:detail"], settingOvertime: ["mes_install_attendance_report:settingOvertime"], export: ["mes_install_attendance_report:export"] }, B1t = { get: ["mes_factory_report:get"], print: ["mes_factory_report:print"] }, H1t = { get: ["mes_group_report:get"], print: ["mes_group_report:print"] }, q1t = { get: ["mes_product_statistics:get"], print: ["mes_product_statistics:print"] }, G1t = { get: ["mes_production_statistics:get"], statistics: ["mes_production_statistics:statistics"], export: ["mes_production_statistics:export"] }, Q1t = { get: ["mes_stud_sleeve_statistics:get"], print: ["mes_stud_sleeve_statistics:print"] }, Z1t = { get: ["mes_wage_adjust:get"], edit: ["mes_wage_adjust:edit"] }, J1t = { get: ["mes_loss_statistics:get"], export: ["mes_loss_statistics:export"], productionDetail: ["mes_loss_statistics:productionDetail"], productionExport: ["mes_loss_statistics:productionExport"], receiveDetail: ["mes_loss_statistics:receiveDetail"], receivePrint: ["mes_loss_statistics:receivePrint"] }, X1t = { get: ["mes_loss_wip_statistics:get"], download: ["mes_loss_wip_statistics:download"], detail: ["mes_loss_wip_statistics:detail"] }, $1t = { get: ["mes_work_in_progress_statistics:get"], export: ["mes_work_in_progress_statistics:export"] }, eEt = { get: ["mes_loss_statistics_v2:get"], print: ["mes_loss_statistics_v2:print"] }, tEt = { get: ["mes_behavior_score:get"], violationRecordDetail: ["mes_behavior_score:violationRecordDetail"], addScore: ["mes_behavior_score:addScore"], config: ["mes_behavior_score:config"], violationRecordPrint: ["mes_behavior_score:violationRecordPrint"] }, iEt = { get: ["mes_delay_notify:get"], detail: ["mes_delay_notify:detail"], print: ["mes_delay_notify:print"] }, aEt = { get: ["mes_team_production:get"], print: ["mes_team_production:print"], download: ["mes_team_production:download"] }, lEt = { get: ["mes_team_ability_analysis:get"], export: ["mes_team_ability_analysis:export"] }, oEt = { get: ["mes_personal_production_statistics:get"], export: ["mes_personal_production_statistics:export"], detail: ["mes_personal_production_statistics:detail"], detailExport: ["mes_personal_production_statistics:detailExport"] }, nEt = { get: ["mes_daily_production_statistics:get"], export: ["mes_daily_production_statistics:export"], PackDetail: ["mes_daily_production_statistics:PackDetail"], PackDetailPrint: ["mes_daily_production_statistics:PackDetailPrint"], productionDetail: ["mes_daily_production_statistics:productionDetail"], productionDetailPrint: ["mes_daily_production_statistics:productionDetailPrint"] }, sEt = { get: ["mes_work_reporting_record:get"], print: ["mes_work_reporting_record:print"] }, rEt = { get: ["mes_capp_welding_record:get"], edit: ["mes_capp_welding_record:edit"] }, uEt = { get: ["mes_finished_product:get"], detail: ["mes_finished_product:detail"], export: ["mes_finished_product:export"], detailExport: ["mes_finished_product:detailExport"] }, cEt = { get: ["mes_annual_production:get"], export: ["mes_annual_production:export"] }, dEt = { get: ["mes_team_scheduling:get"], detail: ["mes_team_scheduling:detail"], export: ["mes_team_scheduling:export"] }, mEt = { get: ["mes_make_monthly:get"], export: ["mes_make_monthly:export"] }, pEt = { get: ["machine_part_quota_config:get"], add: ["machine_part_quota_config:add"], edit: ["machine_part_quota_config:edit"], del: ["machine_part_quota_config:del"], status: ["machine_part_quota_config:status"] }, hEt = { get: ["assemble_quota_config:get"], add: ["assemble_quota_config:add"], edit: ["assemble_quota_config:edit"], del: ["assemble_quota_config:del"], status: ["assemble_quota_config:status"] }, fEt = { get: ["artifact_quota_config:get"], add: ["artifact_quota_config:add"], edit: ["artifact_quota_config:edit"], del: ["artifact_quota_config:del"], status: ["artifact_quota_config:status"] }, gEt = { get: ["painting_quota_config:get"], add: ["painting_quota_config:add"], edit: ["painting_quota_config:edit"], del: ["painting_quota_config:del"] }, EEt = { get: ["auxiliary_material_config:get"], add: ["auxiliary_material_config:add"], edit: ["auxiliary_material_config:edit"], del: ["auxiliary_material_config:del"] }, yEt = { get: ["mes_hourly_work_confi:get"], add: ["mes_hourly_work_confi:add"], edit: ["mes_hourly_work_confi:edit"], del: ["mes_hourly_work_confi:del"], status: ["mes_hourly_work_confi:status"] }, TEt = { get: ["enclosure_product_quota:get"], add: ["enclosure_product_quota:add"], edit: ["enclosure_product_quota:edit"], del: ["enclosure_product_quota:del"] }, _Et = { get: ["mes_work_review:get"], download: ["mes_work_review:download"], passTheAudit: ["mes_work_review:passTheAudit"], eliminate: ["mes_work_review:eliminate"], whiteListConfig: ["mes_work_review:whiteListConfig"], wageAdjustment: ["mes_work_review:wageAdjustment"] }, bEt = { get: ["mes_manual_filling:get"], save: ["mes_manual_filling:save"] }, VEt = { get: ["mes_group_payroll_summary:get"], groupPayrollSummaryPrint: ["mes_group_payroll_summary:groupPayrollSummaryPrint"], details: ["mes_group_payroll_summary:details"], detailsPrint: ["mes_group_payroll_summary:detailsPrint"] }, wEt = { get: ["mes_feedstock_reporting:get"], add: ["mes_feedstock_reporting:add"], details: ["mes_feedstock_reporting:details"] }, SEt = { get: ["mes_hourly_work_record:get"], download: ["mes_hourly_work_record:download"] }, bme = { get: ["mes_coating_process:get"], add: ["mes_coating_process:add"], paintConfig: ["mes_coating_process:paintConfig"], print: ["mes_coating_process:print"], detailsPrint: ["mes_coating_process:detailsPrint"], export: ["mes_coating_process:export"], details: ["mes_coating_process:details"], secondaryEdit: ["mes_coating_process:secondaryEdit"], cancellation: ["mes_coating_process:cancellation"] }, vEt = { get: ["enclosure_checklist:get"], add: ["enclosure_checklist:add"], del: ["enclosure_checklist:del"], download: ["enclosure_checklist:download"] }, REt = { get: ["mes_paint_technology:list"], listDetail: ["mes_paint_technology:list-detail"], config: ["mes_paint_technology:config"], calcSave: ["mes_paint_technology:calc-save"], statPrint: ["mes_paint_technology:stat-print"], statDetail: ["mes_paint_technology:stat-detail"], listPrint: ["mes_paint_technology:list-print"], statListPrint: ["mes_paint_technology:stat-list-print"], statDel: ["mes_paint_technology:stat-del"] };
const Vme = { key: 1, class: "footer" }, wme = { key: 0, style: { "margin-bottom": "10px", color: "red" } }, Sme = { key: 0 }, vme = { key: 1 }, Rme = { key: 0 }, Mme = { key: 1 }, Ame = { key: 0 }, Nme = { key: 1 }, Lme = { key: 0 }, Ime = { key: 1 }, Cme = { key: 0 }, Pme = { key: 1 }, Ome = { key: 0 }, kme = { key: 1 }, Dme = { __name: "detail-V2", props: { ApprovalFlag: { type: Boolean, default: false }, editFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess", "recompose"], setup(e, { emit: o }) {
  const n = Ht(), { crud: c, detail: u } = qi(), r = o, E = Z(), y = Z(), b = Ee(() => u.boolInvalid && u.approvalStatus === Lt.PASS.V), V = Ee(() => u.boolInvalid && u.approvalStatus === Lt.AUDITING.V), M = Ee(() => u.approvalStatus === Lt.AUDITING.V);
  async function g() {
    try {
      await zi.confirm("确定要编辑这条数据吗？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const T = JSON.parse(JSON.stringify(u));
      r("recompose", T), c.cancelDetail();
    } catch (T) {
      console.log("二次编辑", T);
    }
  }
  async function S() {
    try {
      await zi.confirm("您选择了作废操作，是否确认？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await dO({ id: u == null ? void 0 : u.id }), c.refresh(), c.cancelDetail(), await n.dispatch("approval_list/fetchApprovalNum"), Di({ title: "作废审核提交成功", type: "success", duration: 3e3 });
    } catch (T) {
      console.log("作废审核", T);
    }
  }
  async function h(T) {
    try {
      y.value = true;
      const _ = { id: u.id, status: T, opinion: E.value };
      await uO(_), r("auditSuccess");
    } catch (_) {
      console.log("涂装工艺审核提交", _);
    } finally {
      y.value = false;
    }
  }
  return Ce(() => c.detailVisible, (T) => {
    E.value = void 0;
  }, { deep: true, immediate: true }), (T, _) => {
    const f = wi, m = Ve("print-table"), R = Ve("common-button"), v = La, N = pa, P = qa, L = Ga, O = vt, x = Ve("common-table"), I = Mt, Y = Ve("common-drawer"), ee = _t("permission");
    return w(), U(Y, { ref: "drawerRef", "before-close": l(c).cancelDetail, "content-loading": l(c).detailLoading, "show-close": true, title: "工艺明细单", visible: l(c).detailVisible, size: "55%" }, { titleAfter: p(() => {
      var B, q;
      return [e.ApprovalFlag ? H("", true) : (w(), Q(Qe, { key: 0 }, [b.value ? (w(), U(f, { key: 0, type: "danger", effect: "plain" }, { default: p(() => _[3] || (_[3] = [Te(" 已作废 ")])), _: 1, __: [3] })) : V.value ? (w(), U(f, { key: 1, type: "warning", effect: "plain" }, { default: p(() => _[4] || (_[4] = [Te(" 作废审批中 ")])), _: 1, __: [4] })) : (w(), U(f, { key: 2, type: (q = l(Lt).V[(B = l(u)) == null ? void 0 : B.approvalStatus]) == null ? void 0 : q.TAG, effect: "plain" }, { default: p(() => {
        var ae;
        return [Te(K(l(Lt).VL[(ae = l(u)) == null ? void 0 : ae.approvalStatus] || "-"), 1)];
      }), _: 1 }, 8, ["type"]))], 64))];
    }), titleRight: p(() => {
      var B, q;
      return [qe(s(m, { "api-key": "paintingCraftListDetailPrint", params: { id: l(u).id }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[ee, l(bme).detailsPrint]]), ((q = (B = l(u)) == null ? void 0 : B.approveRecord) == null ? void 0 : q.length) !== 0 ? (w(), U(v, { key: 0, width: 400, placement: "bottom", trigger: "click" }, { reference: p(() => [s(R, { size: "default" }, { default: p(() => _[5] || (_[5] = [Te("查看审批记录")])), _: 1, __: [5] })]), default: p(() => {
        var ae;
        return [s(l(tl), { data: ((ae = l(u)) == null ? void 0 : ae.approveRecord) || [] }, null, 8, ["data"])];
      }), _: 1 })) : H("", true), e.ApprovalFlag ? (w(), Q("div", Vme, [s(N, { title: "确认通过", onConfirm: _[0] || (_[0] = (ae) => h(l(Lt).PASS.V)) }, { reference: p(() => [s(R, { loading: y.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => _[6] || (_[6] = [Te("通过")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 }), s(N, { title: "确认驳回", onConfirm: _[1] || (_[1] = (ae) => h(l(Lt).REFUSE.V)) }, { reference: p(() => [s(R, { loading: y.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => _[7] || (_[7] = [Te(" 驳回")])), _: 1, __: [7] }, 8, ["loading"])]), _: 1 })])) : H("", true), l(Ai)(l(c).permission.secondaryEdit) && !e.ApprovalFlag && e.editFlag && !b.value && !V.value ? (w(), U(R, { key: 2, type: "warning", size: "default", onClick: g }, { default: p(() => _[8] || (_[8] = [Te(" 修改 ")])), _: 1, __: [8] })) : H("", true), l(Ai)(l(c).permission.cancellation) && !e.ApprovalFlag && e.editFlag && !b.value && !M.value ? (w(), U(R, { key: 3, type: "danger", size: "default", onClick: S }, { default: p(() => _[9] || (_[9] = [Te(" 作废 ")])), _: 1, __: [9] })) : H("", true)];
    }), content: p(() => {
      var B;
      return [e.ApprovalFlag && V.value ? (w(), Q("div", wme, "作废申请，审批通过后该数据将作废！")) : H("", true), s(L, { data: l(u), column: 3, size: "large", border: "", style: { "margin-bottom": "20px" } }, { default: p(() => [s(P, { align: "center", label: "项目：" }, { default: p(() => {
        var q, ae, j, le;
        return [C("span", null, K((ae = (q = l(u)) == null ? void 0 : q.project) == null ? void 0 : ae.serialNumber) + " - " + K((le = (j = l(u)) == null ? void 0 : j.project) == null ? void 0 : le.shortName), 1)];
      }), _: 1 }), s(P, { align: "center", label: "单体：" }, { default: p(() => {
        var q, ae, j, le, oe;
        return [(ae = (q = l(u)) == null ? void 0 : q.monomerList) != null && ae.length ? (w(), Q("span", Sme, K((oe = (le = (j = l(u)) == null ? void 0 : j.monomerList) == null ? void 0 : le.map((ye) => ye.name)) == null ? void 0 : oe.join("、")), 1)) : (w(), Q("span", vme, "全部单体"))];
      }), _: 1 }), s(P, { align: "center", label: "面积（㎡）：" }, { default: p(() => {
        var q;
        return [C("span", null, K(((q = l(u)) == null ? void 0 : q.surfaceArea) || "-"), 1)];
      }), _: 1 }), s(P, { align: "center", label: "定额编号:" }, { default: p(() => {
        var q;
        return [C("span", null, K(((q = l(u)) == null ? void 0 : q.serialNumber) || "-"), 1)];
      }), _: 1 }), s(P, { align: "center", label: "创建人：" }, { default: p(() => {
        var q, ae;
        return [C("span", null, K(((ae = (q = l(u)) == null ? void 0 : q.createUser) == null ? void 0 : ae.name) || "-"), 1)];
      }), _: 1 }), s(P, { align: "center", label: "创建日期：" }, { default: p(() => {
        var q, ae;
        return [C("span", null, K((q = l(u)) != null && q.createDate ? l(Qi)((ae = l(u)) == null ? void 0 : ae.createDate, "{y}-{m}-{d}") : "-"), 1)];
      }), _: 1 }), e.ApprovalFlag ? H("", true) : (w(), Q(Qe, { key: 0 }, [s(P, { align: "center", label: "审核人：" }, { default: p(() => {
        var q, ae;
        return [C("span", null, K(((ae = (q = l(u)) == null ? void 0 : q.approvalUser) == null ? void 0 : ae.name) || "-"), 1)];
      }), _: 1 }), s(P, { align: "center", label: "审核日期：" }, { default: p(() => {
        var q, ae;
        return [C("span", null, K((q = l(u)) != null && q.approvalTime ? l(Qi)((ae = l(u)) == null ? void 0 : ae.approvalTime, "{y}-{m}-{d}") : "-"), 1)];
      }), _: 1 }), s(P, { align: "center", label: "" })], 64))]), _: 1 }, 8, ["data"]), s(x, { ref: "tableRef", border: "", data: (B = l(u)) == null ? void 0 : B.detailList, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: p(() => [s(O, { label: "序号", type: "index", align: "center", width: "60" }), s(O, { prop: "paintingTypeEnum", label: "油漆类型", "show-overflow-tooltip": "", align: "center" }, { default: p((q) => [l(A)(q.row.paintingTypeEnum) ? (w(), Q("span", Rme, K(l(Ac).VL[q.row.paintingTypeEnum]), 1)) : (w(), Q("span", Mme, "-"))]), _: 1 }), s(O, { prop: "paintBrand", label: "油漆品牌", "show-overflow-tooltip": "", align: "center" }, { default: p((q) => [C("span", null, K(q.row.paintBrand || "-"), 1)]), _: 1 }), s(O, { prop: "paintType", label: "油漆材质", "show-overflow-tooltip": "", align: "center" }, { default: p((q) => [C("span", null, K(q.row.paintType || "-"), 1)]), _: 1 }), s(O, { prop: "paintFilmThickness", label: "漆膜厚度（μm）", "show-overflow-tooltip": "", align: "center" }, { default: p((q) => {
        var ae;
        return [l(A)(q.row.paintFilmThickness) ? (w(), Q("span", Ame, K((ae = q.row.paintFilmThickness) == null ? void 0 : ae.toFixed(2)), 1)) : (w(), Q("span", Nme, "-"))];
      }), _: 1 }), s(O, { prop: "lossCoefficient", label: "损耗系数", "show-overflow-tooltip": "", align: "center" }, { default: p((q) => {
        var ae;
        return [l(A)(q.row.lossCoefficient) ? (w(), Q("span", Lme, K((ae = q.row.lossCoefficient) == null ? void 0 : ae.toFixed(2)), 1)) : (w(), Q("span", Ime, "-"))];
      }), _: 1 }), s(O, { prop: "weight", label: "油漆用量（kg）", "show-overflow-tooltip": "", align: "center" }, { default: p((q) => {
        var ae;
        return [l(A)(q.row.weight) ? (w(), Q("span", Cme, K((ae = q.row.weight) == null ? void 0 : ae.toFixed(2)), 1)) : (w(), Q("span", Pme, "-"))];
      }), _: 1 }), s(O, { prop: "quantity", label: "数量", "show-overflow-tooltip": "", align: "center" }, { default: p((q) => {
        var ae;
        return [l(A)(q.row.quantity) ? (w(), Q("span", Ome, K((ae = q.row.quantity) == null ? void 0 : ae.toFixed(2)), 1)) : (w(), Q("span", kme, "-"))];
      }), _: 1 })]), _: 1 }, 8, ["data"]), e.ApprovalFlag ? (w(), U(I, { key: 1, modelValue: E.value, "onUpdate:modelValue": _[2] || (_[2] = (q) => E.value = q), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "20px" }, autosize: { minRows: 3, maxRows: 3 }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)];
    }), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, V8 = ut(Dme, [["__scopeId", "data-v-191ec23f"]]), xme = Object.freeze(Object.defineProperty({ __proto__: null, default: V8 }, Symbol.toStringTag, { value: "Module" })), Qb = { __name: "raw-mat", props: { columns: { type: Object }, showUnitPriceE: { type: Boolean, default: false }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showInputVAT: { type: Boolean, default: true }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true } }, setup(e) {
  const o = e, n = Ee(() => o.showInvoiceType && (Ae(o.columns) || o.columns.visible("invoiceType"))), c = Ee(() => o.showTaxRate && (Ae(o.columns) || o.columns.visible("taxRate"))), u = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("unitPrice"))), r = Ee(() => o.showAmountExcludingVAT && o.showUnitPriceE && (Ae(o.columns) || o.columns.visible("unitPriceExcludingVat"))), E = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("amount"))), y = Ee(() => o.showAmountExcludingVAT && (Ae(o.columns) || o.columns.visible("amountExcludingVat"))), b = Ee(() => o.showInputVAT && (Ae(o.columns) || o.columns.visible("inputVat")));
  return (V, M) => {
    const g = vt;
    return w(), Q(Qe, null, [n.value ? (w(), U(g, { key: "invoiceType", prop: "invoiceType", label: "票据类型", align: "center", "min-width": "70px", "show-overflow-tooltip": "" })) : H("", true), c.value ? (w(), U(g, { key: "taxRate", prop: "taxRate", label: "税率", align: "center", "min-width": "70", "show-overflow-tooltip": "" })) : H("", true), u.value ? (w(), U(g, { key: "unitPrice", prop: "unitPrice", label: "含税单价", align: "right", "min-width": "90px", "show-overflow-tooltip": "" })) : H("", true), E.value ? (w(), U(g, { key: "amount", prop: "amount", label: "含税金额", align: "right", "min-width": "105px", "show-overflow-tooltip": "" })) : H("", true), r.value ? (w(), U(g, { key: "unitPriceExcludingVat", prop: "unitPriceExcludingVat", label: "不含税单价", align: "right", "min-width": "90px", "show-overflow-tooltip": "" })) : H("", true), y.value ? (w(), U(g, { key: "amountExcludingVat", prop: "amountExcludingVat", label: "不含税金额", align: "right", "min-width": "105px", "show-overflow-tooltip": "" })) : H("", true), b.value ? (w(), U(g, { key: "inputVat", prop: "inputVat", label: "进项税", align: "right", "min-width": "90px", "show-overflow-tooltip": "" })) : H("", true)], 64);
  };
} }, Ume = { __name: "index", props: { basicClass: { type: Number }, columns: { type: Object }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return Qb;
      default:
        return Qb;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { columns: e.columns, "show-invoice-type": e.showInvoiceType, "show-tax-rate": e.showTaxRate, "show-amount": e.showAmount, "show-amount-excluding-v-a-t": e.showAmountExcludingVAT }, null, 8, ["columns", "show-invoice-type", "show-tax-rate", "show-amount", "show-amount-excluding-v-a-t"]));
} };
